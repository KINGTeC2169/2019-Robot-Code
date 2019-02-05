package frc.robot.operationCommands;

public class DriveCommand {

    private double visionYaw = -5;
    private double leftDrive;
    private double rightDrive;
    private boolean shiftUp;
    private boolean shiftDown;
    private boolean visionDriving;

    DriveCommand(double leftDrive, double rightDrive, boolean shiftUp, boolean shiftDown){
        this.leftDrive = leftDrive;
        this.rightDrive = rightDrive;
        this.shiftUp = shiftUp;
        this.shiftDown = shiftDown;
    }

    public void setVisionData(double visionYaw, double isVisionDriving){

    }

    public boolean isVisionDataPresent(){
        return Math.abs(-5-visionYaw) < .1;
    }

    public double getVisionYaw() {
        return visionYaw;
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
        return visionDriving;
    }



}
