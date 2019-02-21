package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.operationCommands.ScoreState;

//This class packs up the operator panel's communications into an easily accessible unit
@SuppressWarnings("FieldCanBeLocal")
class OperatorPanel {

    private final Joystick panel = new Joystick(3);

    private ScoreState.Position joystickAnalogToPosition(){
        double input = panel.getRawAxis(0);
        if(Math.abs(-.75 - input) < .24){
            return ScoreState.Position.INTAKE;
        }
        if(Math.abs(-.25 - input) < .24){
            return ScoreState.Position.LOW;
        }
        if(Math.abs(.25 - input) < .24){
            return ScoreState.Position.MIDDLE;
        }
        if(Math.abs(.75 - input) < .24){
            return ScoreState.Position.HIGH;
        }
        return ScoreState.Position.INTAKE;
    }

    ScoreState getOperatorDesiredState(){

        boolean isFront = panel.getRawButton(4);
        boolean isHatch = panel.getRawButton(3);

        switch(joystickAnalogToPosition()){
            case INTAKE:
                if(isFront){
                    return isHatch ? new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.HATCH, ScoreState.Position.INTAKE) : new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.CARGO, ScoreState.Position.INTAKE);
                }
                return isHatch ? new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.HATCH, ScoreState.Position.INTAKE) : new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.INTAKE);
            case LOW:
                if(isFront){
                    return isHatch ? new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.HATCH, ScoreState.Position.LOW) : new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.CARGO, ScoreState.Position.LOW);
                }
                return isHatch ? new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.HATCH, ScoreState.Position.LOW) : new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.LOW);
            case MIDDLE:
                if(isFront){
                    return isHatch ? new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.HATCH, ScoreState.Position.MIDDLE) : new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.CARGO, ScoreState.Position.MIDDLE);
                }
                return isHatch ? new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.HATCH, ScoreState.Position.MIDDLE) : new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.MIDDLE);
            case HIGH:
                if(isFront){
                    return isHatch ? new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.HATCH, ScoreState.Position.HIGH) : new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.CARGO, ScoreState.Position.HIGH);
                }
                return isHatch ? new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.HATCH, ScoreState.Position.HIGH) : new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.HIGH);
            case STOW:
                    return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.STOW);
        }
        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.STOW);
    }

}
