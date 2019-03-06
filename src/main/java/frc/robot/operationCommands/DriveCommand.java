package frc.robot.operationCommands;

import frc.robot.Main;

public class DriveCommand {

    private final double leftDrive;
    private final double rightDrive;
    private final boolean shiftUp;
    private final boolean shiftDown;
    private final boolean rightTrigger;

    DriveCommand(double leftDrive, double rightDrive, boolean shiftUp, boolean shiftDown, boolean rightTrigger){
        this.leftDrive = leftDrive;
        this.rightDrive = rightDrive;
        this.shiftUp = shiftUp;
        this.shiftDown = shiftDown;
        this.rightTrigger = rightTrigger;
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
