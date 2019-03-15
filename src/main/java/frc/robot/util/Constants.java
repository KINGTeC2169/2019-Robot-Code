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


        public static final int frontHatchStowed = -267;
        public static final int frontHatchIntake = -254;
        public static final int frontHatchLow = -254;
        public static final int frontHatchMid = -430;
        public static final int frontHatchHi = -639;

        public static final int frontCargoStowed = -250;
        public static final int frontCargoIntake = -258;
        public static final int frontCargoLow = -307;
        public static final int frontCargoMid = -460;
        public static final int frontCargoHi = -600;

        public static final int backHatchIntake = -1106;
        public static final int backHatchLow = -1106;
        public static final int backHatchMid = -919;
        public static final int backHatchHi = -739;

        public static final int backCargoIntake = -1080;
        public static final int backCargoLow = -1033;
        public static final int backCargoMid = -889;
        public static final int backCargoHi = -717;
    }

    public static final class WristPositions {

        public static final int frontHatchStowed = -267;
        public static final int frontHatchIntake = 1002;
        public static final int frontHatchLow = 1026;
        public static final int frontHatchMid = 1185;
        public static final int frontHatchHi = 1411;

        public static final int frontCargoStowed = -250;
        public static final int frontCargoIntake = 1177;
        public static final int frontCargoLow = 1063;
        public static final int frontCargoMid = 1200;
        public static final int frontCargoHi = 1243;

        public static final int backHatchIntake = 1376;
        public static final int backHatchLow = 1345;
        public static final int backHatchMid = 1182;
        public static final int backHatchHi = 994;


        public static final int backCargoIntake = 1196;
        public static final int backCargoLow = 1300;
        public static final int backCargoMid = 1183;
        public static final int backCargoHi = 1070;
    }


}



