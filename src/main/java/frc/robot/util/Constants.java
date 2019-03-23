package frc.robot.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    public static final double armP = 10;
    public static final double armI = 0.01;
    public static final double armD = 0;
    public static final int armMaxVel = 40;
    public static final int armMaxAccel = 20;
    public static int armP90 = 0;
    public static int armP270 = -512;
    public static final int armZeroPos = 0;
    public static final int armAllowedError = 0;
    public static final int startingArmOffset = 0;

    //Wrist Constants
    public static final int wristSlotIdx = 0;
    public static final int wristPIDLoopIdx = 0;
    public static final int wristTimeoutMs = 0;
    public static final double wristP = 20;
    public static final double wristI = .01;
    public static final double wristD = 0.0001;
    public static final double wristF = 6;
    public static final int wristMaxVel = 100;
    public static final int wristMaxAccel = 30;
    public static final int wristZeroPos = 0;
    public static final int wristAllowedError = 3;
    public static String lastScoreState = "";
    public static final int startingWristOffset = 0;

    //Arm Position Setpoints
    public static final class ArmPositions {
        public static final int frontHatchStowed = -407;
        public static final int frontHatchIntake = -407;
        public static final int frontHatchLow = -488;
        public static final int frontHatchMid = -628;
        public static final int frontHatchHi = -796;

        public static final int frontCargoStowed = -438;
        public static final int frontCargoIntake = -438;
        public static final int frontCargoLow = -518;
        public static final int frontCargoMid = -677;
        public static final int frontCargoHi = -845;

        public static final int backHatchIntake = -1257;
        public static final int backHatchLow = -1229;
        public static final int backHatchMid = -1070;
        public static final int backHatchHi = -873;

        public static final int backCargoIntake = -1257;
        public static final int backCargoLow = -1229;
        public static final int backCargoMid = -1070;
        public static final int backCargoHi = -873;
    }

    public static final class WristPositions {

        public static final int frontHatchStowed = -351;
        public static final int frontHatchIntake = -351;
        public static final int frontHatchLow = -650;
        public static final int frontHatchMid = -714;
        public static final int frontHatchHi = -863;

        public static final int frontCargoStowed = -579;
        public static final int frontCargoIntake = -579;
        public static final int frontCargoLow = -531;
        public static final int frontCargoMid = -680;
        public static final int frontCargoHi = -770;

        public static final int backHatchIntake = -565;
        public static final int backHatchLow = -747;
        public static final int backHatchMid = -603;
        public static final int backHatchHi = -462;

        public static final int backCargoIntake = -565;
        public static final int backCargoLow = -747;
        public static final int backCargoMid = -603;
        public static final int backCargoHi = -462;
    }
}



