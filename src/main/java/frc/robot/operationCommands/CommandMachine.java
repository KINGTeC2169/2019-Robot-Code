package frc.robot.operationCommands;

import frc.robot.util.Controls;

public class CommandMachine {

    Controls controls;

    public CommandMachine(){
        controls = new Controls();
    }

    public SuperstructureCommand generateSuperstructureCommand(){

        return new SuperstructureCommand(generateIntakeCommand());

    }

    private IntakeCommand generateIntakeCommand(){
        return new IntakeCommand(controls.getOperatorStickY(), controls.getOperatorTrigger());
    }



}
