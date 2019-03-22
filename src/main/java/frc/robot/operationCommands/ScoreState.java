package frc.robot.operationCommands;

import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.util.Constants;

public class ScoreState {

    public boolean isNewState = false;

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

    public enum RobotSide {
        FRONT, BACK, MANUAL
    }
    public final RobotSide robotSide;

    public enum VisionSide{
        FRONT, BACK, AND_UP_THE_SIDES
    }

    public VisionSide visionSide;

    public enum GameElement {
        HATCH, CARGO
    }

    public final GameElement gameElement;

    public enum Position {
        HIGH, MIDDLE, LOW, INTAKE, STOW
    }

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
                if (position == Position.MIDDLE) {
                    return (Constants.ArmPositions.frontCargoMid);
                }
                if (position == Position.HIGH) {
                    return (Constants.ArmPositions.frontCargoHi);
                }
                if (position == Position.INTAKE) {
                    return (Constants.ArmPositions.frontCargoIntake);
                }
                if (position == Position.STOW){
                    return  (Constants.ArmPositions.frontCargoStowed);
                }

            } else if (gameElement == GameElement.HATCH) {
                if (position == Position.LOW) {
                    return (Constants.ArmPositions.frontHatchLow);
                }
                if (position == Position.MIDDLE) {
                    return (Constants.ArmPositions.frontHatchMid);
                }
                if (position == Position.HIGH) {
                    return (Constants.ArmPositions.frontHatchHi);
                }
                if (position == Position.INTAKE) {
                    return (Constants.ArmPositions.frontHatchIntake);
                }
                if (position == Position.STOW){
                    return (Constants.ArmPositions.frontHatchStowed);
                }
            }

        } else if (robotSide == RobotSide.BACK) {
            if (gameElement == GameElement.CARGO) {
                if (position == Position.LOW) {
                    return (Constants.ArmPositions.backCargoLow);
                }
                if (position == Position.MIDDLE) {
                    return (Constants.ArmPositions.backCargoMid);
                }
                if (position == Position.HIGH) {
                    return (Constants.ArmPositions.backCargoHi);
                }
                if (position == Position.INTAKE) {
                    return (Constants.ArmPositions.backCargoIntake);
                }
            } else if (gameElement == GameElement.HATCH) {
                if (position == Position.LOW) {
                    return (Constants.ArmPositions.backHatchLow);
                }
                if (position == Position.MIDDLE) {
                    return (Constants.ArmPositions.backHatchMid);
                }
                if (position == Position.HIGH) {
                    return (Constants.ArmPositions.backHatchHi);
                }
                if (position == Position.INTAKE) {
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
                if (position == Position.MIDDLE) {
                    return (Constants.WristPositions.frontCargoMid);
                }
                if (position == Position.HIGH) {
                    return (Constants.WristPositions.frontCargoHi);
                }
                if (position == Position.INTAKE) {
                    return (Constants.WristPositions.frontCargoIntake);
                }
                if (position == Position.STOW){
                    return  (Constants.WristPositions.frontCargoStowed);
                }

            } else if (gameElement == GameElement.HATCH) {
                if (position == Position.LOW) {
                    return (Constants.WristPositions.frontHatchLow);
                }
                if (position == Position.MIDDLE) {
                    return (Constants.WristPositions.frontHatchMid);
                }
                if (position == Position.HIGH) {
                    return (Constants.WristPositions.frontHatchHi);
                }
                if (position == Position.INTAKE) {
                    return (Constants.WristPositions.frontHatchIntake);
                }
                if (position == Position.STOW){
                    return (Constants.WristPositions.frontHatchStowed);
                }
            }

        } else if (robotSide == RobotSide.BACK) {
            if (gameElement == GameElement.CARGO) {
                if (position == Position.LOW) {
                    return (Constants.WristPositions.backCargoLow);
                }
                if (position == Position.MIDDLE) {
                    return (Constants.WristPositions.backCargoMid);
                }
                if (position == Position.HIGH) {
                    return (Constants.WristPositions.backCargoHi);
                }
                if (position == Position.INTAKE) {
                    return (Constants.WristPositions.backCargoIntake);
                }
            } else if (gameElement == GameElement.HATCH) {
                if (position == Position.LOW) {
                    return (Constants.WristPositions.backHatchLow);
                }
                if (position == Position.MIDDLE) {
                    return (Constants.WristPositions.backHatchMid);
                }
                if (position == Position.HIGH) {
                    return (Constants.WristPositions.backHatchHi);
                }
                if (position == Position.INTAKE) {
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
    boolean rightTrigger;

    public String toString(){
        return "" + getRobotSide() + getGameElement() + getPosition();
    }


}
