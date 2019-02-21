package frc.robot.operationCommands;

import frc.robot.subsystems.Wrist;

public class SuperstructureCommand {

    private final EmergencyCommand emergencyCommand;
    private final IntakeCommand intakeCommand;
    private final ScoreState scoreState;

    SuperstructureCommand(IntakeCommand intakeCommand, ScoreState scoreState, EmergencyCommand emergencyCommand){
        System.out.println("Line 12: " + emergencyCommand.getEmergencyActive());
        this.intakeCommand = intakeCommand;
        this.scoreState = scoreState;
        this.emergencyCommand = emergencyCommand;
    }

    public Wrist.WristState getWristState() {
        if(scoreState.getGameElement() == ScoreState.GameElement.CARGO){
            if(scoreState.getPosition() == ScoreState.Position.HIGH){
                if(scoreState.getRobotSide() == ScoreState.RobotSide.FRONT){
                    return Wrist.WristState.HIGH_FRONT;
                }
                else{
                    return Wrist.WristState.HIGH_BACK;
                }
            }
            else if(scoreState.getPosition() == ScoreState.Position.INTAKE){
                if(scoreState.getRobotSide() == ScoreState.RobotSide.FRONT){
                    return Wrist.WristState.INTAKE_FRONT;
                }
                else{
                    return Wrist.WristState.INTAKE_BACK;
                }
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

}
