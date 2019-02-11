package frc.robot.operationCommands;

public class IntakeCommand {

    private final double stickY;
    private final boolean trigger;

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
