package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogOutput;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;

public class LEDMachine extends Subsystem {

    public enum LEDState {
        SOLID_BLUE,BLINKING_BLUE,SOLID_GREEN,BLINKING_GREEN,SOLID_PINK,BLINKING_PINK,NORMAL
    }

    private AnalogOutput ledOut;

    LEDMachine(){

        ledOut = new AnalogOutput(ActuatorMap.ledAnalogOutChannel);

    }

    void handle(SuperstructureCommand sCommand) {

        switch(sCommand.getLedState()){

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
