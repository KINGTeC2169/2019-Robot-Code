package frc.robot.operationCommands;

public class EmergencyCommand {

    private final boolean overrideActive;
    private final double leftVal;
    private final double rightVal;

    EmergencyCommand(boolean active, double left, double right){
        overrideActive = active;
        leftVal = left;
        rightVal = right;
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


}
