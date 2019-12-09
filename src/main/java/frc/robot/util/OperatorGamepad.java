package frc.robot.util;

import frc.robot.operationCommands.ScoreState;
import frc.robot.operationCommands.scoreStateEnums.GameElement;
import frc.robot.operationCommands.scoreStateEnums.Position;
import frc.robot.operationCommands.scoreStateEnums.RobotSide;

public class OperatorGamepad {

    //Starting state is front low cargo to forcibly prevent geometry confliction.
    private ScoreState previousState = new ScoreState(RobotSide.FRONT, GameElement.CARGO, Position.LOW);

    private GameElement lastReceived = GameElement.CARGO;
    private final XboxController operator;

    OperatorGamepad(int joy){
        operator = new XboxController(joy);
    }

    double wristJogThrottle(){
        return operator.getJoystick(XboxController.Side.LEFT, XboxController.Axis.Y);
    }

    double armJogThrottle(){
        return operator.getJoystick(XboxController.Side.RIGHT, XboxController.Axis.Y);
    }

    ScoreState getScoreState(){
        previousState = generateScoreState();
        return previousState;
    }

    ScoreState generateScoreState(){
        RobotSide side;

        //Handle side toggle.  Default to front
        if(operator.getTrigger(XboxController.Side.LEFT)){
            side = RobotSide.BACK;
        }
        else{
            side = RobotSide.FRONT;
        }

        //Handle intake options
        if(operator.getTrigger(XboxController.Side.RIGHT)){
            lastReceived = GameElement.CARGO;
            return new ScoreState(side, lastReceived, Position.INTAKE);
        }
        else if(operator.getButton(XboxController.Button.RB)){
            lastReceived = GameElement.HATCH;
            return new ScoreState(side, lastReceived, Position.INTAKE);
        }

        //Stow if left bumper pressed
        if(operator.getButton(XboxController.Button.LB)){
            return new ScoreState(RobotSide.FRONT, GameElement.HATCH, Position.INTAKE);
        }

        if(operator.getButton(XboxController.Button.A)){
            return new ScoreState(side, lastReceived, Position.LOW);
        }
        else if(operator.getButton(XboxController.Button.B)){
            return new ScoreState(side, lastReceived, Position.MIDDLE);
        }
        else if(operator.getButton(XboxController.Button.Y)){
            return new ScoreState(side, lastReceived, Position.HIGH);
        }
        else if(operator.getButton(XboxController.Button.X)){
            return new ScoreState(side, lastReceived, Position.CARGO);
        }
        return new ScoreState(side, previousState.gameElement, previousState.position);
    }
}
