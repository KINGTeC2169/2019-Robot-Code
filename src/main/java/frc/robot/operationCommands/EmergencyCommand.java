package frc.robot.operationCommands;

public class EmergencyCommand {

    private final boolean overrideActive;
    private final double leftVal;
    private final double rightVal;
    private final boolean in;
    private final boolean out;
    private final boolean trigger;

    EmergencyCommand(boolean active, double left, double right, boolean in, boolean out, boolean trigger){
        overrideActive = active;
        leftVal = left;
        rightVal = right;
        this.in = in;
        this.out = out;
        this.trigger = trigger;
    }

    public boolean getTrigger(){
        return trigger;
    }

    public boolean getEmergencyActive(){
        return overrideActive;
    }

    public double getArmVal(){
        return leftVal;
    }

    public double getWristVal(){
        return rightVal;
    }

    public boolean getIn(){
        return in;
    }

    public boolean getOut(){
        return out;
    }


}
