package com.sujit.bridge;

import java.util.logging.Logger;

/** Abstraction side of the bridge; it delegates device work to its implementation. */
public class RemoteControl {
    private static final Logger LOGGER = Logger.getGlobal();
    protected final Device device;
    private boolean poweredOn;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void togglePower() {
        LOGGER.info("Toggling " + device.name());
        if (poweredOn) {
            device.powerOff();
        } else {
            device.powerOn();
        }
        poweredOn = !poweredOn;
    }

    public void setVolume(int volume) {
        device.setVolume(volume);
    }

    public void powerOff() {
        if (poweredOn) {
            device.powerOff();
            poweredOn = false;
        }
    }
}
