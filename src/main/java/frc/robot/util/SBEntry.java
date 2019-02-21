package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;

public class SBEntry {

    NetworkTableEntry entry;

    SBEntry(ShuffleboardTab tab, String name){
        SimpleWidget widget = tab.add(name, 0);
        entry = widget.getEntry();
    }

    public double getValue(){
        return entry.getDouble(0);
    }

    public void setValue(double val){
        entry.setNumber(val);
    }

}
