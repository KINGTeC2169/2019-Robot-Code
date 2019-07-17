package frc.robot.util;

public final class Constants {

    public static final boolean debugMode = false;

    // Constants for intake control
    public static final double exhaustThreshold = -0.5;
    public static final double intakeDeadband = 0.1;
    public static float intakeHoldVoltage = 3;

    // Constants for intake sensor
    public static final double intakeProxLowerBound = 0;
    public static final double intakeProxUpperBound = 1;

    // Drivetrain Constants
    public static final double driveTrainDeadband = 0.1;

    //Arm Constants
    public static final int armSlotIdx = 0;
    public static final int armPIDLoopIdx = 0;
    public static final int armTimeoutMs = 10;
    public static final double armP = 15;
    public static final double armI = 0.001;
    public static final double armD = 0.001;
    public static final int armMaxVel = 40;
    public static final int armMaxAccel = 20;
    public static final int armP90 = -106;
    public static final int armP270 = 395;
    public static final int armZeroPos = 0;
    public static final int armAllowedError = 0;
    public static final int startingArmOffset = -230;

    //Wrist Constants
    public static final int wristSlotIdx = 0;
    public static final int wristPIDLoopIdx = 0;
    public static final int wristTimeoutMs = 0;
    public static final double wristP = 12;
    public static final double wristI = 0;
    public static final double wristD = 0;
    public static final double wristF = 6;
    public static final int wristMaxVel = 100;
    public static final int wristMaxAccel = 30;
    public static final int wristZeroPos = 0;
    public static final int wristAllowedError = 3;
    public static String lastScoreState = "";
    public static final int startingWristOffset = -1457;

    //Arm Position Setpoints
    public static final class ArmPositions {
        public static final int frontHatchStowed = -303;
        public static final int frontHatchIntake = -303;
        public static final int frontHatchLow = -210;
        public static final int frontHatchMid = -100;
        public static final int frontHatchHi = 120;

        public static final int frontCargoStowed = -303;
        public static final int frontCargoIntake = -303;
        public static final int frontCargoLow = -210;
        public static final int frontCargoMid = -45;
        public static final int frontCargoHi = 120;

        public static final int backHatchIntake = 534;
        public static final int backHatchLow = 511;
        public static final int backHatchMid = 340;
        public static final int backHatchHi = 181;

        public static final int backCargoIntake = 534;
        public static final int backCargoLow = 511;
        public static final int backCargoMid = 340;
        public static final int backCargoHi = 181;
    }

    public static final class WristPositions {

        public static final int frontHatchStowed = 256;
        public static final int frontHatchIntake = 256;
        public static final int frontHatchLow = 300;
        public static final int frontHatchMid = 103;
        public static final int frontHatchHi = 44;

        public static final int frontCargoStowed = 256;
        public static final int frontCargoIntake = 256;
        public static final int frontCargoLow = 300;
        public static final int frontCargoMid = 131;
        public static final int frontCargoHi = 44;

        public static final int backHatchIntake = 280;
        public static final int backHatchLow = 60;
        public static final int backHatchMid = 237;
        public static final int backHatchHi = 312;

        public static final int backCargoIntake = 280;
        public static final int backCargoLow = 60;
        public static final int backCargoMid = 237;
        public static final int backCargoHi = 312;
    }
}



