package frc.robot.subsystems;

public class LEDMachine extends Subsystem {

    public enum LEDColor{
        RED, GREEN, BLUE, ORANGE, YELLOW, WHITE, PURPLE
    }

    LEDColor colorState;

    void setColorState(LEDColor colorState){
        this.colorState = colorState;
    }

    public LEDMachine(){

    }

    @Override
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
