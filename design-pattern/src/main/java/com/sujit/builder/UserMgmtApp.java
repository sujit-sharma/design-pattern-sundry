package com.sujit.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserMgmtApp {
    public static void main(String[] args) {
    User manager = new User.UserBuilder("Hari")
            .age(35)
            .email("hari23@gmail.com")
            .build();
        Logger.getGlobal().info(manager.toString());

        // next user
        User clerk = new User.UserBuilder("ramesh")
                .age(27)
                .email("ramesh@gmail.com")
                .build();
        Logger.getGlobal().info(manager.toString());

        List<User> users = new ArrayList<>();
        users.add(manager);
        users.add(clerk);
        users.add(new User.UserBuilder("Sital").age(5).build());
    }

}
