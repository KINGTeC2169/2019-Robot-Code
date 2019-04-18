package frc.robot.operationCommands;

import frc.robot.util.Controls;

public class CommandMachine {

    private final Controls controls;

    public CommandMachine(){
        controls = new Controls();
    }

    public SuperstructureCommand generateSuperstructureCommand(){
        return new SuperstructureCommand(generateIntakeCommand(), generateScoreState(), generateEmergencyCommand(), generateOffsetCommand());
    }

    public DriveCommand generateDriveCommand(){
        return new DriveCommand(controls.getLeftJoyAxis(), controls.getRightJoyAxis(), controls.getLowGearButton(),
                controls.getHighGearButton(), controls.getRightTrigger());
    }

    private IntakeCommand generateIntakeCommand(){
        return new IntakeCommand(controls.getOperatorStickY(), controls.getOperatorOpen(), controls.getOperatorClose());
    }

    private ScoreState generateScoreState(){
        return controls.getOperatorPanelState();
    }

    private EmergencyCommand generateEmergencyCommand(){
        return new EmergencyCommand(controls.getEmergencyMode(), controls.getEmergencyArmStick(),
                controls.getEmergencyWristStick(), controls.getIntakeButton(), controls.getExhaustButton(), controls.getOperatorTrigger());
    }

    // Handles manual control of arm and wrist encoder offset
    private OffsetCommand generateOffsetCommand(){
        return new OffsetCommand(controls.getArmOffsetDecrease(), controls.getArmOffsetIncrease(), controls.getWristOffsetDecrease(), controls.getWristOffsetIncrease());
    }


}
