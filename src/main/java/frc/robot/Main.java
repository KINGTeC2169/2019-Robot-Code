/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.networking.VisionServer;

import java.io.IOException;

public final class Main {

    public static double visionData = 0;

    private Main() {
    }

    public static void main(String... args){
        Thread vThread= new Thread(VisionServer::spawnVisionThread);
        vThread.start();
        RobotBase.startRobot(Robot::new);
    }
}
