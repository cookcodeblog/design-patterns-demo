package cn.xdevops.designpatterns.command;

public class MultiSpeedCeilingFanHighCommand implements Command {
    private MultiSpeedCeilingFan ceilingFan;
    private int previousSpeed;

    public MultiSpeedCeilingFanHighCommand(MultiSpeedCeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        ceilingFan.resume(previousSpeed);
    }
}
