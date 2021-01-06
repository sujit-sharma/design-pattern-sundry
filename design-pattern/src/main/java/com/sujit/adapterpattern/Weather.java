package com.sujit.adapterpattern;

public class Weather {

    public Float calcHumidity(Float tempInCelsius) {
        Float humidity;
        if (tempInCelsius == 0)
            return 9.6F;
        humidity = (1F/tempInCelsius) * 100;
        return humidity;
    }
}
