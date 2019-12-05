package frc.robot.util;

public final class Constants {

    public static final boolean debugMode = false;

    // Constants for intake control
    public static final double exhaustThreshold = -0.5;
    public static final double intakeDeadband = 0.2;
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
    public static final double armP = 3;
    public static final double armI = 0.001;
    public static final double armD = 0.001;
    public static final int armMaxVel = 120;
    public static final int armMaxAccel = 120;
    public static final int armP90 = -106*4;
    public static final int armP270 = 395*4;
    public static final int armZeroPos = 0;
    public static final int armAllowedError = 0;
    public static final int startingArmOffset = 339*4;
    // TODO: Test for and set following values
    public static final boolean armSensorDiscontinuity = true;
    public static final int armSensorEnd_0 = 910*4;
    public static final int armSensorEnd_1 = 1137*4;

    //Wrist Constants
    public static final int wristSlotIdx = 0;
    public static final int wristPIDLoopIdx = 0;
    public static final int wristTimeoutMs = 0;
    public static final double wristP = 2;
    public static final double wristI = 0;
    public static final double wristD = 0;
    public static final double wristF = 6;
    public static final int wristMaxVel = 150;
    public static final int wristMaxAccel = 150;
    public static final int wristZeroPos = 0;
    public static final int wristAllowedError = 3;
    public static String lastScoreState = "";
    public static final int startingWristOffset = -456*4;
    // TODO: Test for and set following values
    public static final boolean wristSensorDiscontinuity = true;
    public static final int wristSensorEnd_0 = 910*4;
    public static final int wristSensorEnd_1 = 1137*4;
    public static double joystickThreshold = 0.2;

    //Arm Position Setpoints
    public static final class ArmPositions {
        public static final int frontHatchStowed = -339*4;
        public static final int frontHatchIntake = -339*4;
        public static final int frontHatchLow = -210*4;
        public static final int frontCargoShip = -100*4;
        public static final int frontHatchHi = 120*4;

        public static final int frontCargoStowed = -303*4;
        public static final int frontCargoIntake = -303*4;
        public static final int frontCargoLow = -197*4;
        public static final int frontCargoMid = -37*4;
        public static final int frontCargoHi = 120*4;

        public static final int backHatchIntake = 534*4;
        public static final int backHatchLow = 511*4;
        public static final int backHatchMid = 340*4;
        public static final int backHatchHi = 181*4;

        public static final int backCargoIntake = 534*4;
        public static final int backCargoLow = 511*4;
        public static final int backCargoMid = 340*4;
        public static final int backCargoHi = 181*4;
    }

    public static final class WristPositions {

        public static final int frontHatchStowed = 456*4;
        public static final int frontHatchIntake = 456*4;
        public static final int frontHatchLow = 300*4;
        public static final int frontCargoShip = 103*4;
        public static final int frontHatchHi = 44*4;

        public static final int frontCargoStowed = 256*4;
        public static final int frontCargoIntake = 256*4;
        public static final int frontCargoLow = 300*4;
        public static final int frontCargoMid = 131*4;
        public static final int frontCargoHi = 44*4;

        public static final int backHatchIntake = 280*4;
        public static final int backHatchLow = 60*4;
        public static final int backHatchMid = 237*4;
        public static final int backHatchHi = 312*4;

        public static final int backCargoIntake = 280*4;
        public static final int backCargoLow = 60*4;
        public static final int backCargoMid = 237*4;
        public static final int backCargoHi = 312*4;
    }
}



