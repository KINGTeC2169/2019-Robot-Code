package frc.robot.subsystems;

public class LEDMachine extends Subsystem {

    public enum LEDState {
        RED, GREEN, BLUE, ORANGE, YELLOW, WHITE, PURPLE
    }

    LEDState colorState = LEDState.WHITE;

    void setColorState(LEDState colorState){
        this.colorState = colorState;
    }

    public LEDMachine(){

    }

    public void handle() {

        switch(colorState){

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
