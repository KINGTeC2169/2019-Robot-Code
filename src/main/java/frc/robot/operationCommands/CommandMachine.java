package frc.robot.operationCommands;

import frc.robot.util.Controls;

public class CommandMachine {

    private Controls controls;

    public CommandMachine(){
        controls = new Controls();
    }

    public SuperstructureCommand generateSuperstructureCommand(){

        return new SuperstructureCommand(generateIntakeCommand(), generateScoreState());

    }

    public DriveCommand generateDriveCommand(){
        return new DriveCommand(controls.getLeftjoyAxis(), controls.getRightjoyAxis(), controls.getLowGearButton(), controls.getHighGearButton());
    }

    private IntakeCommand generateIntakeCommand(){
        return new IntakeCommand(controls.getOperatorStickY(), controls.getOperatorTrigger());
    }

    private ScoreState generateScoreState(){
        return new ScoreState(controls.getOperatorPanelState());
    }


}
