package frc.robot.operationCommands;

import frc.robot.util.Constants;

public class ScoreState {

    ScoreState(double operatorPanelState){

    }

    public enum RobotSide {
        FRONT, BACK
    }

    private RobotSide robotSide;

    public enum GameElement {
        HATCH, CARGO
    }

    private GameElement gameElement;

    public enum Position {
        HIGH, MIDDLE, LOW, INTAKE, STOW
    }

    private Position position;

    public int getArmAngle() {
        if (robotSide == RobotSide.FRONT) {
            if (gameElement == GameElement.CARGO) {
                if (position == Position.LOW) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontCargoLow);
                }
                if (position == Position.MIDDLE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontCargoMid);
                }
                if (position == Position.HIGH) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontCargoHi);
                }
                if (position == Position.INTAKE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontCargoIntake);
                }
                if (position == Position.STOW){
                    return  Constants.degreesToTicks(Constants.ArmPositions.frontCargoStowed);
                }

            } else if (gameElement == GameElement.HATCH) {
                if (position == Position.LOW) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontHatchLow);
                }
                if (position == Position.MIDDLE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontHatchMid);
                }
                if (position == Position.HIGH) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontHatchHi);
                }
                if (position == Position.INTAKE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontHatchIntake);
                }
                if (position == Position.STOW){
                    return Constants.degreesToTicks(Constants.ArmPositions.frontHatchStowed);
                }
            }

        } else if (robotSide == RobotSide.BACK) {
            if (gameElement == GameElement.CARGO) {
                if (position == Position.LOW) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backCargoLow);
                }
                if (position == Position.MIDDLE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backCargoMid);
                }
                if (position == Position.HIGH) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backCargoHi);
                }
                if (position == Position.INTAKE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backCargoIntake);
                }
            } else if (gameElement == GameElement.HATCH) {
                if (position == Position.LOW) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backHatchLow);
                }
                if (position == Position.MIDDLE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backHatchMid);
                }
                if (position == Position.HIGH) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backHatchHi);
                }
                if (position == Position.INTAKE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backHatchIntake);
                }

            }


        }
        return 0;

    }
}
