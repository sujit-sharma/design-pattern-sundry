package com.sujit.template;

import java.util.logging.Logger;

public abstract class TeaMaker {

    public final void makeTea() {
        boilWater();
        addSugar();
        addTeaGrains();
        addFlavour();


    }

    protected abstract void addTeaGrains();

    protected abstract void addFlavour();

    private void addSugar() {
        Logger.getGlobal().info("Sugar Added");
    }

    private void boilWater() {
        Logger.getGlobal().info("Water Boiled");
    }


}
