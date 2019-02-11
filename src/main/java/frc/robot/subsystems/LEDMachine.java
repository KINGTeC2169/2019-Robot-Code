package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogOutput;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;

public class LEDMachine extends Subsystem {

    public enum LEDState {
        SOLID_BLUE,BLINKING_BLUE,SOLID_GREEN,BLINKING_GREEN,SOLID_PINK,BLINKING_PINK,NORMAL
    }

    private final LEDState state = LEDState.NORMAL;

    private final AnalogOutput ledOut;

    public enum IntakeNotifier{
        DISABLED, INTAKING, HAS_BALL
    }

    public IntakeNotifier intakeNotifier = IntakeNotifier.DISABLED;

    public enum ArmNotifier{
        DISABLED, IN_PLACE, MOVING
    }

    public ArmNotifier armNotifier = ArmNotifier.DISABLED;

    public enum VisionNotifier{
        DISABLED, ALIGNING, ALIGNED
    }

    VisionNotifier visionNotifier = VisionNotifier.DISABLED;


    LEDMachine(){

        ledOut = new AnalogOutput(ActuatorMap.ledAnalogOutChannel);

    }

    void handle(SuperstructureCommand sCommand) {

        switch(state){

            case SOLID_BLUE:
                break;
            case BLINKING_BLUE:
                break;
            case SOLID_GREEN:
                break;
            case BLINKING_GREEN:
                break;
            case SOLID_PINK:
                break;
            case BLINKING_PINK:
                break;
            case NORMAL:
                break;
        }

    }

    @Override
    public void zeroSensors() {

    }

    @Override
    public void stop() {

    }

}
