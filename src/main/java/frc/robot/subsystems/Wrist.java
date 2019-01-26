package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.util.ActuatorMap;

public class Wrist extends Subsystem {

    TalonSRX wristMotor;

    enum WristState{
        SNAP_TO_ARM, STOW_HIGH, STOW_LOW, PARALLEL_TO_GROUND
    }

    private WristState wristState = WristState.SNAP_TO_ARM;

    public void setWristState(WristState wristState){
        this.wristState = wristState;
    }

    public Wrist() {

        wristMotor = new TalonSRX(ActuatorMap.wristPort);

    }

    public void handle() {

        switch(wristState){

            case SNAP_TO_ARM:
                break;
            case STOW_HIGH:
                break;
            case STOW_LOW:
                break;
            case PARALLEL_TO_GROUND:
                break;
        }

    }

    @Override
    public void zeroSensors() {

    }

    @Override
    public void stop() {

    }
}
