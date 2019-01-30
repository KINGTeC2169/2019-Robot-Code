package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;

public class LEDMachine extends Subsystem {

    public enum LEDState {
        RED, GREEN, BLUE, ORANGE, YELLOW, WHITE, PURPLE
    }

    Spark ledSpark;

    LEDMachine(){
        ledSpark = new Spark(ActuatorMap.ledSparkPWMPort);
    }

    void handle(SuperstructureCommand sCommand) {

        switch(sCommand.getLedState()){

            case RED:
                break;
            case GREEN:
                break;
            case BLUE:
                break;
            case ORANGE:
                break;
            case YELLOW:
                break;
            case WHITE:
                break;
            case PURPLE:
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
