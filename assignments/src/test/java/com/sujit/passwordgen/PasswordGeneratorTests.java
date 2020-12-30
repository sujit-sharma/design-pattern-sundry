package com.sujit.passwordgen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTests {

    PasswordGenerator passwordGenerator;

    @BeforeEach
    void setUp() {
        passwordGenerator = new PasswordGenerator();
    }

    @Test
    void whenGenerateThenShouldHaveExactlyFourOneDigitNumbers() {

        String nextPassword = passwordGenerator.nextPassword();

        String noOneDigitNumbers = nextPassword.replaceAll("[0-9]", "");

        assertEquals(4, nextPassword.length() - noOneDigitNumbers.length());

    }


    @Test
    void whenGenerateThenShouldHave8LengthPassword() {

        String nextPassword = passwordGenerator.nextPassword();

        assertEquals(8, nextPassword.length());
    }

    @Test
    void whenGenerateThenShouldHaveExactlyTwoCapitalLetters() {

        String nextPassword = passwordGenerator.nextPassword();

        String noCapitalLetters = nextPassword.replaceAll("[A-Z]", "");

        assertEquals(2, nextPassword.length() - noCapitalLetters.length());

    }

    @Test
    void whenGenerateThenShouldExactlyTwoSpecialCharacters() {

        String nextPassword = passwordGenerator.nextPassword();

        String noSpecialCharacters = nextPassword.replaceAll("[-|#|$|%]", "");

        assertEquals(2, nextPassword.length() - noSpecialCharacters.length());
    }

    @Test
    void whenGenerateThenShouldNotHaveSameTypeOfCharacterGroupedTogetherMoreThanTwoTimes() {

        String nextPassword = passwordGenerator.nextPassword();

        Pattern pattern = Pattern.compile("([0-9]+)|([A-Z]+)|([-|%|#|$]+)");

        Matcher matcher = pattern.matcher(nextPassword);

        while (matcher.find()) {
            String group = matcher.group();
            if (group.length() > 2) {
                fail("ShouldNotHaveSameTypeOfCharacterGroupedTogetherMoreThanTwoTimes");
            }
        }

    }

    @Test
    void whenGenerateThenShouldHaveLastCharacterAsDigit() {

        String nextPassword = passwordGenerator.nextPassword();

        assertTrue(Pattern.compile("[0-9]$").matcher(nextPassword).find());

    }
}
