package com.sujit.adapterpattern;

public class WeatherAdapter implements WeatherCalculator {

    Weather weatherAdaptee;
    public WeatherAdapter(Weather weatherAdaptee) {
        this.weatherAdaptee = weatherAdaptee ;
    }

    @Override
    public String findHumidity(Float tempInFahrenhiet) {
        Float tempInCelsius  = convertToCelsius(tempInFahrenhiet);
        Float humidity  = weatherAdaptee.calcHumidity(tempInCelsius);
        String humidityWithUnit = addUnit(humidity);

        return humidityWithUnit;
    }

    private String addUnit(Float humidity) {
        StringBuilder builder = new StringBuilder();
        builder.append(humidity);
        builder.append("g.m-3");
        return builder.toString();
    }

    private Float convertToCelsius(Float tempInFahrenhiet) {
        Float tempInCelsius = (tempInFahrenhiet - 32) * 5/9;
        return tempInCelsius;
    }
}
