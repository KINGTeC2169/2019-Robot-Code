package frc.robot.operationCommands;

public class IntakeCommand {

    private final double stickY;
    private final boolean open;
    private final boolean close;

    IntakeCommand(double stickY, boolean open, boolean close){
        this.stickY = stickY;
        this.open = open;
        this.close = close;
    }

    public double getStickY() {
        return stickY;
    }

    public boolean getOpen() {
        return open;
    }

    public boolean getClose() {
        return close;
    }

}
