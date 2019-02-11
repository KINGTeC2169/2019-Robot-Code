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

        if(Constants.debugMode){
            printData();
        }

    }

    private void turnInPlace(double turn){
        left.set(ControlMode.PercentOutput, -turn);
        right.set(ControlMode.PercentOutput, turn);
    }


    private void visionArcadeDrive(double throttle, double visionYaw){
        left.set(ControlMode.PercentOutput, throttle - visionYaw);
        left.set(ControlMode.PercentOutput, throttle + visionYaw);
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
        //Vision Driving Code
        if(Math.abs(dCommand.getLeftDrive()) > .1){
            visionArcadeDrive(dCommand.getLeftDrive(), dCommand.getVisionYaw());
        }
        else{
            turnInPlace(dCommand.getVisionYaw());
        }
    }

    private void printData(){
        System.out.println("------------------");
        System.out.println("Drive Train Data:");
        System.out.println("Left Motor Position: " + left.getSelectedSensorPosition());
        System.out.println("Right Motor Position: " + right.getSelectedSensorPosition());
        System.out.println("------------------");
    }

    public void stop(){
        left.set(ControlMode.Disabled, 1);
        right.set(ControlMode.Disabled, 1);
    }

}