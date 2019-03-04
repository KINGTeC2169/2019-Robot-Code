package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.operationCommands.IntakeCommand;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;
import frc.robot.util.Constants;

public class Intake extends Subsystem {

    private final TalonSRX left;
    private final TalonSRX right;

    private final Solenoid jaws;

    private final Ultrasonic proxSensor;

    Intake() {

        proxSensor = new Ultrasonic(ActuatorMap.intakeProxPing, ActuatorMap.intakeProxEcho);
        proxSensor.setDistanceUnits(Ultrasonic.Unit.kInches);

        jaws = new Solenoid(ActuatorMap.pcmPort, ActuatorMap.jawShifter);

        left = new TalonSRX(ActuatorMap.intakeLeft);
        right = new TalonSRX(ActuatorMap.intakeRight);

    }

    private void runIntake(double motorPower) {

        left.set(ControlMode.PercentOutput, motorPower);
        right.set(ControlMode.PercentOutput, motorPower);

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

        //Turns the jawsOpen boolean into actual commands for the piston
        if (command.getOpen()) {
            if(Constants.debugMode){
                System.out.println("Intake Jaws Opened");
            }
            jaws.set(true);
        } else if(command.getClose()){
            if(Constants.debugMode){
                System.out.println("Intake Jaws Closed");
            }
            jaws.set(false);
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
