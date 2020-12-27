package com.sujit.two_data_structure;

import com.sujit.two_data_structure.utils.Helper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Helper helper = new Helper();
        int option;

        System.out.println("Choose from Given Options");
        System.out.println("1. For Fixed Size Stack");
        System.out.println("2. For Dynamic Stack");
        System.out.println("3. For Fixed Size Queue");
        System.out.println("4. For Dynamic Queue");

        option = new Scanner(System.in).nextInt();

        helper.classSelector(option);



    }
}
