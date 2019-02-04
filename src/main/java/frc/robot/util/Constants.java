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

    public static final int armSlotIdx = 0;
    public static final int armPIDLoopIdx = 0;
    public static final int armTimeoutMs = 10;
    public static final double armP = 0;
    public static final double armI = 0;
    public static final double armD = 0;
    public static final double armF = 0;
    public static final int armMaxVel = 0;
    public static final int armMaxAccel = 0;


    public static int degreesToTicks(double deg){
        return (int) (deg * 1024.0/360.0);
    }

    public static class ArmPositions {
        public static double frontCargoStowed = 0;
        public static double frontHatchStowed = 0;
        public static double frontCargoIntake = 0;
        public static double frontHatchIntake = 0;
        public static double backCargoIntake = 0;
        public static double backHatchIntake = 0;
        public static double frontCargoLow = 0;
        public static double frontCargoMid = 0;
        public static double frontCargoHi = 0;
        public static double backCargoLow = 0;
        public static double backCargoMid = 0;
        public static double backCargoHi = 0;
        public static double frontHatchLow = 0;
        public static double frontHatchMid = 0;
        public static double frontHatchHi = 0;
        public static double backHatchLow = 0;
        public static double backHatchMid = 0;
        public static double backHatchHi = 0;
    }

}

