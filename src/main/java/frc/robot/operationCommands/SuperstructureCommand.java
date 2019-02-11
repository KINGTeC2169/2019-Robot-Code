package frc.robot.operationCommands;

import frc.robot.subsystems.LEDMachine;
import frc.robot.subsystems.Wrist;

public class SuperstructureCommand {

    private IntakeCommand intakeCommand;
    private ScoreState scoreState;
    private LEDMachine.LEDState ledState;


    SuperstructureCommand(IntakeCommand intakeCommand, ScoreState scoreState){
        this.intakeCommand = intakeCommand;
        this.scoreState = scoreState;
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

    public ScoreState getScoreState() {
        return scoreState;
    }

    public LEDMachine.LEDState getLedState(){
        return ledState;
    }

    public IntakeCommand getIntakeCommand(){
        return intakeCommand;
    }

}
