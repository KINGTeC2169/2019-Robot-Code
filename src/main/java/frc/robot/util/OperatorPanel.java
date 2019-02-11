package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.operationCommands.ScoreState;

//This class packs up the operator panel's communications into an easily accessible unit
class OperatorPanel {

    private final Joystick panel = new Joystick(4);
    private final int isFrontButton = 8;
    private final int isHatchButton = 9;
    private final int operatorOverrideButton = 10;

    private ScoreState.Position joystickAnalogToPosition(){
        if(Math.abs(-.75 - panel.getRawAxis(0)) < .24){
            return ScoreState.Position.INTAKE;
        }
        else if(Math.abs(-.25 - panel.getRawAxis(0)) < .24){
            return ScoreState.Position.LOW;
        }
        else if(Math.abs(.25 - panel.getRawAxis(0)) < .24){
            return ScoreState.Position.MIDDLE;
        }
        else if(Math.abs(.75 - panel.getRawAxis(0)) < .24){
            return ScoreState.Position.HIGH;
        }
        return ScoreState.Position.INTAKE;
    }

    boolean getOperatorOverrideButton(){
        return panel.getRawButton(operatorOverrideButton);
    }

    ScoreState getOperatorDesiredState(){

        switch(joystickAnalogToPosition()){
            case INTAKE:
                if(panel.getRawButton(isFrontButton)){
                    if(panel.getRawButton(isHatchButton)){
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.HATCH, ScoreState.Position.INTAKE);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.CARGO, ScoreState.Position.INTAKE);
                    }
                }
                else{
                    if(panel.getRawButton(isHatchButton)){
                        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.HATCH, ScoreState.Position.INTAKE);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.INTAKE);
                    }
                }
            case LOW:
                if(panel.getRawButton(isFrontButton)){
                    if(panel.getRawButton(isHatchButton)){
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.HATCH, ScoreState.Position.LOW);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.CARGO, ScoreState.Position.LOW);
                    }
                }
                else{
                    if(panel.getRawButton(isHatchButton)){
                        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.HATCH, ScoreState.Position.LOW);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.LOW);
                    }
                }
            case MIDDLE:
                if(panel.getRawButton(isFrontButton)){
                    if(panel.getRawButton(isHatchButton)){
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.HATCH, ScoreState.Position.MIDDLE);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.CARGO, ScoreState.Position.MIDDLE);
                    }
                }
                else{
                    if(panel.getRawButton(isHatchButton)){
                        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.HATCH, ScoreState.Position.MIDDLE);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.MIDDLE);
                    }
                }
            case HIGH:
                if(panel.getRawButton(isFrontButton)){
                    if(panel.getRawButton(isHatchButton)){
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.HATCH, ScoreState.Position.HIGH);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.CARGO, ScoreState.Position.HIGH);
                    }
                }
                else{
                    if(panel.getRawButton(isHatchButton)){
                        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.HATCH, ScoreState.Position.HIGH);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.HIGH);
                    }
                }
            case STOW:
                    return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.STOW);
        }
        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.STOW);
    }

}
