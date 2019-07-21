package frc.robot.operationCommands;

import frc.robot.subsystems.Wrist;
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

    public Wrist.WristState getWristState() {
        if(scoreState.getGameElement() == ScoreState.GameElement.CARGO){
            if(scoreState.getPosition() == ScoreState.Position.HIGH){
                return scoreState.getRobotSide() == ScoreState.RobotSide.FRONT ? Wrist.WristState.HIGH_FRONT : Wrist.WristState.HIGH_BACK;
            }
            if(scoreState.getPosition() == ScoreState.Position.INTAKE){
                return scoreState.getRobotSide() == ScoreState.RobotSide.FRONT ? Wrist.WristState.INTAKE_FRONT : Wrist.WristState.INTAKE_BACK;
            }
        }
        return Wrist.WristState.PARALLEL_TO_GROUND;
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
