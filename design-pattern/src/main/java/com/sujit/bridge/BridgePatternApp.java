package com.sujit.bridge;

public class BridgePatternApp {
    public static void main(String[] args) {
        RemoteControl tvRemote = new RemoteControl(new Television());
        tvRemote.togglePower();
        tvRemote.setVolume(15);
        tvRemote.powerOff();

        AdvancedRemoteControl radioRemote = new AdvancedRemoteControl(new Radio());
        radioRemote.togglePower();
        radioRemote.setVolume(8);
        radioRemote.mute();
        radioRemote.powerOff();
    }
}
