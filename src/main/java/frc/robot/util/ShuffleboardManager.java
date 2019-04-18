package frc.robot.util;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

class ShuffleboardManager {

    private final SBEntry error;

    ShuffleboardManager() {
        ShuffleboardTab armConfig = Shuffleboard.getTab("ArmConfig");
        SBEntry p = new SBEntry(armConfig, "P");
        SBEntry i = new SBEntry(armConfig, "I");
        SBEntry d = new SBEntry(armConfig, "D");
        SBEntry f = new SBEntry(armConfig, "F");
        SBEntry maxVel = new SBEntry(armConfig, "Max Velocity");
        SBEntry maxAccel = new SBEntry(armConfig, "Max Accel");
        SBEntry setpoint = new SBEntry(armConfig, "Setpoint");
        error = new SBEntry(armConfig, "Error");
        SBEntry velocity = new SBEntry(armConfig, "Velocity");
        SBEntry position = new SBEntry(armConfig, "Position");
    }

    void updateError(double val){
        error.setValue(val);

    }

}
