package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.util.Constants;
import frc.robot.util.ControlMap;

public class Intake extends Subsystem {

    DoubleSolenoid jaws;
    DoubleSolenoid punch;

    boolean jawsOpen = true;
    boolean punchOut = false;

    boolean triggerLatch = false;
    boolean thresholdLatch = false;

    double threshold;
    double intakeDeadband;

    ControlMap cm = new ControlMap();
    Constants c = new Constants();

    public Intake() {

        intakeDeadband = c.intakeDeadband;
        threshold = c.exhaustTreshold;

        jaws = new DoubleSolenoid(0,0,0);
        punch = new DoubleSolenoid(0,0,0);

    }

    private void runIntake(double motorPower) {
        DriverStation.reportWarning("Intake motor power: " + motorPower + " Jaws Open: " + jawsOpen + " Punch Out: " + punchOut, false);
    }

    @Override
    public void handle() {

        //Handles deadband and control for intake
        if (Math.abs(cm.getOperatorStickY()) >= intakeDeadband) {
            runIntake(cm.getOperatorStickY());
        } else {
            runIntake(0);
        }

        //Handles the punch piston and the threshold latch for the jaws
        if (cm.getOperatorStickY() >= threshold) {
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
        if (cm.getOperatorTrigger()) {
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
