package frc.robot.operationCommands;

import frc.robot.Main;

public class DriveCommand {

    private final double leftDrive;
    private final double rightDrive;
    private final boolean shiftUp;
    private final boolean shiftDown;
    private final boolean rightTrigger;
    private final boolean slowMode;

    DriveCommand(double leftDrive, double rightDrive, boolean shiftUp, boolean shiftDown, boolean rightTrigger, boolean slowMode){
        this.leftDrive = leftDrive;
        this.rightDrive = rightDrive;
        this.shiftUp = shiftUp;
        this.shiftDown = shiftDown;
        this.rightTrigger = rightTrigger;
        this.slowMode = slowMode;
    }

    public double getVisionYaw() {
        double data = Main.visionData;
        // Cap the data at +-.5
        if(data > .5){
            return .5;
        }
        else if(data < -.5){
            return -.5;
        }
        return data;
    }

    public double getLeftDrive() {
        if(slowMode) {
            return leftDrive / 2;
        } else {
            return leftDrive;
        }
    }

    public double getRightDrive() {
        if(slowMode) {
            return rightDrive / 2;
        } else {
            return rightDrive;
        }
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

    public boolean slowMode() { return slowMode; }
}
