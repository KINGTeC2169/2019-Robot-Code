package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.util.ActuatorMap;
import frc.robot.util.Constants;

public class DriveTrain {

    private DoubleSolenoid solenoid;
    private TalonSRX left;
    private TalonSRX right;
    public DriveTrain(){
        solenoid = new DoubleSolenoid(0, 0, 0);

        left = new TalonSRX(ActuatorMap.driveTrainLeft);
        TalonSRX leftTop = new TalonSRX(ActuatorMap.driveTrainLeftTop);
        TalonSRX leftBottom = new TalonSRX(ActuatorMap.driveTrainLeftBottom);
        leftTop.set(ControlMode.Follower, ActuatorMap.driveTrainLeft);
        leftBottom.set(ControlMode.Follower, ActuatorMap.driveTrainLeft);

        right = new TalonSRX(ActuatorMap.driveTrainRight);
        TalonSRX rightTop = new TalonSRX(ActuatorMap.driveTrainRightTop);
        TalonSRX rightBottom = new TalonSRX(ActuatorMap.driveTrainRightBottom);
        rightTop.set(ControlMode.Follower, ActuatorMap.driveTrainRight);
        rightBottom.set(ControlMode.Follower, ActuatorMap.driveTrainRight);
    }

    public void drive(double powerLeft, double powerRight) {
        if(Math.abs(powerLeft) >= Constants.driveTrainDeadband) {
            left.set(ControlMode.PercentOutput, powerLeft);
        }
        if(Math.abs(powerRight) >= Constants.driveTrainDeadband) {
            right.set(ControlMode.PercentOutput, powerRight);
        }
    }

    public void shift(boolean low, boolean high){
        solenoid.set(Value.kForward);
        if (high){
            solenoid.set(Value.kReverse);
        }
        if(low){
            solenoid.set(Value.kForward);
        }
    }

}