package frc.robot.operationCommands;

import frc.robot.Main;

public class DriveCommand {

    private static final double visionYaw = -5;
    private final double leftDrive;
    private final double rightDrive;
    private final boolean shiftUp;
    private final boolean shiftDown;
    private boolean visionDriving;
    private final boolean rightTrigger;

    DriveCommand(double leftDrive, double rightDrive, boolean shiftUp, boolean shiftDown, boolean rightTrigger){
        this.leftDrive = leftDrive;
        this.rightDrive = rightDrive;
        this.shiftUp = shiftUp;
        this.shiftDown = shiftDown;
        this.rightTrigger = rightTrigger;
    }

    public void setVisionData(double visionYaw, double isVisionDriving){

    }

    public boolean isVisionDataPresent(){
        return Math.abs(-5-visionYaw) < .1;
    }

    public double getVisionYaw() {
        return Main.visionData;
    }

    public double getLeftDrive() {
        return leftDrive;
    }

    public double getRightDrive() {
        return rightDrive;
    }

    public boolean isShiftUp() {
        return shiftUp;
    }

    public boolean isShiftDown() {
        return shiftDown;
    }

    public boolean isVisionDriving() {
        return rightTrigger;
    }



}
