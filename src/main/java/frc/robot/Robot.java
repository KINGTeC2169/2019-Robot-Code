/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.operationCommands.CommandMachine;
import frc.robot.subsystems.Superstructure;


public class Robot extends TimedRobot {

    private Superstructure superstructure;
    private CommandMachine commandMachine;

    @Override
    public void robotInit() {
        superstructure = new Superstructure();
        superstructure.robotInit();
//        driveTrain = new DriveTrain();
        commandMachine = new CommandMachine();
    }

    @Override
    public void autonomousInit() {
        superstructure.zeroAllSensors();
    }

    @Override
    public void autonomousPeriodic() {
        superstructure.handleSubsystems(commandMachine.generateSuperstructureCommand());
    }

    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() {
        superstructure.handleSubsystems(commandMachine.generateSuperstructureCommand());
    }

    @Override
    public void disabledInit() {
        superstructure.stop();

    }

    @Override
    public void testInit() {
    }

    @Override
    public void testPeriodic() {
    }

}
