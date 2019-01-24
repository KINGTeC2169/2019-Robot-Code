package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class Controls {
    public Joystick leftjoy;
    public Joystick rightjoy;

    public Controls() {
        leftjoy = new Joystick(0);
        rightjoy = new Joystick(1);
    }
}
