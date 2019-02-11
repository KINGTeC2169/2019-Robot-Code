package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;
import frc.robot.util.Constants;

public class Arm extends Subsystem{

    private final TalonSRX arm;

    Arm() {

        arm = new TalonSRX(ActuatorMap.armMaster);
        VictorSPX armSlave = new VictorSPX(ActuatorMap.armSlave);
        armSlave.set(ControlMode.Follower, ActuatorMap.armMaster);

        /* Factory default hardware to prevent unexpected behavior */
        arm.configFactoryDefault();

        /* Configure Sensor Source for Pirmary PID */
        arm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
                Constants.armPIDLoopIdx,
                Constants.armTimeoutMs);

        arm.setSensorPhase(true);
        arm.setInverted(false);

        /* Set relevant frame periods to be at least as fast as periodic rate */
        arm.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.armTimeoutMs);
        arm.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.armTimeoutMs);

        /* Set the peak and nominal outputs */
        arm.configNominalOutputForward(0, Constants.armTimeoutMs);
        arm.configNominalOutputReverse(0, Constants.armTimeoutMs);
        arm.configPeakOutputForward(1, Constants.armTimeoutMs);
        arm.configPeakOutputReverse(-1, Constants.armTimeoutMs);

        /* Set Motion Magic gains in slot0 - see documentation */
        arm.selectProfileSlot(Constants.armSlotIdx, Constants.armPIDLoopIdx);
        arm.config_kF(Constants.armSlotIdx, Constants.armF, Constants.armTimeoutMs);
        arm.config_kP(Constants.armSlotIdx, Constants.armP, Constants.armTimeoutMs);
        arm.config_kI(Constants.armSlotIdx, Constants.armI, Constants.armTimeoutMs);
        arm.config_kD(Constants.armSlotIdx, Constants.armD, Constants.armTimeoutMs);

        /* Set acceleration and vcruise velocity - see documentation */
        arm.configMotionCruiseVelocity(Constants.armMaxVel, Constants.armTimeoutMs);
        arm.configMotionAcceleration(Constants.armMaxAccel, Constants.armTimeoutMs);

        /* Zero the sensor */
        arm.setSelectedSensorPosition(0, Constants.armPIDLoopIdx, Constants.armTimeoutMs);

    }

    void handle(SuperstructureCommand sCommand) {
        if(sCommand.getOperatorOverride().getOverrideActive()){
            arm.set(ControlMode.PercentOutput, sCommand.getOperatorOverride().getLeftVal());
        }
        else{
            arm.set(ControlMode.MotionMagic, Constants.degreesToTicks(sCommand.getScoreState().getArmAngle()));
        }
    }

    boolean isInPosition(){
        return arm.getClosedLoopError() < Constants.armAllowedError;
    }

    @Override
    public void zeroSensors() {
        arm.setSelectedSensorPosition(Constants.degreesToTicks(Constants.armZeroPos),Constants.armPIDLoopIdx,Constants.armTimeoutMs);
    }

    @Override
    public void stop() {
        arm.set(ControlMode.PercentOutput, 0);
    }
}
