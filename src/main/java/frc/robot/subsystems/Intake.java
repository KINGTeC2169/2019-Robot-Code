package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.operationCommands.IntakeCommand;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;
import frc.robot.util.Constants;

public class Intake extends Subsystem {

    private final TalonSRX left;
    private final TalonSRX right;

    private final Ultrasonic proxSensor;

    private enum BallState{
        INTAKING, EXHAUSTING, HOLDING, IDLE
    }

    private BallState ballState = BallState.IDLE;

    Intake() {

        proxSensor = new Ultrasonic(ActuatorMap.intakeProxPing, ActuatorMap.intakeProxEcho);
        proxSensor.setDistanceUnits(Ultrasonic.Unit.kInches);

        left = new TalonSRX(ActuatorMap.intakeLeft);
        right = new TalonSRX(ActuatorMap.intakeRight);

    }

    private void runIntake(double motorPower) {

        left.set(ControlMode.PercentOutput, motorPower);
        right.set(ControlMode.PercentOutput, motorPower);

    }

    //Primary handle method for the intake
    void handle(SuperstructureCommand sCommand) {

        //Check if operator is looking to manually control intake
        if (Math.abs(sCommand.getIntakeOutput()) >= Constants.intakeDeadband) {

            //Operator is controlling.  Do what they ask and set the ball state accordingly.
            if (sCommand.getIntakeOutput() > Constants.intakeDeadband) {
                ballState = BallState.INTAKING;
            }
            else{
                ballState = BallState.EXHAUSTING;
            }
            runIntake(sCommand.getIntakeOutput());
        }

        //The stick is stable.  Determine if the operator's last action was intake

        else {

            //It was.  Run the wheels at hold voltage and set the state.
            if(ballState == BallState.INTAKING || ballState == BallState.HOLDING){
                runIntake(0);
                ballState = BallState.HOLDING;
            }

            //It was not.  Stop the wheels.
            else{
                runIntake(0);
                ballState = BallState.IDLE;
            }

        }

        SmartDashboard.putString("Intake Roller State", ballState.name());
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
