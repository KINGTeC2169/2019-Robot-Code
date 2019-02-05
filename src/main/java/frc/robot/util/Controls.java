package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;

@SuppressWarnings("FieldCanBeLocal")
public class Controls {

    private final int leftjoyPort = 0;
    private final int rightjoyPort = 1;
    private final int operatorJoyPort = 2;

    private Joystick leftjoy;
    private Joystick rightjoy;
    private Joystick operatorStick;
    private Joystick operatorPanel;

    public Controls() {
        leftjoy = new Joystick(leftjoyPort);
        rightjoy = new Joystick(rightjoyPort);
        operatorStick = new Joystick(operatorJoyPort);
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
        return leftjoy.getRawButtonPressed(3) || rightjoy.getRawButtonPressed(3);
    }

    public double getOperatorStickY(){
        return operatorStick.getRawAxis(1);
    }

    public boolean getOperatorTrigger() {
        return operatorStick.getTrigger();
    }

    public double getOperatorPanelState(){
        return operatorPanel.getRawAxis(0);
    }

}
