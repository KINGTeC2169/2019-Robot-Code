package frc.robot.operationCommands;

import frc.robot.util.Controls;

public class CommandMachine {

    private final Controls controls;

    public CommandMachine(){
        controls = new Controls();
    }

    public SuperstructureCommand generateSuperstructureCommand(){
        // Command controlling
        return new SuperstructureCommand(controls);
    }

    public DriveCommand generateDriveCommand(){
        return new DriveCommand(controls);
    }
}
