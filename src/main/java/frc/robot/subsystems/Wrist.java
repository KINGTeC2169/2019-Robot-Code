package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;

public class Wrist extends Subsystem {

    private TalonSRX wristMotor;

    public enum WristState{
        SNAP_TO_ARM, STOW_HIGH, STOW_LOW, PARALLEL_TO_GROUND
    }

    private WristState wristState = WristState.SNAP_TO_ARM;

    Wrist() {

        wristMotor = new TalonSRX(ActuatorMap.wristPort);

    }

    void handle(SuperstructureCommand sCommand) {

        switch(sCommand.getWristState()){

            case SNAP_TO_ARM:
                break;
            case STOW_HIGH:
                break;
            case STOW_LOW:
                break;
            case PARALLEL_TO_GROUND:
                break;
        }

        wristState = sCommand.getWristState();

    }

    @Override
    public void zeroSensors() {

    }

    @Override
    public void stop() {

    }
}
