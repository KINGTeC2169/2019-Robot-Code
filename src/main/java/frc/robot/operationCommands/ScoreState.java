package frc.robot.operationCommands;

import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.operationCommands.scoreStateEnums.*;
import frc.robot.util.Constants;

public class ScoreState {

    private boolean isNewState = false;

    public ScoreState(RobotSide robotSide, GameElement gameElement, Position position, boolean rightTrigger){
        this.robotSide = robotSide;
        this.gameElement = gameElement;
        this.position = position;
        this.rightTrigger = rightTrigger;
    }

    public boolean isNewState(){
        return isNewState;
    }

    public ScoreState(RobotSide robotSide, GameElement gameElement, Position position){
        this.robotSide = robotSide;
        this.gameElement = gameElement;
        this.position = position;
        this.rightTrigger = false;

        if(!Constants.lastScoreState.equals(this.toString())){
            Constants.lastScoreState = this.toString();
            isNewState = true;
            DriverStation.reportWarning("New State", false);
        }

    }

    public final RobotSide robotSide;
    public VisionSide visionSide;
    public final GameElement gameElement;
    public final Position position;

    public int getArmDesiredPos() {
        if(robotSide == RobotSide.MANUAL){
            return -1000;
        }
        if (robotSide == RobotSide.FRONT) {
            if (gameElement == GameElement.CARGO) {
                if (position == Position.LOW) {
                    return Constants.ArmPositions.frontCargoLow;
                }
                else if (position == Position.MIDDLE) {
                    return (Constants.ArmPositions.frontCargoMid);
                }
                else if (position == Position.HIGH) {
                    return (Constants.ArmPositions.frontCargoHi);
                }
                else if (position == Position.INTAKE) {
                    return (Constants.ArmPositions.frontCargoIntake);
                }
                else if (position == Position.STOW){
                    return  (Constants.ArmPositions.frontCargoStowed);
                }
            } else if (gameElement == GameElement.HATCH) {
                if (position == Position.LOW) {
                    return (Constants.ArmPositions.frontHatchLow);
                }
                else if (position == Position.MIDDLE) {
                    return (Constants.ArmPositions.frontHatchMid);
                }
                else if (position == Position.HIGH) {
                    return (Constants.ArmPositions.frontHatchHi);
                }
                else if (position == Position.INTAKE) {
                    return (Constants.ArmPositions.frontHatchIntake);
                }
                else if (position == Position.STOW){
                    return (Constants.ArmPositions.frontHatchStowed);
                }
            }
        } else if (robotSide == RobotSide.BACK) {
            if (gameElement == GameElement.CARGO) {
                if (position == Position.LOW) {
                    return (Constants.ArmPositions.backCargoLow);
                }
                else if (position == Position.MIDDLE) {
                    return (Constants.ArmPositions.backCargoMid);
                }
                else if (position == Position.HIGH) {
                    return (Constants.ArmPositions.backCargoHi);
                }
                else if (position == Position.INTAKE) {
                    return (Constants.ArmPositions.backCargoIntake);
                }
            } else if (gameElement == GameElement.HATCH) {
                if (position == Position.LOW) {
                    return (Constants.ArmPositions.backHatchLow);
                }
                else if (position == Position.MIDDLE) {
                    return (Constants.ArmPositions.backHatchMid);
                }
                else if (position == Position.HIGH) {
                    return (Constants.ArmPositions.backHatchHi);
                }
                else if (position == Position.INTAKE) {
                    return (Constants.ArmPositions.backHatchIntake);
                }
            }
        }
        return 0;
    }

    public int getWristDesiredPos() {
        if(robotSide == RobotSide.MANUAL){
            return -1000;
        }
        if (robotSide == RobotSide.FRONT) {
            if (gameElement == GameElement.CARGO) {
                if (position == Position.LOW) {
                    return Constants.WristPositions.frontCargoLow;
                }
                else if (position == Position.MIDDLE) {
                    return (Constants.WristPositions.frontCargoMid);
                }
                else if (position == Position.HIGH) {
                    return (Constants.WristPositions.frontCargoHi);
                }
                else if (position == Position.INTAKE) {
                    return (Constants.WristPositions.frontCargoIntake);
                }
                else if (position == Position.STOW){
                    return  (Constants.WristPositions.frontCargoStowed);
                }

            } else if (gameElement == GameElement.HATCH) {
                if (position == Position.LOW) {
                    return (Constants.WristPositions.frontHatchLow);
                }
                else if (position == Position.MIDDLE) {
                    return (Constants.WristPositions.frontHatchMid);
                }
                else if (position == Position.HIGH) {
                    return (Constants.WristPositions.frontHatchHi);
                }
                else if (position == Position.INTAKE) {
                    return (Constants.WristPositions.frontHatchIntake);
                }
                else if (position == Position.STOW){
                    return (Constants.WristPositions.frontHatchStowed);
                }
            }

        } else if (robotSide == RobotSide.BACK) {
            if (gameElement == GameElement.CARGO) {
                if (position == Position.LOW) {
                    return (Constants.WristPositions.backCargoLow);
                }
                else if (position == Position.MIDDLE) {
                    return (Constants.WristPositions.backCargoMid);
                }
                else if (position == Position.HIGH) {
                    return (Constants.WristPositions.backCargoHi);
                }
                else if (position == Position.INTAKE) {
                    return (Constants.WristPositions.backCargoIntake);
                }
            } else if (gameElement == GameElement.HATCH) {
                if (position == Position.LOW) {
                    return (Constants.WristPositions.backHatchLow);
                }
                else if (position == Position.MIDDLE) {
                    return (Constants.WristPositions.backHatchMid);
                }
                else if (position == Position.HIGH) {
                    return (Constants.WristPositions.backHatchHi);
                }
                else if (position == Position.INTAKE) {
                    return (Constants.WristPositions.backHatchIntake);
                }

            }
        }
        return 0;

    }

    public VisionSide getVisionside(){
        if(rightTrigger){
            if(this.getRobotSide() == RobotSide.BACK){
                return VisionSide.BACK;
            }
            else if(this.getRobotSide() == RobotSide.FRONT){
                return VisionSide.FRONT;
            } else{
                return VisionSide.AND_UP_THE_SIDES;
            }
        }
        else{
            return VisionSide.AND_UP_THE_SIDES;
        }
    }

    RobotSide getRobotSide() {
        return robotSide;
    }

    GameElement getGameElement() {
        return gameElement;
    }

    Position getPosition() {
        return position;
    }
    private final boolean rightTrigger;

    public String toString(){
        return "" + getRobotSide() + getGameElement() + getPosition();
    }


}
