package frc.robot.operationCommands;

import frc.robot.util.Constants;

public class OffsetCommand {
    private static int armOffset = Constants.startingArmOffset;
    private static int wristOffset = Constants.startingWristOffset;

    public OffsetCommand(boolean armDecrease, boolean armIncrease, boolean wristDecrease, boolean wristIncrease) {
        // Periodically update the offsets based on the buttons
        if(armDecrease) {
            armOffset--;
        }
        if(armIncrease) {
            armOffset++;
        }
        if(wristDecrease) {
            wristOffset--;
        }
        if(wristIncrease) {
            wristOffset++;
        }
    }

    public int getArmOffset() {
        return armOffset;
    }

    public int getWristOffset() {
        return wristOffset;
    }

    public void setArmOffset(int offset) { armOffset = offset; }

    public void setWristOffset(int offset) { wristOffset = offset; }
}
