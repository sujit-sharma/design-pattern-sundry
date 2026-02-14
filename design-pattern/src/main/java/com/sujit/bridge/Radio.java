package com.sujit.bridge;

import java.util.logging.Logger;

public class Radio implements Device {
    private static final Logger LOGGER = Logger.getGlobal();

    @Override
    public void powerOn() {
        LOGGER.info("Radio is on");
    }

    @Override
    public void powerOff() {
        LOGGER.info("Radio is off");
    }

    @Override
    public void setVolume(int volume) {
        LOGGER.info("Radio volume set to " + volume);
    }

    @Override
    public String name() {
        return "Radio";
    }
}
