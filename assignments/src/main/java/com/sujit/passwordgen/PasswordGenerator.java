package com.sujit.passwordgen;

import java.util.Random;

public class PasswordGenerator {


    public String nextPassword() {

        StringBuilder builder = new StringBuilder();

        String[] specialPasswordCharacters = new String[]{"-", "#", "%", "$"};

        Random oneDigitRandom = new Random(0);
        Random capitalLettersRandom = new Random(0);
        Random specialCharacters = new Random(0);
        Random selector = new Random(0);

        int digitLimit = 3, alphabetLimit = 2, charsLimit = 2;

        while (builder.length() < 7) {
            int select = selector.nextInt(3);

            if (select == 0 && alphabetLimit > 0) {
                int i = capitalLettersRandom.nextInt(25) + 65;
                char c = (char) i;
                builder.append(c);
                alphabetLimit--;
            } else if (select == 1 && digitLimit > 0) {
                builder.append(oneDigitRandom.nextInt(10));
                digitLimit--;
            } else if (select == 2 && charsLimit > 0) {
                builder.append(specialPasswordCharacters[specialCharacters.nextInt(4)]);
                charsLimit--;
            }
        }

        builder.append(oneDigitRandom.nextInt(10));

        return builder.toString();
    }
}
