package com.sujit.facade;

/** Subsystem component for displaying video. */
public class Projector {
    public void on() {
        System.out.println("Projector on");
    }

    public void setInput(String input) {
        System.out.println("Projector input set to " + input);
    }

    public void off() {
        System.out.println("Projector off");
    }
}
