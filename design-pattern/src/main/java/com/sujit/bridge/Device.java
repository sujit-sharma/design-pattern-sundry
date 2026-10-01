package com.sujit.bridge;

/** Implementation side of the bridge: a device that can be controlled. */
public interface Device {
    void powerOn();
    void powerOff();
    void setVolume(int volume);
    String name();
}
