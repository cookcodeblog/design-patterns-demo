package cn.xdevops.designpatterns.command;

import java.util.Arrays;

public class MacroCommand implements Command {
    private Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        Arrays.stream(commands).forEach(c -> c.execute());
    }

    @Override
    public void undo() {
        Arrays.stream(commands).forEach(c -> c.undo());
    }
}
