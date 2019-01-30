package frc.robot.operationCommands;

public class DriveCommand {

    private double visionYaw;
    private double leftDrive;
    private double rightDrive;
    private boolean shiftUp;
    private boolean shiftDown;
    private boolean visionDriving;

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
