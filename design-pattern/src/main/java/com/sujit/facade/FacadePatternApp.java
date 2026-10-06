package com.sujit.facade;

public class FacadePatternApp {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                new Amplifier(), new Projector(), new StreamingPlayer());

        homeTheater.watchMovie("The Composite Adventure");
        homeTheater.endMovie();
    }
}
