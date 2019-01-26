package frc.robot.operationCommands;

public class SuperstructureCommand {

    private IntakeCommand intakeCommand;
    LEDCommand ledCommand;
    ScoreState scoreState;
    double currentArmPos;
    double currentWristPos;


    SuperstructureCommand(IntakeCommand intakeCommand){
        this.intakeCommand = intakeCommand;
    }

    public IntakeCommand getIntakeCommand(){
        return intakeCommand;
    }

}
