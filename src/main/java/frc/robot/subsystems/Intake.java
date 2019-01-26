package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.operationCommands.IntakeCommand;
import frc.robot.util.Constants;

public class Intake extends Subsystem {

    private DoubleSolenoid jaws;
    private DoubleSolenoid punch;

    private boolean jawsOpen = true;
    private boolean punchOut = false;

    private boolean triggerLatch = false;
    private boolean thresholdLatch = false;

    Intake() {

        jaws = new DoubleSolenoid(0,1,0);
        punch = new DoubleSolenoid(0,2,3);

    }

    private void runIntake(double motorPower) {
        DriverStation.reportWarning("Intake motor power: " + motorPower + " Jaws Open: " + jawsOpen + " Punch Out: " + punchOut, false);
    }

    public void handle(IntakeCommand command) {

        //Handles deadband and control for intake
        if (Math.abs(command.getStickY()) >= Constants.intakeDeadband) {
            runIntake(command.getStickY());
        } else {
            runIntake(0);
        }

        //Handles the punch piston and the threshold latch for the jaws
        if (command.getStickY() >= Constants.exhaustThreshold) {
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
        if (command.getTrigger()) {
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
