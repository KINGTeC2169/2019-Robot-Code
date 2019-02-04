package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;
import frc.robot.util.Constants;

public class Wrist extends Subsystem {

    private TalonSRX wristMotor;

    public enum WristState{
        SNAP_TO_ARM, STOW_HIGH, STOW_LOW, PARALLEL_TO_GROUND
    }

    private WristState wristState = WristState.SNAP_TO_ARM;

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
        wristMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.wristTimeoutMs);
        wristMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.wristTimeoutMs);

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
        wristMotor.setSelectedSensorPosition(0, Constants.wristPIDLoopIdx, Constants.wristTimeoutMs);

    }

    void handle(SuperstructureCommand sCommand) {

        switch(sCommand.getWristState()){

            case SNAP_TO_ARM:
                break;
            case STOW_HIGH:
                break;
            case STOW_LOW:
                break;
            case PARALLEL_TO_GROUND:
                break;
        }

        wristState = sCommand.getWristState();

    }

    @Override
    public void zeroSensors() {

    }

    @Override
    public void stop() {

    }
}
