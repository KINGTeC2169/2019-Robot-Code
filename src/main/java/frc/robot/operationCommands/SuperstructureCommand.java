package frc.robot.operationCommands;
import frc.robot.util.Constants;
import frc.robot.util.Controls;

public class SuperstructureCommand {

    private Controls controls;
    private ScoreState scoreState;

    SuperstructureCommand(Controls controls){
        this.controls = controls;
        scoreState = controls.getOperatorPanelState();
    }

    public ScoreState getScoreState() {
        return scoreState;
    }

    public double getManualArmStick() {
        return controls.getManualArmStick();
    }

    public double getManualWristStick() {
        return controls.getManualWristStick();
    }

    public int getArmOffset() {
        return Constants.startingArmOffset;
    }

    public int getWristOffset() {
        return Constants.startingWristOffset;
    }

    public double getIntakeOutput() {
        return controls.getIntakeOutput();
    }

    public boolean isWristManual() {
        return controls.isWristManual();
    }

    public boolean isArmManual() {
        return controls.isArmManual();
    }

}
