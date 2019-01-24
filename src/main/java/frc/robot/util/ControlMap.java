package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;

public class ControlMap {

    static Joystick operator;

    public static double getOperatorStickY(){
        return operator.getRawAxis(1);
    }

    public static boolean getOperatorTrigger() {
        return operator.getTrigger();
    }

}
