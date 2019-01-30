package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;

public class Arm extends Subsystem{

    TalonSRX arm;

    public Arm() {

        arm = new TalonSRX(ActuatorMap.armMaster);
        VictorSPX armSlave = new VictorSPX(ActuatorMap.armSlave);
        armSlave.set(ControlMode.Follower, ActuatorMap.armMaster);

    }

    public void handle(SuperstructureCommand sCommand) {

    }

    @Override
    public void zeroSensors() {
        arm.setSelectedSensorPosition(0,0,10);
    }

    @Override
    public void stop() {
        arm.set(ControlMode.PercentOutput, 0);
    }
}
