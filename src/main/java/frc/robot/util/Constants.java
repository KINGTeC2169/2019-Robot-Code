package frc.robot.util;

public final class Constants {

    public static final boolean debugMode = false;

    // Constants for intake control
    public static final double exhaustThreshold = -0.5;
    public static final double intakeDeadband = 0.05;

    // Constants for intake sensor
    public static final double intakeProxLowerBound = 0;
    public static final double intakeProxUpperBound = 1;


    // Drivetrain Constants
    public static final double driveTrainDeadband = 0.1;

    //Arm Constants
    public static final int armSlotIdx = 0;
    public static final int armPIDLoopIdx = 0;
    public static final int armTimeoutMs = 10;
    public static final double armP = 20;
    public static final double armI = .07;
    public static final double armD = .001;
    public static final double armF = .6;
    public static final int armMaxVel = 150;
    public static final int armMaxAccel = 10;
    public static final int armZeroPos = 0;
    public static final int armAllowedError = 0;

    //Wrist Constants
    public static final int wristSlotIdx = 0;
    public static final int wristPIDLoopIdx = 0;
    public static final int wristTimeoutMs = 0;
    public static final double wristP = 0;
    public static final double wristI = 0;
    public static final double wristD = 0;
    public static final double wristF = 0;
    public static final int wristMaxVel = 0;
    public static final int wristMaxAccel = 0;
    public static final int wristZeroPos = 0;
    public static final int wristAllowedError = 3;

    public static int ticksToDegrees(double ticks){
        return (int) (ticks * 360.0/1024.0);
    }

    //Arm Position Setpoints
    public static final class ArmPositions {
        public static final int frontCargoStowed = 50;
        public static final int frontHatchStowed = 65;
        public static final int frontCargoIntake = 25;
        public static final int frontHatchIntake = 30;
        public static final int frontCargoLow = 50;
        public static final int frontCargoMid = 125;
        public static final int frontCargoHi = 170;
        public static final int frontHatchLow = 30;
        public static final int frontHatchMid = 100;
        public static final int frontHatchHi = 135;
        public static final int backCargoIntake = 425;
        public static final int backHatchIntake = 425;
        public static final int backCargoLow = 400;
        public static final int backCargoMid = 340;
        public static final int backCargoHi = 300;
        public static final int backHatchLow = 400;
        public static final int backHatchMid = 350;
        public static final int backHatchHi = 300;
    }

    public static final class WristPositions {
        public static final double frontTopCargo = 0;
        public static final double backTopCargo = 0;
        public static final double frontIntake = 0;
        public static final double backIntake = 0;
        public static final double snap = 0;
        public static final double backToFront = 0;
        public static final double frontToBack = 0;

    }

}

