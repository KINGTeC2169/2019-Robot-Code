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
        return leftJoy.getRawButtonPressed(2);
    }

    public boolean getHighGearButton() {
        return rightJoy.getRawButtonPressed(2);
    }

    public double getOperatorStickY(){
        if(leftJoy.getRawButton(3)) {
            return -1;
        } else if(rightJoy.getRawButton(3)) {
            return 1;
        } else {
            return operatorStick.getRawAxis(1);
        }
    }

    public boolean getOperatorOpen() {
        return operatorStick.getRawButton(4);
    }

    public boolean getOperatorClose() {
        return operatorStick.getRawButton(5);
    }

    // Side buttons for manually changing the arm and wrist encoder offsets
    public boolean getArmOffsetIncrease() { return operatorStick.getRawButton(6); }

    public boolean getArmOffsetDecrease() { return operatorStick.getRawButton(7); }

    public boolean getWristOffsetDecrease() { return operatorStick.getRawButton(10); }

    public boolean getWristOffsetIncrease() { return operatorStick.getRawButton(11); }

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

        return false;
    }

    public boolean getExhaustButton(){

        return false;
    }

    public boolean getOperatorTrigger() {
        return operatorStick.getRawButton(1);
    }

    public boolean getSlowMode() {
        return leftJoy.getRawButton(4) || rightJoy.getRawButton(4);
    }
}
