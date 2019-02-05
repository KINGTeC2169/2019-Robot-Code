package frc.robot.operationCommands;

import frc.robot.subsystems.LEDMachine;
import frc.robot.subsystems.Wrist;

public class SuperstructureCommand {

    private IntakeCommand intakeCommand;
    private ScoreState scoreState;
    private Wrist.WristState wristState;
    private LEDMachine.LEDState ledState;


    SuperstructureCommand(IntakeCommand intakeCommand, ScoreState scoreState){
        this.intakeCommand = intakeCommand;
    }

    public Wrist.WristState getWristState() {
        return wristState;
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
