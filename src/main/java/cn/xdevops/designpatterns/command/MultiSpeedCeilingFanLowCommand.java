package cn.xdevops.designpatterns.command;

public class MultiSpeedCeilingFanLowCommand implements Command {
    private MultiSpeedCeilingFan ceilingFan;
    private int previousSpeed;

    public MultiSpeedCeilingFanLowCommand(MultiSpeedCeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.low();
    }

    @Override
    public void undo() {
        ceilingFan.resume(previousSpeed);
    }
}
