package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.operationCommands.DriveCommand;
import frc.robot.util.ActuatorMap;
import frc.robot.util.Constants;
import frc.robot.util.PID;

public class DriveTrain {

    //private final DoubleSolenoid dogShift;
    private final TalonSRX left;
    private final TalonSRX right;
    private Solenoid dog;

    private PID pid;

    public DriveTrain(){

        dog = new Solenoid(ActuatorMap.pcmPort, ActuatorMap.driveShifter);

        //Initialize left side of the driveline
        left = new TalonSRX(ActuatorMap.driveTrainLeft);
        VictorSPX leftTop = new VictorSPX(ActuatorMap.driveTrainLeftTop);
        VictorSPX leftBottom = new VictorSPX(ActuatorMap.driveTrainLeftBottom);

        left.setInverted(true);
        leftTop.setInverted(false);
        leftBottom.setInverted(true);

        leftTop.follow(left);
        leftBottom.follow(left);

        //Initialize right side of the driveline
        right = new TalonSRX(ActuatorMap.driveTrainRight);
        VictorSPX rightTop = new VictorSPX(ActuatorMap.driveTrainRightTop);
        VictorSPX rightBottom = new VictorSPX(ActuatorMap.driveTrainRightBottom);

        right.setInverted(true);
        rightBottom.setInverted(false);
        rightTop.setInverted(false);

        rightTop.follow(right);
        rightBottom.follow(right);

        pid = new PID(0.25, 0, 0);

        SmartDashboard.putNumber("dP", 0.25);
        SmartDashboard.putNumber("dI", 0);
        SmartDashboard.putNumber("dD", 0);
        SmartDashboard.putNumber("Throttle Multiplier", .25);
    }

    public void handle(DriveCommand dCommand) {
        double p = SmartDashboard.getNumber("dP", 0);
        double i = SmartDashboard.getNumber("dI", 0);
        double d = SmartDashboard.getNumber("dD", 0);
        pid.setPID(p, i, d);
        pid.setSetpoint(0);
        pid.setMaxIOutput(.4);
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
        turn = -turn;
        left.set(ControlMode.PercentOutput, -pid.getOutput(turn));
        right.set(ControlMode.PercentOutput, pid.getOutput(turn));
    }


    private void visionArcadeDrive(double throttle, double turn){
        double throttleMult = SmartDashboard.getNumber("Throttle Multiplier", 0);
        turn = -turn;
        left.set(ControlMode.PercentOutput, throttleMult * throttle -pid.getOutput(turn));
        right.set(ControlMode.PercentOutput, throttleMult * throttle + pid.getOutput(turn));
    }

    private void shift(DriveCommand dCommand){
        if (dCommand.isShiftUp()){
            dog.set(true);
        }
        if(dCommand.isShiftDown()){
            dog.set(false);
        }
    }

    private void drive(DriveCommand dCommand){
        if(Math.abs(dCommand.getLeftDrive()) >= Constants.driveTrainDeadband) {
            left.set(ControlMode.PercentOutput, dCommand.getLeftDrive());
        }
        else{
            left.set(ControlMode.PercentOutput, 0);
        }
        if(Math.abs(dCommand.getRightDrive()) >= Constants.driveTrainDeadband) {
            right.set(ControlMode.PercentOutput, dCommand.getRightDrive());
        }
        else{
            right.set(ControlMode.PercentOutput, 0);
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