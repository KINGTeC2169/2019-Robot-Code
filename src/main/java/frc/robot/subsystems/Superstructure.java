package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import frc.robot.operationCommands.IntakeCommand;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;

public class Superstructure {

    // Subsystem Instances
    private Arm arm;
    private Intake intake;
    private LEDMachine led;
    private Wrist wrist;

    public Superstructure() {
        // Initialize Subsystems
        arm = new Arm();
        intake = new Intake();
        led = new LEDMachine();
        wrist = new Wrist();

    }

    public void robotInit() {
        Compressor comp = new Compressor(ActuatorMap.PCMPort);
        comp.start();
    }

    public void handleSubsystems(SuperstructureCommand command) {
        arm.handle(command);
        //TODO Actual Command Structure
        intake.handle(command.getIntakeCommand());
        led.handle();
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
