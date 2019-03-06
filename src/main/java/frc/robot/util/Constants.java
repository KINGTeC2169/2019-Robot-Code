package frc.robot.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public final class Constants {

    public static final boolean debugMode = false;

    // Constants for intake control
    public static final double exhaustThreshold = -0.5;
    public static final double intakeDeadband = 0.05;
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
    public static final double armI = .01;
    public static final double armD = 0.00001;
    public static final int armMaxVel = 40;
    public static final int armMaxAccel = 20;
    public static int armP90 = -370;
    public static int armP270 = -870;
    public static final int armZeroPos = 0;
    public static final int armAllowedError = 0;

    //Wrist Constants
    public static final int wristSlotIdx = 0;
    public static final int wristPIDLoopIdx = 0;
    public static final int wristTimeoutMs = 0;
    public static final double wristP = 20;
    public static final double wristI = 0;
    public static final double wristD = 0;
    public static final double wristF = 6;
    public static final int wristMaxVel = 100;
    public static final int wristMaxAccel = 20;
    public static final int wristZeroPos = 0;
    public static final int wristAllowedError = 3;

    //Arm Position Setpoints
    public static final class ArmPositions {
        public static final int frontCargoStowed = -233;
        public static final int frontHatchStowed = -267;
        public static final int frontCargoIntake = -233;
        public static final int frontHatchIntake = -267;
        public static final int frontCargoLow = -245;
        public static final int frontCargoMid = -480;
        public static final int frontCargoHi = -650;
        public static final int frontHatchLow = -267;
        public static final int frontHatchMid = -433;
        public static final int frontHatchHi = -630;
        public static final int backCargoIntake = -1096;
        public static final int backHatchIntake = -1076;
        public static final int backCargoLow = -1023;
        public static final int backCargoMid = -865;
        public static final int backCargoHi = -685;
        public static final int backHatchLow = -1076;
        public static final int backHatchMid = -920;
        public static final int backHatchHi = -706;
    }

    public static final class WristPositions {
        public static final int frontCargoStowed = 850;
        public static final int frontHatchStowed = 765;
        public static final int frontCargoIntake = 850;
        public static final int frontHatchIntake = 765;
        public static final int frontCargoLow = 890;
        public static final int frontCargoMid = 980;
        public static final int frontCargoHi = 1044;
        public static final int frontHatchLow = 765;
        public static final int frontHatchMid = 934;
        public static final int frontHatchHi = 1125;
        public static final int backCargoIntake = 1012;
        public static final int backHatchIntake = 1062;
        public static final int backCargoLow = 1033;
        public static final int backCargoMid = 872;
        public static final int backCargoHi = 775;
        public static final int backHatchLow = 1062;
        public static final int backHatchMid = 920;
        public static final int backHatchHi = 726;

    }

}

