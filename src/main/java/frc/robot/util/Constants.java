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
    public static final double armI = 0.01;
    public static final double armD = 0;
    public static final int armMaxVel = 40;
    public static final int armMaxAccel = 20;
    public static int armP90 = 0;
    public static int armP270 = -512;
    public static final int armZeroPos = 0;
    public static final int armAllowedError = 0;

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

    //Arm Position Setpoints
    public static final class ArmPositions {


        public static final int frontHatchStowed = -341;
        public static final int frontHatchIntake = -341;
        public static final int frontHatchLow = -341;
        public static final int frontHatchMid = -506;
        public static final int frontHatchHi = -642;

        public static final int frontCargoStowed = -216;
        public static final int frontCargoIntake = -236;
        public static final int frontCargoLow = -336;
        public static final int frontCargoMid = -496;
        public static final int frontCargoHi = -660;

        public static final int backHatchIntake = -341;
        public static final int backHatchLow = -341;
        public static final int backHatchMid = -506;
        public static final int backHatchHi = -642;

        public static final int backCargoIntake = -1065;
        public static final int backCargoLow = -1045;
        public static final int backCargoMid = -890;
        public static final int backCargoHi = -712;
    }

    public static final class WristPositions {

        public static final int frontHatchStowed = -1072;
        public static final int frontHatchIntake = -1072;
        public static final int frontHatchLow = -1072;
        public static final int frontHatchMid = -1214;
        public static final int frontHatchHi = -1213;

        public static final int frontCargoStowed = -216;
        public static final int frontCargoIntake = -216;
        public static final int frontCargoLow = -223;
        public static final int frontCargoMid = -370;
        public static final int frontCargoHi = -440;

        public static final int backHatchIntake = -1072;
        public static final int backHatchLow = -1072;
        public static final int backHatchMid = -1214;
        public static final int backHatchHi = -1213;

        public static final int backCargoIntake = -189;
        public static final int backCargoLow = -417;
        public static final int backCargoMid = -261;
        public static final int backCargoHi = -133;
    }


}



