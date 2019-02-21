package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.operationCommands.IntakeCommand;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;
import frc.robot.util.Constants;

public class Intake extends Subsystem {

    private final VictorSPX left;
    private final VictorSPX right;

//    private final DoubleSolenoid jaws;
//    private final DoubleSolenoid punch;

    private boolean jawsOpen = true;

    private boolean triggerLatch;
    private boolean thresholdLatch;

    private final Ultrasonic proxSensor;

    Intake() {

        proxSensor = new Ultrasonic(ActuatorMap.intakeProxPing, ActuatorMap.intakeProxEcho);
        proxSensor.setDistanceUnits(Ultrasonic.Unit.kInches);

//        jaws = new DoubleSolenoid(0,1,0);
//        punch = new DoubleSolenoid(0,2,3);

        left = new VictorSPX(ActuatorMap.intakeLeft);
        right = new VictorSPX(ActuatorMap.intakeRight);

    }

    private void runIntake(double motorPower) {

        left.set(ControlMode.PercentOutput, motorPower);
        right.set(ControlMode.PercentOutput, -motorPower);

    }

    //Primary handle method for the intake
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
        if (command.getStickY() <= Constants.exhaustThreshold) {
            if (!thresholdLatch) {
                jawsOpen = true;
            }
            thresholdLatch = true;
        } else {
            thresholdLatch = false;
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
            jaws.set(DoubleSolenoid.Value.kForward);
        } else {
            if(Constants.debugMode){
                System.out.println("Intake Jaws Closed");
            }
            jaws.set(DoubleSolenoid.Value.kReverse);
        }

    }

    //Method for accessing the ultrasonic to determine presence of a ball in the intake
    private boolean getHasBall(){
        //If the sensor is working correctly
        if(proxSensor.isRangeValid()){
            //Since the sensor is working, return true if the ball is in the "hot zone"
            return proxSensor.getRangeInches() < Constants.intakeProxUpperBound &&
                    proxSensor.getRangeInches() > Constants.intakeProxLowerBound;
        }
        //Sensor wasn't working correctly, so return false by default.
        return false;
    }

    @Override
    public void zeroSensors() {

    }

    @Override
    public void stop() {

    }
}
