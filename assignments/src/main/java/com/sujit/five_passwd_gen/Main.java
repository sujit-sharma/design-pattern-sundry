package com.sujit.five_passwd_gen;

public class Main {

    public static void main(String[] args) {

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generate();
        System.out.println("The Generated Password is: " + password);
    }
}
