package com.sujit.bridge;

import java.util.logging.Logger;

public class Television implements Device {
    private static final Logger LOGGER = Logger.getGlobal();

    @Override
    public void powerOn() {
        LOGGER.info("Television is on");
    }

    @Override
    public void powerOff() {
        LOGGER.info("Television is off");
    }

    @Override
    public void setVolume(int volume) {
        LOGGER.info("Television volume set to " + volume);
    }

    @Override
    public String name() {
        return "Television";
    }
}
