package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.util.Constants;
import frc.robot.util.ControlMap;

public class Intake extends Subsystem {

    private DoubleSolenoid jaws;
    private DoubleSolenoid punch;

    private boolean jawsOpen = true;
    private boolean punchOut = false;

    private boolean triggerLatch = false;
    private boolean thresholdLatch = false;

    Intake() {

        jaws = new DoubleSolenoid(0,0,0);
        punch = new DoubleSolenoid(0,0,0);

    }

    private void runIntake(double motorPower) {
        DriverStation.reportWarning("Intake motor power: " + motorPower + " Jaws Open: " + jawsOpen + " Punch Out: " + punchOut, false);
    }

    @Override
    public void handle() {

        //Handles deadband and control for intake
        if (Math.abs(ControlMap.getOperatorStickY()) >= Constants.intakeDeadband) {
            runIntake(ControlMap.getOperatorStickY());
        } else {
            runIntake(0);
        }

        //Handles the punch piston and the threshold latch for the jaws
        if (ControlMap.getOperatorStickY() >= Constants.exhaustTreshold) {
            if (!thresholdLatch) {
                jawsOpen = true;
            }
            punchOut = true;
            thresholdLatch = true;
        } else {
            thresholdLatch = false;
            punchOut = false;
        }

        //Handles the trigger latch for the jaws
        if (ControlMap.getOperatorTrigger()) {
            if (!triggerLatch) {
                jawsOpen = !jawsOpen;
            }
            triggerLatch = true;
        } else {
            triggerLatch = false;
        }

        //Turns the jawsOpen boolean into actual commands for the piston
        if (jawsOpen) {
            jaws.set(Value.kForward);
        } else {
            jaws.set(Value.kReverse);
        }

        if (punchOut) {
            punch.set(Value.kForward);
        } else {
            punch.set(Value.kReverse);
        }
    }

    @Override
    public void zeroSensors() {

    }

    @Override
    public void stop() {

    }
}
