package com.sujit.adapterpattern;

import java.util.logging.Logger;

public class HimiityFinderApp {

    public static void main(String[] args) {
        WeatherCalculator weatherCalculator = new WeatherAdapter(new Weather());
        String humidity  = weatherCalculator.findHumidity(98.6F);
        Logger.getGlobal().info("Humidity of This region is " + humidity);
    }
}
