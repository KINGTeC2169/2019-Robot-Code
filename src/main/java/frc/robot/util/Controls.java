package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.operationCommands.ScoreState;

@SuppressWarnings("FieldCanBeLocal")
public class Controls {

    private static final int leftJoyPort = 0;
    private static final int rightJoyPort = 1;
    private static final int operatorJoyPort = 2;

    private final Joystick leftJoy;
    private final Joystick rightJoy;
    private final Joystick operatorStick;
    private final OperatorPanel operatorPanel;

    public Controls() {
        leftJoy = new Joystick(leftJoyPort);
        rightJoy = new Joystick(rightJoyPort);
        operatorStick = new Joystick(operatorJoyPort);
        operatorPanel = new OperatorPanel();
    }

    public double getLeftJoyAxis(){
        return leftJoy.getRawAxis(1);
    }

    public double getRightJoyAxis(){
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

    public boolean getOperatorOpen() {
        return operatorStick.getRawButton(4);
    }

    public boolean getOperatorClose() {
        return operatorStick.getRawButton(5);
    }

    public double getEmergencyArmStick(){
        if(operatorStick.getRawButton(1)){
            return operatorStick.getRawAxis(1);
        }
        return 0;
    }

    public double getEmergencyWristStick(){
        return operatorStick.getRawAxis(0);
    }

    public ScoreState getOperatorPanelState(){
        ScoreState desiredState = operatorPanel.getOperatorDesiredState();
        SmartDashboard.putString("Operator Desired Position", desiredState.position.name());
        SmartDashboard.putString("Operator Desired Side", desiredState.robotSide.name());
        SmartDashboard.putString("Operator Desired Element", desiredState.gameElement.name());
        return desiredState;
    }

    public boolean getEmergencyMode(){
        return operatorStick.getRawAxis(2) < -.4;
    }

    public boolean getRightTrigger() {
        return rightJoy.getRawButton(1);
    }

    public boolean getIntakeButton(){
        return operatorStick.getRawButton(2);
    }

    public boolean getExhaustButton(){
        return operatorStick.getRawButton(3);
    }

}
