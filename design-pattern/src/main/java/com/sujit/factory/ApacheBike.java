package com.sujit.factory;

import java.util.logging.Logger;

public class ApacheBike extends Bike{
    @Override
    public void engineInfo() {
        Logger.getGlobal().info("ITs Engine is 750 horse power with 180 cc");

    }

    @Override
    public void fuelConsumption() {
        Logger.getGlobal().info("It Offers 45 milage per liter");

    }
}
