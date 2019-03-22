package frc.robot.operationCommands;

public class OffsetCommand {
    private int armOffset = 0;
    private int wristOffset = 0;

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
}
