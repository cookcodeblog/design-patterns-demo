package cn.xdevops.designpatterns.command;

public class Stereo {

    private String name;
    private boolean isOn;
    private String playMode;
    private int volume;

    public Stereo(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println("Stereo is on");
        isOn = true;
    }

    public void setCD() {
        System.out.println("Stereo set playing CD");
        playMode = "CD";
    }

    public void setVolume(int volume) {
        System.out.println("Stereo set volume as " + volume);
        this.volume = volume;
    }

    public void off() {
        System.out.println("Stereo is off");
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getPlayMode() {
        return playMode;
    }

    public String getName() {
        return name;
    }
}
