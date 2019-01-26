package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.util.ActuatorMap;

public class Arm extends Subsystem{

    TalonSRX arm;

    public Arm() {

        arm = new TalonSRX(ActuatorMap.armMaster);
        TalonSRX armSlave = new TalonSRX(ActuatorMap.armSlave);
        armSlave.set(ControlMode.Follower, ActuatorMap.armMaster);

    }

    public void handle() {

    }

    @Override
    public void zeroSensors() {

    }

    @Override
    public void stop() {

    }
}
