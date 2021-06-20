package cn.xdevops.designpatterns.command;

public class MultiSpeedCeilingFanMediumCommand implements Command {

    private MultiSpeedCeilingFan ceilingFan;
    private int previousSpeed;

    public MultiSpeedCeilingFanMediumCommand(MultiSpeedCeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.medium();
    }

    @Override
    public void undo() {
        ceilingFan.resume(previousSpeed);
    }
}
