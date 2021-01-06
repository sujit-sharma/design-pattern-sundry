package com.sujit.template;

import java.util.logging.Logger;

public class MilkTea extends TeaMaker {
    @Override
    protected void addTeaGrains() {
        Logger.getGlobal().info("20 gram tea grains added");
    }

    @Override
    protected void addFlavour() {
        Logger.getGlobal().info("Milk Added");
    }
}
