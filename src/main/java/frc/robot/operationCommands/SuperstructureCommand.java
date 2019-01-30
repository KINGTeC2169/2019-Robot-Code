package frc.robot.operationCommands;

import frc.robot.subsystems.LEDMachine;

public class SuperstructureCommand {

    private IntakeCommand intakeCommand;
    ScoreState scoreState;
    double currentArmPos;
    double currentWristPos;
    LEDMachine.LEDState ledState;


    SuperstructureCommand(IntakeCommand intakeCommand){
        this.intakeCommand = intakeCommand;
    }

    public IntakeCommand getIntakeCommand(){
        return intakeCommand;
    }

}
