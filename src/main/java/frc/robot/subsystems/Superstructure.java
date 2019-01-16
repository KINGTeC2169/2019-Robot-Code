package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import frc.robot.util.ActuatorMap;

public class Superstructure {

    // Subsystem Instances
    private Arm arm;
    private Intake intake;
    private LEDMachine led;
    private Wrist wrist;

    private Compressor comp;

    public Superstructure() {
        // Initialize Subsystems
        arm = new Arm();
        intake = new Intake();
        led = new LEDMachine();
        wrist = new Wrist();
    }

    public void robotInit() {
        comp.start();
        comp = new Compressor(ActuatorMap.PCMPort);
    }

    public void subsystemLooper() {
        handleSubsystems();
    }

    private void handleSubsystems() {
        arm.handle();
        intake.handle();
        led.handle();
        wrist.handle();
    }

    public void zeroAllSensors() {
        arm.zeroSensors();
        intake.zeroSensors();
        led.zeroSensors();
        wrist.zeroSensors();

    }

    public void stop() {
        arm.stop();
        intake.stop();
        led.stop();
        wrist.stop();
    }
}
