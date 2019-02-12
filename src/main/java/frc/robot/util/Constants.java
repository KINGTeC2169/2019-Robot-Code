package frc.robot.util;

public class Constants {

    public static final boolean debugMode = true;

    // Constants for intake control
    public static final double exhaustThreshold = -0.5;
    public static final double intakeDeadband = 0.05;

    // Constants for intake sensor
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
    public static final int armAllowedError = 3;

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
    public static final int wristAllowedError = 3;


    //Method for converting degrees to Grayhill Encoder ticks (1024 ticks per rotation)
    public static int degreesToTicks(double deg){
        return (int) (deg * 1024.0/360.0);
    }

    //Arm Position Setpoints
    public static class ArmPositions {
        public static final double frontCargoStowed = 90;
        public static final double frontHatchStowed = 90;
        public static final double frontCargoIntake = 0;
        public static final double frontHatchIntake = -120;
        public static final double backCargoIntake = 0;
        public static final double backHatchIntake = -120;
        public static final double frontCargoLow = -147;
        public static final double frontCargoMid = 160;
        public static final double frontCargoHi = 120;
        public static final double backCargoLow = -147;
        public static final double backCargoMid = 160;
        public static final double backCargoHi = 120;
        public static final double frontHatchLow = -120;
        public static final double frontHatchMid = 175;
        public static final double frontHatchHi = 100;
        public static final double backHatchLow = -120;
        public static final double backHatchMid = 175;
        public static final double backHatchHi = 100;
    }

    public static class WristPositions {
        public static final double frontTopCargo = 0;
        public static final double backTopCargo = 0;
        public static final double frontIntake = 0;
        public static final double backIntake = 0;
        public static double snap = 0;
        public static double backToFront = 0;
        public static double frontToBack = 0;

    }

}

