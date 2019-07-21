package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.operationCommands.ScoreState;
import frc.robot.operationCommands.scoreStateEnums.*;

//This class packs up the operator panel's communications into an easily accessible unit
@SuppressWarnings("FieldCanBeLocal")
class OperatorPanel {

    private final Joystick panel = new Joystick(3);

    private Position joystickAnalogToPosition(){
        double input = panel.getRawAxis(0);
        if(Math.abs(-.75 - input) < .24){
            return Position.INTAKE;
        }
        else if(Math.abs(-.25 - input) < .24){
            return Position.LOW;
        }
        else if(Math.abs(.25 - input) < .24){
            return Position.MIDDLE;
        }
        else if(Math.abs(.75 - input) < .24){
            return Position.HIGH;
        }
        else {
            return Position.INTAKE;
        }
    }

    ScoreState getOperatorDesiredState(){

        boolean isFront = panel.getRawButton(4);
        boolean isHatch = panel.getRawButton(3);

        switch(joystickAnalogToPosition()) {
            case INTAKE:
                if(isFront && isHatch) {
                    return new ScoreState(RobotSide.FRONT, GameElement.HATCH, Position.INTAKE);
                } else if(isFront && !isHatch) {
                    return new ScoreState(RobotSide.FRONT, GameElement.CARGO, Position.INTAKE);
                } else if(!isFront && isHatch) {
                    return new ScoreState(RobotSide.BACK, GameElement.HATCH, Position.INTAKE);
                } else {
                    return new ScoreState(RobotSide.BACK, GameElement.CARGO, Position.INTAKE);
                }
            case LOW:
                if(isFront && isHatch) {
                    return new ScoreState(RobotSide.FRONT, GameElement.HATCH, Position.LOW);
                } else if(isFront && !isHatch) {
                    return new ScoreState(RobotSide.FRONT, GameElement.CARGO, Position.LOW);
                } else if(!isFront && isHatch) {
                    return new ScoreState(RobotSide.BACK, GameElement.HATCH, Position.LOW);
                } else {
                    return new ScoreState(RobotSide.BACK, GameElement.CARGO, Position.LOW);
                }
            case MIDDLE:
                if(isFront && isHatch) {
                    return new ScoreState(RobotSide.FRONT, GameElement.HATCH, Position.MIDDLE);
                } else if(isFront && !isHatch) {
                    return new ScoreState(RobotSide.FRONT, GameElement.CARGO, Position.MIDDLE);
                } else if(!isFront && isHatch) {
                    return new ScoreState(RobotSide.BACK, GameElement.HATCH, Position.MIDDLE);
                } else {
                    return new ScoreState(RobotSide.BACK, GameElement.CARGO, Position.MIDDLE);
                }
            case HIGH:
                if(isFront && isHatch) {
                    return new ScoreState(RobotSide.FRONT, GameElement.HATCH, Position.HIGH);
                } else if(isFront && !isHatch) {
                    return new ScoreState(RobotSide.FRONT, GameElement.CARGO, Position.HIGH);
                } else if(!isFront && isHatch) {
                    return new ScoreState(RobotSide.BACK, GameElement.HATCH, Position.HIGH);
                } else {
                    return new ScoreState(RobotSide.BACK, GameElement.CARGO, Position.HIGH);
                }
        }

        return new ScoreState(RobotSide.BACK, GameElement.CARGO, Position.STOW);
    }

}
