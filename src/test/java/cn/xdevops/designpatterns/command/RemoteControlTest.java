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
    private static MultiSpeedCeilingFan bedRoomCeilingFan;


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
        bedRoomCeilingFan = new MultiSpeedCeilingFan("BedRoom");
        remoteControl.setCommand(4, new MultiSpeedCeilingFanLowCommand(bedRoomCeilingFan), new MultiSpeedCeilingFanOffCommand(bedRoomCeilingFan));
        remoteControl.setCommand(5, new MultiSpeedCeilingFanMediumCommand(bedRoomCeilingFan), new MultiSpeedCeilingFanOffCommand(bedRoomCeilingFan));
        remoteControl.setCommand(6, new MultiSpeedCeilingFanHighCommand(bedRoomCeilingFan), new MultiSpeedCeilingFanOffCommand(bedRoomCeilingFan));
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

    @Test
    @DisplayName("Turn on and Undo living room light")
    void turnOnAndUndoLivingRoomLight() {

        assertThat(livingRoomLight.getName()).isEqualTo("LivingRoom");

        remoteControl.onButtonWasPressed(0);
        assertThat(livingRoomLight.isOn()).isTrue();

        remoteControl.undoButtonWasPressed();
        assertThat(livingRoomLight.isOn()).isFalse();

    }

    @Test
    @DisplayName("Turn off and Undo living room light")
    void turnOffAndUndoLivingRoomLight() {

        assertThat(livingRoomLight.getName()).isEqualTo("LivingRoom");

        remoteControl.offButtonWasPressed(0);
        assertThat(livingRoomLight.isOn()).isFalse();

        remoteControl.undoButtonWasPressed();
        assertThat(livingRoomLight.isOn()).isTrue();
    }

    @Test
    @DisplayName("Turn on and Undo living room ceiling fan")
    void turnOnAndUndoLivingRoomCeilingFan() {
        assertThat(livingRoomCeilingFan.getName()).isEqualTo("LivingRoom");

        remoteControl.onButtonWasPressed(2);
        assertThat(livingRoomCeilingFan.isOn()).isTrue();

        remoteControl.undoButtonWasPressed();
        assertThat(livingRoomCeilingFan.isOn()).isFalse();
    }

    @Test
    @DisplayName("Turn off and undo living room ceiling fan")
    void turnOffAndUndoLivingRoomCeilingFan() {
        assertThat(livingRoomCeilingFan.getName()).isEqualTo("LivingRoom");

        remoteControl.offButtonWasPressed(2);
        assertThat(livingRoomCeilingFan.isOn()).isFalse();

        remoteControl.undoButtonWasPressed();
        assertThat(livingRoomCeilingFan.isOn()).isTrue();
    }

    @Test
    @DisplayName("Turn on and Undo living room stereo")
    void turnOnAndUndoLivingStereo() {
        assertThat(livingRoomStereo.getName()).isEqualTo("LivingRoom");

        remoteControl.onButtonWasPressed(3);
        assertThat(livingRoomStereo)
                .matches(s -> "CD".equals(s.getPlayMode()), "Play Mode")
                .matches(s -> s.isOn(), "isOn");

        remoteControl.undoButtonWasPressed();
        assertThat(livingRoomStereo.isOn()).isFalse();
    }

    @Test
    @DisplayName("Turn off and Undo living room stereo")
    void turnOffAndUndoLivingStereo() {
        assertThat(livingRoomStereo.getName()).isEqualTo("LivingRoom");

        remoteControl.offButtonWasPressed(3);
        assertThat(livingRoomStereo.isOn()).isFalse();

        remoteControl.undoButtonWasPressed();
        assertThat(livingRoomStereo)
                .matches(s -> "CD".equals(s.getPlayMode()), "Play Mode")
                .matches(s -> s.isOn(), "isOn");
    }

    @Test
    @DisplayName("Turn low and Off and Undo and Medium and Undo bed room multi-speed ceiling fan")
    void turnLowAndOffAndUndoAndMediumAndUndoBedRoomCeilingFan() {
        remoteControl.onButtonWasPressed(4);
        assertThat(bedRoomCeilingFan.getSpeed()).isEqualTo(MultiSpeedCeilingFan.LOW);

        remoteControl.offButtonWasPressed(4);
        assertThat(bedRoomCeilingFan.getSpeed()).isEqualTo(MultiSpeedCeilingFan.OFF);

        remoteControl.undoButtonWasPressed();
        assertThat(bedRoomCeilingFan.getSpeed()).isEqualTo(MultiSpeedCeilingFan.LOW);

        remoteControl.onButtonWasPressed(5);
        assertThat(bedRoomCeilingFan.getSpeed()).isEqualTo(MultiSpeedCeilingFan.MEDIUM);

        remoteControl.undoButtonWasPressed();
        assertThat(bedRoomCeilingFan.getSpeed()).isEqualTo(MultiSpeedCeilingFan.LOW);

    }

}