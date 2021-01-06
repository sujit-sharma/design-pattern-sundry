package com.sujit.template;

import java.util.logging.Logger;

public class BlackTea extends TeaMaker {
    @Override
    protected void addTeaGrains() {
        Logger.getGlobal().info("10 gram tea grains added");
    }

    @Override
    protected void addFlavour() {
        Logger.getGlobal().info("Lemon Added ");

    }
}
