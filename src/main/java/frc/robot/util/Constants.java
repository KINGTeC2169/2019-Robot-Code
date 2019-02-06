package frc.robot.util;

public class Constants {

    public static boolean debugMode = true;

    // Constants for intake
    public static final double exhaustThreshold = -0.5;
    public static final double intakeDeadband = 0.05;

    public static double intakeProxLowerBound = 0;
    public static double intakeProxUpperBound = 1;


    // Drivetrain Constants
    public static final double driveTrainDeadband = 0.1;

    //Arm Constants
    public static final int armSlotIdx = 0;
    public static final int armPIDLoopIdx = 0;
    public static final int armTimeoutMs = 10;
    public static final double armP = 0;
    public static final double armI = 0;
    public static final double armD = 0;
    public static final double armF = 0;
    public static final int armMaxVel = 0;
    public static final int armMaxAccel = 0;
    public static final int armZeroPos = 0;

    //Wrist Constants
    public static final int wristSlotIdx = 0;
    public static final int wristPIDLoopIdx = 0;
    public static final int wristTimeoutMs = 10;
    public static final double wristP = 0;
    public static final double wristI = 0;
    public static final double wristD = 0;
    public static final double wristF = 0;
    public static final int wristMaxVel = 0;
    public static final int wristMaxAccel = 0;
    public static final int wristZeroPos = 0;


    public static int degreesToTicks(double deg){
        return (int) (deg * 1024.0/360.0);
    }

    public static class ArmPositions {
        public static double frontCargoStowed = 90;
        public static double frontHatchStowed = 90;
        public static double frontCargoIntake = 0;
        public static double frontHatchIntake = -120;
        public static double backCargoIntake = 0;
        public static double backHatchIntake = -120;
        public static double frontCargoLow = -147;
        public static double frontCargoMid = 160;
        public static double frontCargoHi = 120;
        public static double backCargoLow = -147;
        public static double backCargoMid = 160;
        public static double backCargoHi = 120;
        public static double frontHatchLow = -120;
        public static double frontHatchMid = 175;
        public static double frontHatchHi = 100;
        public static double backHatchLow = -120;
        public static double backHatchMid = 175;
        public static double backHatchHi = 100;
    }

}

