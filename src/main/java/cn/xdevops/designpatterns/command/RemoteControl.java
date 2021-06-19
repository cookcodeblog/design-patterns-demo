package cn.xdevops.designpatterns.command;

import java.util.stream.IntStream;

public class RemoteControl {

    public static final int SLOT_NUM = 7;
    private Command[] onCommands;
    private Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[SLOT_NUM];
        offCommands = new Command[SLOT_NUM];

        // reset all commands as NoCommand (Dummy Command)
        Command noCommand = new NoCommand();
        for(int i = 0; i < SLOT_NUM; i ++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
    }
}
