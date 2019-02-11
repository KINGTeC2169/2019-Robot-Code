package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;

public class Superstructure {

    // Subsystem Instances
    private final Arm arm;
    private final Intake intake;
    private final LEDMachine led;
    private final Wrist wrist;

    public Superstructure() {
        arm = new Arm();
        intake = new Intake();
        led = new LEDMachine();
        wrist = new Wrist();

    }

    public void robotInit() {
        Compressor comp = new Compressor(ActuatorMap.pcmPort);
        comp.start();
    }

    public void handleSubsystems(SuperstructureCommand command) {
        arm.handle(command);
        intake.handle(command);
        led.handle(command);
        wrist.handle(command);
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
