/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.operationCommands.CommandMachine;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Superstructure;


class Robot extends TimedRobot {

    private Superstructure superstructure;
    private DriveTrain driveTrain;
    private CommandMachine commandMachine;
    private UsbCamera cam;

    @Override
    public void robotInit() {
        cam = CameraServer.getInstance().startAutomaticCapture();
        driveTrain = new DriveTrain();
        superstructure = new Superstructure();
        superstructure.robotInit();
        commandMachine = new CommandMachine();
    }

    @Override
    public void autonomousInit() {
        superstructure.zeroAllSensors();
    }

    @Override
    public void autonomousPeriodic() {
        teleopPeriodic();
    }

    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() {
        superstructure.handleSubsystems(commandMachine.generateSuperstructureCommand());
        driveTrain.handle(commandMachine.generateDriveCommand());
    }

    @Override
    public void disabledInit() {
        superstructure.stop();
        driveTrain.stop();
    }

    @Override
    public void testInit() {
    }

    @Override
    public void testPeriodic() {
    }

}
