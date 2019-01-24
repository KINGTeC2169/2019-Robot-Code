package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.util.Constants;

public class DriveTrain {
    Controls controls;
    DoubleSolenoid solenoid;
    TalonSRX left;
    TalonSRX leftTop;
    TalonSRX leftBottom;
    TalonSRX right;
    TalonSRX rightTop;
    TalonSRX rightBottom;
    private double deadpan;

    public DriveTrain(Controls controls){
        this.controls = controls;
        solenoid = new DoubleSolenoid(0, 0, 0);
        deadpan = Constants.driveTrainDeadpan;

        left = new TalonSRX(0);
        leftTop = new TalonSRX(0);
        leftBottom = new TalonSRX(0);
        leftTop.set(ControlMode.Follower, 0);
        leftBottom.set(ControlMode.Follower, 0);
        right = new TalonSRX(0);
        rightTop = new TalonSRX(0);
        rightBottom = new TalonSRX(0);
        rightTop.set(ControlMode.Follower, 0);
        rightBottom.set(ControlMode.Follower, 0);
    }

    public void drive() {
        double powerLeft = controls.leftjoy.getRawAxis(1);
        double powerRight = controls.rightjoy.getRawAxis(1);
        if(Math.abs(powerLeft) >= deadpan) {
            left.set(ControlMode.PercentOutput, powerLeft);
        }
        if(Math.abs(powerRight) >= deadpan) {
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
