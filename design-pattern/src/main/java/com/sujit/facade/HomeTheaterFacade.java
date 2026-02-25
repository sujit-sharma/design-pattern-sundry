package com.sujit.facade;

/** Provides simple movie controls over the home theater subsystem. */
public class HomeTheaterFacade {
    private final Amplifier amplifier;
    private final Projector projector;
    private final StreamingPlayer player;

    public HomeTheaterFacade(Amplifier amplifier, Projector projector, StreamingPlayer player) {
        if (amplifier == null || projector == null || player == null) {
            throw new IllegalArgumentException("Home theater components must not be null");
        }
        this.amplifier = amplifier;
        this.projector = projector;
        this.player = player;
    }

    public void watchMovie(String movie) {
        if (movie == null || movie.isBlank()) {
            throw new IllegalArgumentException("Movie title must not be blank");
        }
        System.out.println("Starting movie...");
        projector.on();
        projector.setInput("streaming player");
        amplifier.on();
        amplifier.setVolume(5);
        player.on();
        player.play(movie);
    }

    public void endMovie() {
        System.out.println("Ending movie...");
        player.stop();
        player.off();
        projector.off();
        amplifier.off();
    }
}
