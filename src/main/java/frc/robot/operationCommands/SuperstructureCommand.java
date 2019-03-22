package frc.robot.operationCommands;

import frc.robot.subsystems.Wrist;

public class SuperstructureCommand {

    private final EmergencyCommand emergencyCommand;
    private final IntakeCommand intakeCommand;
    private final ScoreState scoreState;
    private final OffsetCommand offsetCommand;

    SuperstructureCommand(IntakeCommand intakeCommand, ScoreState scoreState, EmergencyCommand emergencyCommand, OffsetCommand offsetCommand){
        this.intakeCommand = intakeCommand;
        this.scoreState = scoreState;
        this.emergencyCommand = emergencyCommand;
        this.offsetCommand = offsetCommand;
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

    public EmergencyCommand getEmergencyCommand(){
        return emergencyCommand;
    }

    public ScoreState getScoreState() {
        return scoreState;
    }

    public IntakeCommand getIntakeCommand(){
        return intakeCommand;
    }

    public int getArmOffset() { return offsetCommand.getArmOffset(); }

    public int getWristOffset() {
        return offsetCommand.getWristOffset();
    }

}
