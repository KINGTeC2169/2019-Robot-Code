package frc.robot.util;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        else if(Math.abs(-.25 - input) < .24){
            return ScoreState.Position.LOW;
        }
        else if(Math.abs(.25 - input) < .24){
            return ScoreState.Position.MIDDLE;
        }
        else if(Math.abs(.75 - input) < .24){
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
                    if(isHatch){
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.HATCH, ScoreState.Position.INTAKE);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.CARGO, ScoreState.Position.INTAKE);
                    }
                }
                else{
                    if(isHatch){
                        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.HATCH, ScoreState.Position.INTAKE);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.INTAKE);
                    }
                }
            case LOW:
                if(isFront){
                    if(isHatch){
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.HATCH, ScoreState.Position.LOW);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.CARGO, ScoreState.Position.LOW);
                    }
                }
                else{
                    if(isHatch){
                        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.HATCH, ScoreState.Position.LOW);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.LOW);
                    }
                }
            case MIDDLE:
                if(isFront){
                    if(isHatch){
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.HATCH, ScoreState.Position.MIDDLE);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.CARGO, ScoreState.Position.MIDDLE);
                    }
                }
                else{
                    if(isHatch){
                        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.HATCH, ScoreState.Position.MIDDLE);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.BACK, ScoreState.GameElement.CARGO, ScoreState.Position.MIDDLE);
                    }
                }
            case HIGH:
                if(isFront){
                    if(isHatch){
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.HATCH, ScoreState.Position.HIGH);
                    }
                    else{
                        return new ScoreState(ScoreState.RobotSide.FRONT, ScoreState.GameElement.CARGO, ScoreState.Position.HIGH);
                    }
                }
                else{
                    if(isHatch){
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
