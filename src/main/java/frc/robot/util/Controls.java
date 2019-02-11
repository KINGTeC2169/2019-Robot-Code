package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.operationCommands.ScoreState;

@SuppressWarnings("FieldCanBeLocal")
public class Controls {

    private final int leftJoyPort = 0;
    private final int rightJoyPort = 1;
    private final int operatorJoyPort = 2;

    private Joystick leftJoy;
    private Joystick rightJoy;
    private Joystick operatorStick;
    private OperatorPanel operatorPanel;

    public Controls() {
        leftJoy = new Joystick(leftJoyPort);
        rightJoy = new Joystick(rightJoyPort);
        operatorStick = new Joystick(operatorJoyPort);
        operatorPanel = new OperatorPanel();
    }

    public double getLeftjoyAxis(){
        return leftJoy.getRawAxis(0);
    }

    public double getRightjoyAxis(){
        return rightJoy.getRawAxis(1);
    }

    public boolean getLowGearButton() {
        return leftJoy.getRawButtonPressed(2) || rightJoy.getRawButtonPressed(2);
    }

    public boolean getHighGearButton() {
        return leftJoy.getRawButtonPressed(3) || rightJoy.getRawButtonPressed(3);
    }

    public double getOperatorStickY(){
        return operatorStick.getRawAxis(1);
    }

    public boolean getOperatorTrigger() {
        return operatorStick.getTrigger();
    }

    public ScoreState getOperatorPanelState(){
        return operatorPanel.getOperatorDesiredState();
    }

    public boolean getRightTrigger() {
        return rightJoy.getRawButton(0);
    }
}
