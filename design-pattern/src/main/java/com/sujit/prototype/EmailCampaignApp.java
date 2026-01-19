package com.sujit.prototype;

import java.util.logging.Logger;

public class EmailCampaignApp {
    public static void main(String[] args) {
        EmailTemplate welcomeTemplate = new EmailTemplate(
                "Welcome!", "Hello, {name}. Thanks for joining {company}.");
        welcomeTemplate.setPlaceholder("name", "there");
        welcomeTemplate.setPlaceholder("company", "our community");

        EmailTemplate newMemberEmail = welcomeTemplate.copy();
        newMemberEmail.setPlaceholder("name", "Asha");
        newMemberEmail.setPlaceholder("company", "Acme");

        Logger.getGlobal().info("Original template:\n" + welcomeTemplate);
        Logger.getGlobal().info("Customized copy:\n" + newMemberEmail);
    }
}
