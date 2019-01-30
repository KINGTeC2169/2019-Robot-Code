package frc.robot.operationCommands;

import frc.robot.subsystems.LEDMachine;
import frc.robot.subsystems.Wrist;

public class SuperstructureCommand {

    private IntakeCommand intakeCommand;
    ScoreState scoreState;
    Wrist.WristState wristState;
    LEDMachine.LEDState ledState;


    SuperstructureCommand(IntakeCommand intakeCommand){
        this.intakeCommand = intakeCommand;
    }

    public IntakeCommand getIntakeCommand(){
        return intakeCommand;
    }

}
