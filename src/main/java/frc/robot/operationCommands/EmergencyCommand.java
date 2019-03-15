package frc.robot.operationCommands;

public class EmergencyCommand {

    private final boolean overrideActive;
    private final double leftVal;
    private final double rightVal;
    private final boolean in;
    private final boolean out;

    EmergencyCommand(boolean active, double left, double right, boolean in, boolean out){
        overrideActive = active;
        leftVal = left;
        rightVal = right;
        this.in = in;
        this.out = out;
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
