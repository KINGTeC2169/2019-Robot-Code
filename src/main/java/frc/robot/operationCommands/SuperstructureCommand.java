package frc.robot.operationCommands;
import frc.robot.util.Constants;
import frc.robot.util.Controls;

public class SuperstructureCommand {

    private Controls controls;
    private ScoreState scoreState;
    private int armOffset = Constants.startingArmOffset;
    private int wristOffset = Constants.startingWristOffset;

    SuperstructureCommand(Controls controls){
        this.controls = controls;
        scoreState = controls.getOperatorPanelState();

        // Periodically update the offsets
        if(controls.getArmOffsetDecrease()) {
            armOffset--;
        }
        if(controls.getArmOffsetIncrease()) {
            armOffset++;
        }
        if(controls.getWristOffsetDecrease()) {
            wristOffset--;
        }
        if(controls.getWristOffsetIncrease()) {
            wristOffset++;
        }
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
        return armOffset;
    }

    public int getWristOffset() {
        return wristOffset;
    }

    public double getIntakeOutput() {
        return controls.getIntakeOutput();
    }

    public boolean isWristManual() {
        return controls.isWristManual();
    }

    public boolean isFullManual() {
        return controls.isFullManual();
    }

    public boolean getEmergencyMode() {
        return controls.getEmergencyMode();
    }

}
