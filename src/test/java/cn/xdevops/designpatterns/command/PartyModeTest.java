package cn.xdevops.designpatterns.command;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Remote Control Party Mode Test")
public class PartyModeTest {
    private static RemoteControl remoteControl;
    private static Light light;
    private static Stereo stereo;
    private static TV tv;
    private static Hottub hottub;

    @BeforeAll
    static void init() {
        remoteControl = new RemoteControl();

        light = new Light("LivingRoom");
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        stereo = new Stereo("LivingRoom");
        StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);
        StereoOffWithCDCommand stereoOff = new StereoOffWithCDCommand(stereo);

        tv = new TV("LivingRoom");
        TVOnCommand tvOn = new TVOnCommand(tv);
        TVOffCommand tvOff = new TVOffCommand(tv);

        hottub = new Hottub();
        HottubOnCommand hottubOn = new HottubOnCommand(hottub);
        HottubOffCommand hottubOff = new HottubOffCommand(hottub);

        Command[] partyOn = { lightOn, stereoOn, tvOn, hottubOn };
        Command[] partyOff = {lightOff, stereoOff, tvOff, hottubOff };
        remoteControl.setCommand(0, new MacroCommand(partyOn), new MacroCommand(partyOff));
    }

    @Test
    @DisplayName("One button to turn on/off many devices")
    void turnOnOffManyDevicesOneClick() {

        remoteControl.onButtonWasPressed(0);
        assertThat(light.isOn()).isTrue();
        assertThat(stereo.isOn()).isTrue();
        assertThat(tv.isOn()).isTrue();
        assertThat(hottub.isOn()).isTrue();

        remoteControl.offButtonWasPressed(0);
        assertThat(light.isOn()).isFalse();
        assertThat(stereo.isOn()).isFalse();
        assertThat(tv.isOn()).isFalse();
        assertThat(hottub.isOn()).isFalse();

    }

}
