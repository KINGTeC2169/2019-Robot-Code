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

}
