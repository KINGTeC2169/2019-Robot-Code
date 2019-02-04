package frc.robot.operationCommands;

import frc.robot.util.Constants;

public class ScoreState {

    public enum RobotSide {
        FRONT, BACK
    }

    public RobotSide robotSide;

    public enum GameElement {
        HATCH, CARGO
    }

    public GameElement gameElement;

    public enum Position {
        HIGH, MIDDLE, LOW, INTAKE, STOW
    }

    public Position position;

    public int getArmAngle() {
        if (robotSide == RobotSide.FRONT) {
            if (gameElement == GameElement.CARGO) {
                if (position == Position.LOW) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontCargoLow);
                } else if (position == Position.MIDDLE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontCargoMid);
                } else if (position == Position.HIGH) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontCargoHi);
                }
                else if (position == Position.INTAKE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontCargoIntake);
                }
                else if (position == Position.STOW){
                    return  Constants.degreesToTicks(Constants.ArmPositions.frontCargoStowed);
                }

            } else if (gameElement == GameElement.HATCH) {
                if (position == Position.LOW) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontHatchLow);
                } else if (position == Position.MIDDLE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontHatchMid);
                } else if (position == Position.HIGH) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontHatchHi);
                }
                else if (position == Position.INTAKE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.frontHatchIntake);
                }
                else  if (position == Position.STOW){
                    return Constants.degreesToTicks(Constants.ArmPositions.frontHatchStowed);
                }
            }

        } else if (robotSide == RobotSide.BACK) {
            if (gameElement == GameElement.CARGO) {
                if (position == Position.LOW) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backCargoLow);
                } else if (position == Position.MIDDLE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backCargoMid);
                } else if (position == Position.HIGH) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backCargoHi);
                }
                else if (position == Position.INTAKE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backCargoIntake);
                }
            } else if (gameElement == GameElement.HATCH) {
                if (position == Position.LOW) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backHatchLow);
                } else if (position == Position.MIDDLE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backHatchMid);
                } else if (position == Position.HIGH) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backHatchHi);
                }
                else  if (position == Position.INTAKE) {
                    return Constants.degreesToTicks(Constants.ArmPositions.backHatchIntake);
                }

            }


        }
        return 0;

    }
}
