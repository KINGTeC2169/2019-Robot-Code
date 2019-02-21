package frc.robot.util;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

class ShuffleboardManager {

    private final SBEntry p;
    private final SBEntry i;
    private final SBEntry d;
    private final SBEntry f;
    private final SBEntry maxVel;
    private final SBEntry maxAccel;
    private final SBEntry setpoint;
    private final SBEntry error;
    private final SBEntry velocity;
    private final SBEntry position;
    private final ShuffleboardTab armConfig;

    ShuffleboardManager() {
        armConfig = Shuffleboard.getTab("ArmConfig");
        p = new SBEntry(armConfig, "P");
        i = new SBEntry(armConfig, "I");
        d = new SBEntry(armConfig, "D");
        f = new SBEntry(armConfig, "F");
        maxVel = new SBEntry(armConfig, "Max Velocity");
        maxAccel = new SBEntry(armConfig, "Max Accel");
        setpoint = new SBEntry(armConfig, "Setpoint");
        error = new SBEntry(armConfig, "Error");
        velocity = new SBEntry(armConfig, "Velocity");
        position = new SBEntry(armConfig, "Position");
    }

    void updateError(double val){
        error.setValue(val);

    }

}
