/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.Controls;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Superstructure;


public class Robot extends TimedRobot {

    Superstructure superstructure;
    DriveTrain driveTrain;
    Controls controls;

    @Override
    public void robotInit() {
        superstructure = new Superstructure();
        superstructure.robotInit();
        driveTrain = new DriveTrain(controls);
        controls = new Controls();
    }

    @Override
    public void autonomousInit() {
        superstructure.zeroAllSensors();
    }

    @Override
    public void autonomousPeriodic() {
        superstructure.subsystemLooper();
    }

    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() {
        superstructure.subsystemLooper();
        driveTrain.drive();
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
