package cn.xdevops.designpatterns.command;

public class GarageDoor {
    private boolean isDoorStopped = true;
    private boolean isDoorOpen = false;
    private boolean isLightOn = false;

    public void up() {
        isDoorStopped = false;
        System.out.println("Garage door is up...");
        stop();
        isDoorOpen = true;
        System.out.println("Garage door is open");
    }

    public void down() {
        isDoorStopped = false;
        System.out.println("Garage door is down...");
        stop();
        isDoorOpen = false;
        System.out.println("Garage door is closed");
    }

    public void stop() {
        System.out.println("Garage door is stopped");
        isDoorStopped = true;
    }

    public void lightOn() {
        System.out.println("Light of garage door is on");
        isLightOn = true;
    }

    public void lightOff() {
        System.out.println("Light of garage door is off");
        isLightOn = false;
    }

    public boolean isDoorStopped() {
        return isDoorStopped;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public boolean isLightOn() {
        return isLightOn;
    }
}
