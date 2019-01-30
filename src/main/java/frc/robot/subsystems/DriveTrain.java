package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.operationCommands.DriveCommand;
import frc.robot.util.ActuatorMap;
import frc.robot.util.Constants;

public class DriveTrain {

    private DoubleSolenoid dogShift;
    private TalonSRX left;
    private TalonSRX right;

    public DriveTrain(){

        dogShift = new DoubleSolenoid(ActuatorMap.pcmPort, ActuatorMap.driveShiftForward, ActuatorMap.driveShiftReverse);

        left = new TalonSRX(ActuatorMap.driveTrainLeft);
        VictorSPX leftTop = new VictorSPX(ActuatorMap.driveTrainLeftTop);
        VictorSPX leftBottom = new VictorSPX(ActuatorMap.driveTrainLeftBottom);
        leftTop.set(ControlMode.Follower, ActuatorMap.driveTrainLeft);
        leftBottom.set(ControlMode.Follower, ActuatorMap.driveTrainLeft);

        right = new TalonSRX(ActuatorMap.driveTrainRight);
        VictorSPX rightTop = new VictorSPX(ActuatorMap.driveTrainRightTop);
        VictorSPX rightBottom = new VictorSPX(ActuatorMap.driveTrainRightBottom);
        rightTop.set(ControlMode.Follower, ActuatorMap.driveTrainRight);
        rightBottom.set(ControlMode.Follower, ActuatorMap.driveTrainRight);
    }

    public void handle(DriveCommand dCommand) {
        if(dCommand.isVisionDriving()){
            visionDriving(dCommand);
        }
        else{
            drive(dCommand);
        }

        shift(dCommand);

    }

    private void shift(DriveCommand dCommand){
        dogShift.set(Value.kForward);
        if (dCommand.isShiftUp()){
            dogShift.set(Value.kReverse);
        }
        if(dCommand.isShiftDown()){
            dogShift.set(Value.kForward);
        }
    }

    private void drive(DriveCommand dCommand){
        if(Math.abs(dCommand.getLeftDrive()) >= Constants.driveTrainDeadband) {
            left.set(ControlMode.PercentOutput, dCommand.getLeftDrive());
        }
        if(Math.abs(dCommand.getRightDrive()) >= Constants.driveTrainDeadband) {
            right.set(ControlMode.PercentOutput, dCommand.getRightDrive());
        }
    }

    private void visionDriving(DriveCommand dCommand){
        dCommand.getVisionYaw();
        //Vision Driving Code
    }

}