package com.sujit.proxy;

import java.util.logging.Logger;

/** The real object that owns and displays confidential report content. */
public class ConfidentialReport implements Report {
    private final String content;

    public ConfidentialReport(String content) {
        this.content = content;
    }

    @Override
    public void display() {
        Logger.getGlobal().info(content);
    }
}
