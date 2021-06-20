package cn.xdevops.designpatterns.command;

import java.util.stream.IntStream;

public class RemoteControl {

    public static final int SLOT_NUM = 7;
    private Command[] onCommands;
    private Command[] offCommands;
    Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[SLOT_NUM];
        offCommands = new Command[SLOT_NUM];

        // reset all commands as NoCommand (Dummy Command)
        Command noCommand = new NoCommand();
        for(int i = 0; i < SLOT_NUM; i ++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = new NoCommand();
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPressed() {
        // only one undo button for all slots
        undoCommand.undo();
    }
}
