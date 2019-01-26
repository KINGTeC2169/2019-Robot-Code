package frc.robot.operationCommands;

public class IntakeCommand {

    private double stickY;
    private boolean trigger;

    IntakeCommand(double stickY, boolean trigger){
        this.stickY = stickY;
        this.trigger = trigger;
    }


    public double getStickY() {
        return stickY;
    }

    public boolean getTrigger() {
        return trigger;
    }

}
