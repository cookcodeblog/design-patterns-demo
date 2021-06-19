package cn.xdevops.designpatterns.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Simple Remote Control Test - Only one button and one slot")
class SimpleRemoteControlTest {

    @Test
    @DisplayName("Light should be on when button was pressed")
    void pressOnLight() {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        Light light = new Light();
        remoteControl.setCommand(new LightOnCommand(light));
        remoteControl.buttonWasPressed();
        assertThat(light.isOn()).isTrue();
    }

    @Test
    @DisplayName("Garage door should be open when button was pressed")
    void pressOnGarageDoor() {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        GarageDoor garageDoor = new GarageDoor();
        remoteControl.setCommand(new GarageDoorOpenCommand(garageDoor));
        remoteControl.buttonWasPressed();
        assertThat(garageDoor.isDoorOpen()).isTrue();
    }
}