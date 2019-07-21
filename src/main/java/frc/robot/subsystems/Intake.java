package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.operationCommands.SuperstructureCommand;
import frc.robot.util.ActuatorMap;
import frc.robot.util.Constants;

public class Intake extends Subsystem {

    private final TalonSRX left;
    private final TalonSRX right;

    Intake() {
        left = new TalonSRX(ActuatorMap.intakeLeft);
        right = new TalonSRX(ActuatorMap.intakeRight);
    }

    private void runIntake(double motorPower) {
        left.set(ControlMode.PercentOutput, motorPower);
        right.set(ControlMode.PercentOutput, motorPower);

    }

    //Primary handle method for the intake
    void handle(SuperstructureCommand sCommand) {
        if (Math.abs(sCommand.getIntakeOutput()) >= Constants.intakeDeadband) {
            runIntake(sCommand.getIntakeOutput());
        }
    }

    @Override
    public void zeroSensors() {

    }

    @Override
    public void stop() {

    }
}
