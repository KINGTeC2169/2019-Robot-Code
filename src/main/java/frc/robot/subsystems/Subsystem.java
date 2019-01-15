package frc.robot.subsystems;

public abstract class Subsystem {
    // These methods are part of every subsystem
    public abstract void handle();
    public abstract void zeroSensors();
    public abstract void stop();
}
