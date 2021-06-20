package cn.xdevops.designpatterns.command;


public class TV {

    private String name;
    private boolean isOn;

    public TV(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println("TV is on");
        isOn = true;
    }

    public void off() {
        System.out.println("TV is off");
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }
}
