package cn.xdevops.designpatterns.command;

public class MultiSpeedCeilingFanOffCommand implements Command {

    private MultiSpeedCeilingFan ceilingFan;
    private int previousSpeed;

    public MultiSpeedCeilingFanOffCommand(MultiSpeedCeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    @Override
    public void undo() {
        ceilingFan.resume(previousSpeed);
    }
}
