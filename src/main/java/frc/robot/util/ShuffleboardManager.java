package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class ShuffleboardManager {

    SBEntry p;
    SBEntry i;
    SBEntry d;
    SBEntry f;
    SBEntry maxVel;
    SBEntry maxAccel;
    SBEntry setpoint;
    private SBEntry error;
    SBEntry velocity;
    SBEntry position;
    private ShuffleboardTab armConfig;

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
