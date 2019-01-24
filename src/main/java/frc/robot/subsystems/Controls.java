package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class Controls {
    private int leftjoyPort = 0;
    private int rightjoyPort = 0;

    private Joystick leftjoy;
    private Joystick rightjoy;

    public Controls() {
        leftjoy = new Joystick(leftjoyPort);
        rightjoy = new Joystick(rightjoyPort);
    }

    public double getLeftjoyAxis(){
        return leftjoy.getRawAxis(0);
    }

    public double getRightjoyAxis(){
        return rightjoy.getRawAxis(1);
    }

    public boolean getLowGearButton() {
        return leftjoy.getRawButtonPressed(2) || rightjoy.getRawButtonPressed(2);
    }

    public boolean getHighGearButton() {
        return rightjoy.getRawButtonPressed(3) || rightjoy.getRawButtonPressed(3);
    }
}
