package cn.xdevops.designpatterns.command;



public class CeilingFan {
    private boolean isOn;
    private String name;


    public CeilingFan(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println("CeilingFan " + name + " is on");
        isOn = true;
    }

    public void off() {
        System.out.println("CeilingFan " + name + " is off");
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getName() {
        return name;
    }


}
