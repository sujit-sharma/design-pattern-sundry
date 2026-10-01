package com.sujit.prototype;

import java.util.HashMap;
import java.util.Map;

/** A reusable email template that can be copied and customized. */
public class EmailTemplate implements Prototype<EmailTemplate> {
    private String subject;
    private String body;
    private final Map<String, String> placeholders;

    public EmailTemplate(String subject, String body) {
        this.subject = subject;
        this.body = body;
        this.placeholders = new HashMap<>();
    }

    private EmailTemplate(EmailTemplate source) {
        this.subject = source.subject;
        this.body = source.body;
        this.placeholders = new HashMap<>(source.placeholders);
    }

    @Override
    public EmailTemplate copy() {
        return new EmailTemplate(this);
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setPlaceholder(String name, String value) {
        placeholders.put(name, value);
    }

    @Override
    public String toString() {
        return "Subject: " + subject + "\nBody: " + body + "\nPlaceholders: " + placeholders;
    }
}
