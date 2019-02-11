package frc.robot.operationCommands;

import frc.robot.util.Controls;

public class CommandMachine {

    private final Controls controls;

    public CommandMachine(){
        controls = new Controls();
    }

    public SuperstructureCommand generateSuperstructureCommand(){

        return new SuperstructureCommand(generateIntakeCommand(), generateScoreState(), generateOverrideCommand());

    }

    public DriveCommand generateDriveCommand(){
        return new DriveCommand(controls.getLeftJoyAxis(), controls.getRightJoyAxis(), controls.getLowGearButton(),
                controls.getHighGearButton(), controls.getRightTrigger());
    }

    private IntakeCommand generateIntakeCommand(){
        return new IntakeCommand(controls.getOperatorStickY(), controls.getOperatorTrigger());
    }

    private ScoreState generateScoreState(){
        return controls.getOperatorPanelState();
    }

    private OverrideState generateOverrideCommand(){
        return new OverrideState(controls.getOperatorOverride(), controls.getEmergencyLeftStick(),
                controls.getEmergencyRightStick());
    }


}
