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

    private boolean manualButton;
    private boolean fullManual;

    public Controls() {
        leftJoy = new Joystick(leftJoyPort);
        rightJoy = new Joystick(rightJoyPort);
        operatorStick = new Joystick(operatorJoyPort);
        operatorPanel = new OperatorPanel();
    }

    public void update() {
        // Listen for button 3. This is how we do a toggle switch
        boolean buttonPressed = !manualButton && operatorStick.getRawButton(3);
        boolean buttonReleased = manualButton && !operatorStick.getRawButton(3);
        if(buttonPressed || buttonReleased) {
            fullManual = !fullManual;
        }
        manualButton = operatorStick.getRawButton(3);
    }

    /* Drive controls */
    public boolean getSlowMode() {
        return leftJoy.getRawButton(1) || rightJoy.getRawButton(1);
    }

    public double getLeftDrive(){
        return leftJoy.getRawAxis(1);
    }

    public double getRightDrive(){
        return rightJoy.getRawAxis(1);
    }

    public double getSteer(){
        return -rightJoy.getRawAxis(0);
    }

    public boolean shiftUpButton() {
        // Shifts drive train into high gear
        return leftJoy.getRawButtonPressed(2);
    }

    public boolean shiftDownButton() {
        // Shift drive train into low gear
        return rightJoy.getRawButtonPressed(2);
    }

    /* Intake Controls */
    private boolean getIntakeButton() {
        // Both driver and operator have an intake button
        return rightJoy.getRawButton(3) || operatorStick.getRawButton(4) || rightJoy.getRawButton(11) || rightJoy.getRawButton(10);
    }

    private boolean getExhaustButton() {
        // Both driver and operator have an exhaust button
        return leftJoy.getRawButton(3) || operatorStick.getRawButton(5) || leftJoy.getRawButton(6) || leftJoy.getRawButton(7);
    }

    public double getIntakeOutput() {
        if(getIntakeButton()) {
            return -1;
        }
        else if(getExhaustButton()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /* Encoder offset controls */
    public boolean getArmOffsetIncrease() { return operatorStick.getRawButton(6); }

    public boolean getArmOffsetDecrease() { return operatorStick.getRawButton(7); }

    public boolean getWristOffsetDecrease() { return operatorStick.getRawButton(10); }

    public boolean getWristOffsetIncrease() { return operatorStick.getRawButton(11); }

    /* Emergency and manual controls */
    public boolean getEmergencyMode(){
        // Emergency mode disables arm and wrist entirely
        return operatorStick.getRawAxis(2) < -.4;
    }

    public boolean isFullManual() {
        // Full manual mode enables manual wrist and arm control
        return fullManual;
    }

    public boolean isWristManual() {
        // Trigger enables manual wrist control
        return operatorStick.getRawButton(1) || fullManual;
    }

    public double getManualArmStick(){
        return operatorStick.getRawAxis(1);
    }

    public double getManualWristStick(){
        return operatorStick.getRawAxis(0);
    }

    public ScoreState getOperatorPanelState(){
        ScoreState desiredState = operatorPanel.getOperatorDesiredState();
        SmartDashboard.putString("Operator Desired Position", desiredState.position.name());
        SmartDashboard.putString("Operator Desired Side", desiredState.robotSide.name());
        SmartDashboard.putString("Operator Desired Element", desiredState.gameElement.name());
        return desiredState;
    }

    public boolean visionDriving() {
        return rightJoy.getRawButton(1);
    }

    public boolean getCheesyMode() {
        return leftJoy.getRawAxis(2) > .2;
    }
}
