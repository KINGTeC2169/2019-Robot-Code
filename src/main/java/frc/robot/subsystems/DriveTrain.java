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

    private final DoubleSolenoid dogShift;
    private final TalonSRX left;
    private final TalonSRX right;

    public DriveTrain(){

        //Initialize DogShift solenoid
        dogShift = new DoubleSolenoid(ActuatorMap.pcmPort, ActuatorMap.driveShiftForward, ActuatorMap.driveShiftReverse);

        //Initialize left side of the driveline
        left = new TalonSRX(ActuatorMap.driveTrainLeft);
        VictorSPX leftTop = new VictorSPX(ActuatorMap.driveTrainLeftTop);
        VictorSPX leftBottom = new VictorSPX(ActuatorMap.driveTrainLeftBottom);
        leftTop.set(ControlMode.Follower, ActuatorMap.driveTrainLeft);
        leftBottom.set(ControlMode.Follower, ActuatorMap.driveTrainLeft);

        //Initialize right side of the driveline
        right = new TalonSRX(ActuatorMap.driveTrainRight);
        VictorSPX rightTop = new VictorSPX(ActuatorMap.driveTrainRightTop);
        VictorSPX rightBottom = new VictorSPX(ActuatorMap.driveTrainRightBottom);
        rightTop.set(ControlMode.Follower, ActuatorMap.driveTrainRight);
        rightBottom.set(ControlMode.Follower, ActuatorMap.driveTrainRight);
    }

    public void handle(DriveCommand dCommand) {
        //Check if vision is driving, and if it is, allow it to move the drivetrain
        if(dCommand.isVisionDriving()){
            visionDriving(dCommand);
        }
        //If vision isn't driving, hand control over to driver
        else{
            drive(dCommand);
        }

        //Regardless of situation, shift to appropriate state
        shift(dCommand);

        //Print the state if needed
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