package cn.xdevops.designpatterns.command;

public class MultiSpeedCeilingFan {

    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    private String name;
    private int speed;

    public MultiSpeedCeilingFan(String name) {
        this.name = name;
    }


    public void high() {
        System.out.println("CeilingFan " + name + " running in high speed");
        speed = HIGH;
    }

    public int getSpeed() {
        return speed;
    }

    public void medium() {
        System.out.println("CeilingFan " + name + " running in medium speed");
        speed = MEDIUM;
    }

    public void low() {
        System.out.println("CeilingFan " + name + " running in low speed");
        speed = LOW;
    }

    public void off() {
        System.out.println("CeilingFan " + name + " is off");
        speed = OFF;
    }

    public void resume(int previousSpeed) {
        System.out.println("Resume to previous speed: " + previousSpeed);
        if (HIGH == previousSpeed) {
            high();
        } else if (MEDIUM == previousSpeed) {
            medium();
        } else if (LOW == previousSpeed) {
            low();
        } else if (OFF == previousSpeed) {
            off();
        }
    }


}
