package com.sujit.factory;

public class BikeFactory {
    private Bike bike;

    public Bike createBike(String bikeType) {

        if(bikeType.equalsIgnoreCase("Pulsar")) {
            return new PulsarBike();
        }
        else if(bikeType.equalsIgnoreCase("Apache")){
           return new ApacheBike();
        }
        return bike;
    }
}
