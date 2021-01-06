package com.sujit.factory;

public class BikeFactory {
    private Bike bike = null;

    public Bike createBike(String bikeType) {

        if(bikeType.equalsIgnoreCase("Pulsar")) {
            bike = new PulsarBike();
        }
        else if(bikeType.equalsIgnoreCase("Apache")){
            bike = new ApacheBike();
        }
        return bike;
    }
}
