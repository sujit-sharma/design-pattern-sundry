package com.sujit.bridge;

/** A refined abstraction that adds mute behavior without changing device classes. */
public class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
    }
}
