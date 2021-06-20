package cn.xdevops.designpatterns.command;

public class Hottub {

    private boolean isOn;

    public void on() {
        System.out.println("Hottub is on");
        isOn = true;
    }

    public void off() {
        System.out.println("Hottub is off");
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }
}
