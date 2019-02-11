package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.operationCommands.IntakeCommand;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;
import frc.robot.util.Constants;

public class Intake extends Subsystem {

    private final VictorSPX left;
    private final VictorSPX right;

    private final DoubleSolenoid jaws;
    private final DoubleSolenoid punch;

    private boolean jawsOpen = true;

    private boolean triggerLatch = false;
    private boolean thresholdLatch = false;

    private boolean hasBall = false;

    private final Ultrasonic proxSensor;

    Intake() {

        proxSensor = new Ultrasonic(ActuatorMap.intakeProxPing, ActuatorMap.intakeProxEcho);
        proxSensor.setDistanceUnits(Ultrasonic.Unit.kInches);

        jaws = new DoubleSolenoid(0,1,0);
        punch = new DoubleSolenoid(0,2,3);

        left = new VictorSPX(ActuatorMap.intakeLeft);
        right = new VictorSPX(ActuatorMap.intakeRight);

    }

    private void runIntake(double motorPower) {

        left.set(ControlMode.PercentOutput, motorPower);
        right.set(ControlMode.PercentOutput, -motorPower);

    }

    void handle(SuperstructureCommand sCommand) {

        //Grab intake specific command from Superstructure
        IntakeCommand command = sCommand.getIntakeCommand();

        //Handles deadband and control for intake
        if (Math.abs(command.getStickY()) >= Constants.intakeDeadband) {
            runIntake(command.getStickY());
        } else {
            runIntake(0);
        }

        //Handles the punch piston and the threshold latch for the jaws
        boolean punchOut;
        if (command.getStickY() <= Constants.exhaustThreshold) {
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
            if(Constants.debugMode){
                System.out.println("Intake Jaws Opened");
            }
            jaws.set(Value.kForward);
        } else {
            if(Constants.debugMode){
                System.out.println("Intake Jaws Closed");
            }
            jaws.set(Value.kReverse);
        }

        if (punchOut) {
            if(Constants.debugMode){
                System.out.println("Intake Punch Extended");
            }
            punch.set(Value.kForward);
        } else {
            if(Constants.debugMode){
                System.out.println("Intake Punch Retracted");
            }
            punch.set(Value.kReverse);
        }
    }

    private boolean getHasBall(){
        if(proxSensor.isRangeValid()){
            return proxSensor.getRangeInches() < Constants.intakeProxUpperBound &&
                    proxSensor.getRangeInches() > Constants.intakeProxLowerBound;
        }
        return false;
    }

    @Override
    public void zeroSensors() {

    }

    @Override
    public void stop() {

    }
}
