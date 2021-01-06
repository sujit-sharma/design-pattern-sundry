package com.sujit.factory;

public class BikeStore {

    private BikeFactory factory;

    public BikeStore(BikeFactory factory) {
        this.factory = factory;
    }

    public Bike orderBike(String bikeType){
        Bike bike = factory.createBike(bikeType);

        bike.addStands();
        bike.attachLookingGlass();
        bike.attachNumberPlate();
        return bike;
    }

    public void aboutBike(Bike bike){
        bike.engineInfo();
        bike.fuelConsumption();
    }
}
