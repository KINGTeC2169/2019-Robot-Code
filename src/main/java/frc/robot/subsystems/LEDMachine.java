package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;

public class LEDMachine extends Subsystem {


    public enum LEDState {
        SOLID_BLUE,BLINKING_BLUE,SOLID_GREEN,BLINKING_GREEN,SOLID_PINK,BLINKING_PINK,NORMAL
    }

    public static LEDState state = LEDState.NORMAL;

    Timer intakeTimer;
    Timer armTimer;

    private final AnalogOutput ledOut;

    private boolean hasBallLatch = false;
    private boolean armPlaceLatch = false;


    public enum IntakeNotifier{
        DISABLED, INTAKING, HAS_BALL
    }

    public static IntakeNotifier intakeNotifier = IntakeNotifier.DISABLED;

    public enum ArmNotifier{
        DISABLED, IN_PLACE, MOVING
    }

    public static ArmNotifier armNotifier = ArmNotifier.DISABLED;


    LEDMachine(){

        ledOut = new AnalogOutput(ActuatorMap.ledAnalogOutChannel);
        intakeTimer = new Timer();
        armTimer = new Timer();
    }

    void handle() {

        double outVal;
        switch(state){

            case SOLID_BLUE:
                outVal = 1;
                break;
            case BLINKING_BLUE:
                outVal = 1.785714286;
                break;
            case SOLID_GREEN:
                outVal = 2.5;
                break;
            case BLINKING_GREEN:
                outVal = 3.214285714;
                break;
            case SOLID_PINK:
                outVal = 3.928571429;
                break;
            case BLINKING_PINK:
                outVal = 4.642857143;
                break;
            case NORMAL:
                outVal = 0;
                break;
            default:
                outVal = 0;
                break;
        }

        ledOut.setVoltage(outVal);


    }

    private LEDState getState(){
        if(intakeNotifier == IntakeNotifier.HAS_BALL){
            if(!hasBallLatch){
                hasBallLatch = true;
                intakeTimer.start();
                return LEDState.BLINKING_PINK;
            }
            if(intakeTimer.get() > 5.0){
                intakeTimer.stop();
                intakeTimer.reset();
            }
        }
        else if(armNotifier == ArmNotifier.IN_PLACE){
            hasBallLatch = false;
            if(!armPlaceLatch){
                armPlaceLatch = true;
                armTimer.start();
                return LEDState.BLINKING_BLUE;
            }
            if(armTimer.get() > 5.0){
                armTimer.stop();
                armTimer.reset();
            }
        }
        else if(intakeNotifier == IntakeNotifier.INTAKING){
            return LEDState.SOLID_PINK;
        }
        else if(armNotifier == ArmNotifier.MOVING){
            return LEDState.SOLID_BLUE;
        }
        hasBallLatch = false;
        armPlaceLatch = false;
        return LEDState.NORMAL;
    }

    @Override
    public void zeroSensors() {

    }

    @Override
    public void stop() {

    }

}
