package cn.xdevops.designpatterns.command;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Remote Control Test")
class RemoteControlTest {

    private static RemoteControl remoteControl;
    private static Light livingRoomLight;
    private static Light kitchenLight;
    private static CeilingFan livingRoomCeilingFan;
    private static Stereo livingRoomStereo;

    @BeforeAll
    static void init() {
        remoteControl = new RemoteControl();

        livingRoomLight = new Light("LivingRoom");
        remoteControl.setCommand(0, new LightOnCommand(livingRoomLight), new LightOffCommand(livingRoomLight));

        kitchenLight = new Light("Kitchen");
        remoteControl.setCommand(1, new LightOnCommand(kitchenLight), new LightOffCommand(kitchenLight));

        livingRoomCeilingFan = new CeilingFan("LivingRoom");
        remoteControl.setCommand(2, new CeilingFanOnCommand(livingRoomCeilingFan), new CeilingFanOffCommand(livingRoomCeilingFan));

        livingRoomStereo = new Stereo("LivingRoom");
        remoteControl.setCommand(3, new StereoOnWithCDCommand(livingRoomStereo), new StereoOffWithCDCommand(livingRoomStereo));

        // TODO
        // other slots are set NoCommand
        // extend them later
        remoteControl.setCommand(4, new NoCommand(), new NoCommand());
        remoteControl.setCommand(5, new NoCommand(), new NoCommand());
        remoteControl.setCommand(6, new NoCommand(), new NoCommand());

    }

    @Test
    @DisplayName("Turn on/off living room light")
    void turnOnAndOffLivingRoomLight() {

        assertThat(livingRoomLight.getName()).isEqualTo("LivingRoom");

        // 1st round
        remoteControl.onButtonWasPressed(0);
        assertThat(livingRoomLight.isOn()).isTrue();

        remoteControl.offButtonWasPressed(0);
        assertThat(livingRoomLight.isOn()).isFalse();

        // 2nd round
        remoteControl.onButtonWasPressed(0);
        assertThat(livingRoomLight.isOn()).isTrue();

        remoteControl.offButtonWasPressed(0);
        assertThat(livingRoomLight.isOn()).isFalse();

    }

    @Test
    @DisplayName("Turn on/off kitchen light")
    void turnOnAndOffKitchenLight() {
        assertThat(kitchenLight.getName()).isEqualTo("Kitchen");

        // 1st round
        remoteControl.onButtonWasPressed(1);
        assertThat(kitchenLight.isOn()).isTrue();

        remoteControl.offButtonWasPressed(1);
        assertThat(kitchenLight.isOn()).isFalse();

        // 2nd round
        remoteControl.onButtonWasPressed(1);
        assertThat(kitchenLight.isOn()).isTrue();

        remoteControl.offButtonWasPressed(1);
        assertThat(kitchenLight.isOn()).isFalse();
    }

    @Test
    @DisplayName("Turn on/off living room ceiling fan")
    void turnOnAndOffLivingRoomCeilingFan() {
        assertThat(livingRoomCeilingFan.getName()).isEqualTo("LivingRoom");

        // 1st round
        remoteControl.onButtonWasPressed(2);
        assertThat(livingRoomCeilingFan.isOn()).isTrue();

        remoteControl.offButtonWasPressed(2);
        assertThat(livingRoomCeilingFan.isOn()).isFalse();

        // 2nd round
        remoteControl.onButtonWasPressed(2);
        assertThat(livingRoomCeilingFan.isOn()).isTrue();

        remoteControl.offButtonWasPressed(2);
        assertThat(livingRoomCeilingFan.isOn()).isFalse();
    }

    @Test
    @DisplayName("Turn on/off living room stereo")
    void turnOnAndOffLivingStereo() {
        assertThat(livingRoomStereo.getName()).isEqualTo("LivingRoom");

        // 1st round
        remoteControl.onButtonWasPressed(3);
        assertThat(livingRoomStereo)
                .matches(s -> "CD".equals(s.getPlayMode()), "Play Mode")
                .matches(s -> s.isOn(), "isOn");

        remoteControl.offButtonWasPressed(3);
        assertThat(livingRoomStereo.isOn()).isFalse();

        // 2nd round
        remoteControl.onButtonWasPressed(3);
        assertThat(livingRoomStereo)
                .matches(s -> "CD".equals(s.getPlayMode()), "Play Mode")
                .matches(s -> s.isOn(), "isOn");

        remoteControl.offButtonWasPressed(3);
        assertThat(livingRoomStereo.isOn()).isFalse();
    }
}