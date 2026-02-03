package com.sujit.objectpool;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/** A simulated reusable connection. */
public class Connection implements Reusable {
    private static final AtomicInteger NEXT_ID = new AtomicInteger(1);

    private final int id = NEXT_ID.getAndIncrement();
    private String lastQuery;

    public void execute(String query) {
        lastQuery = query;
        Logger.getGlobal().info("Connection " + id + " executing: " + query);
    }

    @Override
    public void reset() {
        lastQuery = null;
    }

    @Override
    public String toString() {
        return "Connection-" + id;
    }
}
