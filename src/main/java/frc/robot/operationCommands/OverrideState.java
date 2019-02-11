package frc.robot.operationCommands;

public class OverrideState {

    private final boolean overrideActive;
    private final double leftVal;
    private final double rightVal;

    public OverrideState(boolean active, double left, double right){
        overrideActive = active;
        leftVal = left;
        rightVal = right;
    }

    public boolean getOverrideActive(){
        return overrideActive;
    }

    public double getLeftVal(){
        return leftVal;
    }

    public double getRightVal(){
        return rightVal;
    }


}
