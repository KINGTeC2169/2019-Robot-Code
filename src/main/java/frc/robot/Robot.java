/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.Superstructure;


public class Robot extends TimedRobot {

    private static Superstructure superStructure;

    @Override
    public void robotInit() {
        superStructure.robotInit();
    }

    @Override
    public void autonomousInit() {
        superStructure.zeroAllSensors();
    }

    @Override
    public void autonomousPeriodic() {
        superStructure.subsystemLooper();
    }

    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() {
        superStructure.subsystemLooper();
    }

    @Override
    public void disabledInit() {
        superStructure.stop();

    }

    @Override
    public void testInit() {
    }

    @Override
    public void testPeriodic() {
    }

}
