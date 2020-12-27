package com.sujit.five_passwd_gen;

import java.util.Random;

public class PasswordGenerator {


    private int length = 8;
    private int containsNumber = 4;
    private int containsLetter  = 2;
    private int containsSymbol = 2;

   private final static Character[] numbers = {'8','1','2','7','4','0','4','5','3','9'};
   private final static Character[] letters = {'A','S','D','F','G','H','J','K','L','Q','W','E','R','T','Y','U','I','O','P','Z','X','C','V','B','N','M'};
   private final static Character[] symbols = {'_', '$', '#', '%'};

    public PasswordGenerator() {
    }

    public PasswordGenerator(int length){
        this.length = length;
    }
    public PasswordGenerator(int length, int containsNumber, int containsCharacter, int containsSymbol){
        this(length);
        this.containsNumber = containsNumber;
        this.containsLetter =containsCharacter;
        this.containsSymbol = containsSymbol;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setContainsNumber(int containsNumber) {
        this.containsNumber = containsNumber;
    }

    public void setContainsCharacter(int containsCharacter) {
        this.containsLetter = containsCharacter;
    }

    public void setContainsSymbols(int containsSymbols) {
        this.containsSymbol = containsSymbols;
    }

    public String generate(){
        Random random = new Random();
        Character[] pseudoRandom = new Character[length];

       for(int i =0; i<= containsNumber; i++){
           pseudoRandom[i] = numbers[random.nextInt(numbers.length-1)];
       }
        for(int i =4; i<= 3+ containsLetter; i++){
            pseudoRandom[i] = letters[random.nextInt(letters.length-1)];
        }
        for(int i =6; i<= 5 + containsSymbol; i++){
            pseudoRandom[i] = symbols[random.nextInt(symbols.length-1)];
        }

        return suffle(pseudoRandom);
    }

    public String suffle(Character[] password){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < 8; i++){

            int randSwap = random.nextInt(password.length);
            Character temp =password[i];
            password[i] = password[randSwap];
            password[randSwap] = temp;

        }
        for (Character character: password){
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }

}