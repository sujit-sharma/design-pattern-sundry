package com.sujit.factory;

import java.util.logging.Logger;

public class PulsarBike extends Bike {

    @Override
    public void engineInfo() {
        Logger.getGlobal().info("ITs Engine is 700 horse power with 150 cc");

    }

    @Override
    public void fuelConsumption() {
        Logger.getGlobal().info("It Offers 42 milage per liter");

    }
}

