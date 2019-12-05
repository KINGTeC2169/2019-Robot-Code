package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.operationCommands.ScoreState;

@SuppressWarnings("FieldCanBeLocal")
public class Controls {

    private static final int leftJoyPort = 0;
    private static final int rightJoyPort = 1;
    static final int operatorJoyPort = 2;

    private final Joystick leftJoy;
    private final Joystick rightJoy;
    private final OperatorGamepad operator;

    public Controls() {
        leftJoy = new Joystick(leftJoyPort);
        rightJoy = new Joystick(rightJoyPort);
        operator = new OperatorGamepad(2);
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
        return rightJoy.getRawButton(3) ||  rightJoy.getRawButton(11) || rightJoy.getRawButton(10);
    }

    private boolean getExhaustButton() {
        // Both driver and operator have an exhaust button
        return leftJoy.getRawButton(3) || leftJoy.getRawButton(6) || leftJoy.getRawButton(7);
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

    public boolean isArmManual() {
        // Enables manual arm control
        return Math.abs(getManualArmStick()) > 0;
    }

    public boolean isWristManual() {
        // Enables manual wrist control
        return Math.abs(getManualWristStick()) > 0;
    }

    public double getManualArmStick(){
        return operator.armJogThrottle();
    }

    public double getManualWristStick(){
        return operator.wristJogThrottle();
    }

    public ScoreState getOperatorPanelState(){
        ScoreState desiredState = operator.getScoreState();
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
