package com.sujit.factory;

public class BikeShopingApp {

    public static void main(String[] args) {
        BikeStore bikeStore = new BikeStore(new BikeFactory());
        Bike bike = bikeStore.orderBike("Pulsar");
        bike.fuelConsumption();
        bike.engineInfo();
    }
}
