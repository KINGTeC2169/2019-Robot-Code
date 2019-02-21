package frc.robot.operationCommands;

import frc.robot.util.Constants;

public class ScoreState {

    public ScoreState(RobotSide robotSide, GameElement gameElement, Position position){
        this.robotSide = robotSide;
        this.gameElement = gameElement;
        this.position = position;
    }

    public enum RobotSide {
        FRONT, BACK, MANUAL
    }

    public final RobotSide robotSide;

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


    RobotSide getRobotSide() {
        return robotSide;
    }

    GameElement getGameElement() {
        return gameElement;
    }

    Position getPosition() {
        return position;
    }


}
