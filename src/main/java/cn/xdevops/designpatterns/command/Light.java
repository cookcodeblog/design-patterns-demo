package cn.xdevops.designpatterns.command;

public class Light {
    private boolean isOn = false;
    private String name = "";

    public Light(String name) {
        this.name = name;
    }

    public Light() {
    }

    public void on() {
        isOn = true;
        System.out.println("Light " + name + " is on");
    }

    public boolean isOn() {
        return isOn;
    }

    public void off() {
        isOn = false;
        System.out.println("Light " + name + " is off");
    }

    public String getName() {
        return name;
    }
}
