package com.sujit.factory;

import java.util.logging.Logger;

public abstract class Bike {

    public abstract void engineInfo();
    public abstract void fuelConsumption();

    public void attachLookingGlass() {
        Logger.getGlobal().info("Looking Glass Attached to Bike");
    }
    public void attachNumberPlate() {
        Logger.getGlobal().info("Number Plate added");
    }
    public void addStands() {
        Logger.getGlobal().info("Both single and double Stands added");
    }


}
