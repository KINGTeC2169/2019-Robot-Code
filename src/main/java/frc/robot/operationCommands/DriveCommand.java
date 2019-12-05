package frc.robot.operationCommands;

import frc.robot.Main;
import frc.robot.util.Controls;

public class DriveCommand {

    private Controls controls;

    DriveCommand(Controls controls){
        this.controls = controls;
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

    public boolean isCheesyDrive(){
        return controls.getCheesyMode();
    }

    public boolean getQuickturn(){
        return controls.getSlowMode();
    }

    public double getLeftDrive() {
        return controls.getLeftDrive();
    }

    public double getRightDrive() {
        return controls.getRightDrive();
    }

    public double getSteer() {
        return controls.getSteer();
    }

    public boolean isShiftUp() {
        return controls.shiftUpButton();
    }

    public boolean isShiftDown() {
        return controls.shiftDownButton();
    }

    public boolean isVisionDriving() {
        return controls.visionDriving();
    }
}
