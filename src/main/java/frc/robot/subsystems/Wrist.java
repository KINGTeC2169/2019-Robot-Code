package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;
import frc.robot.util.Constants;

public class Wrist extends Subsystem {

    private final TalonSRX wristMotor;

    public enum WristState{
        INTAKE_FRONT, INTAKE_BACK, HIGH_FRONT, HIGH_BACK, PARALLEL_TO_GROUND
    }

    Wrist() {

        wristMotor = new TalonSRX(ActuatorMap.wristPort);

        /* Factory default hardware to prevent unexpected behavior */
        wristMotor.configFactoryDefault();

        /* Configure Sensor Source for Pirmary PID */
        wristMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
                Constants.wristPIDLoopIdx,
                Constants.wristTimeoutMs);

        wristMotor.setSensorPhase(true);
        wristMotor.setInverted(false);

        /* Set relevant frame periods to be at least as fast as periodic rate */
        wristMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0,
                10, Constants.wristTimeoutMs);
        wristMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic,
                10, Constants.wristTimeoutMs);

        /* Set the peak and nominal outputs */
        wristMotor.configNominalOutputForward(0, Constants.wristTimeoutMs);
        wristMotor.configNominalOutputReverse(0, Constants.wristTimeoutMs);
        wristMotor.configPeakOutputForward(1, Constants.wristTimeoutMs);
        wristMotor.configPeakOutputReverse(-1, Constants.wristTimeoutMs);

        /* Set Motion Magic gains in slot0 - see documentation */
        wristMotor.selectProfileSlot(Constants.wristSlotIdx, Constants.wristPIDLoopIdx);
        wristMotor.config_kF(Constants.wristSlotIdx, Constants.wristF, Constants.wristTimeoutMs);
        wristMotor.config_kP(Constants.wristSlotIdx, Constants.wristP, Constants.wristTimeoutMs);
        wristMotor.config_kI(Constants.wristSlotIdx, Constants.wristI, Constants.wristTimeoutMs);
        wristMotor.config_kD(Constants.wristSlotIdx, Constants.wristD, Constants.wristTimeoutMs);

        /* Set acceleration and vcruise velocity - see documentation */
        wristMotor.configMotionCruiseVelocity(Constants.wristMaxVel, Constants.wristTimeoutMs);
        wristMotor.configMotionAcceleration(Constants.wristMaxAccel, Constants.wristTimeoutMs);

        /* Zero the sensor */
        wristMotor.setSelectedSensorPosition(Constants.degreesToTicks(Constants.wristZeroPos),
                Constants.wristPIDLoopIdx, Constants.wristTimeoutMs);

    }

    void handle(SuperstructureCommand sCommand) {

        if(sCommand.getOperatorOverride().getOverrideActive()){
            wristMotor.set(ControlMode.PercentOutput, sCommand.getOperatorOverride().getRightVal());
            SmartDashboard.putNumber("Wrist Angle", -1);
        }

        else {

            double wristAngle = Constants.wristZeroPos;

            switch (sCommand.getWristState()) {

                case INTAKE_FRONT:
                    wristAngle = Constants.WristPositions.frontIntake;
                    break;
                case INTAKE_BACK:
                    wristAngle = Constants.WristPositions.backIntake;
                    break;
                case HIGH_FRONT:
                    wristAngle = Constants.WristPositions.frontTopCargo;
                    break;
                case HIGH_BACK:
                    wristAngle = Constants.WristPositions.backTopCargo;
                    break;
                case PARALLEL_TO_GROUND:
                    double armAngle = sCommand.getScoreState().getArmAngle();
                    if (armAngle < 180) {
                        wristAngle = 90 - armAngle;
                    } else {
                        wristAngle = 270 - armAngle;
                    }
                    break;

            }

            SmartDashboard.putNumber("Wrist Angle", wristAngle);

            wristMotor.set(ControlMode.MotionMagic, Constants.degreesToTicks(wristAngle));
        }

    }

    boolean isInPosition(){
        return wristMotor.getClosedLoopError() < Constants.wristAllowedError;
    }

    @Override
    public void zeroSensors() {
        wristMotor.setSelectedSensorPosition(Constants.degreesToTicks(Constants.wristZeroPos), Constants.wristPIDLoopIdx, Constants.wristTimeoutMs);
    }

    @Override
    public void stop() {

    }
}
