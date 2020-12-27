package com.sujit.four_eqn_processor;

import com.sujit.four_eqn_processor.exception.IncorrectEquationException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();
        EquationProcessor equationProcessor = new EquationProcessor(parser);

        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME TO EQUATION PROCESSOR: ");
        System.out.println("Enter a Equation: ");
        String rawEquation = scanner.nextLine();

        rawEquation= rawEquation.replaceAll("\\s","");
//        Pattern inputPattern = Pattern.compile("^[a-zA-Z0-9(][a-zA-Z0-9()$/*+\\-]+[a-zA-Z0-9)]");
        if(!Pattern.matches("^[a-zA-Z0-9(][a-zA-Z0-9()$/*+\\-]+[a-zA-Z0-9)]", rawEquation)){
            throw new IncorrectEquationException("This equation may contains special symbols and other characters");

        }
        System.out.println(rawEquation);

        String[] afterParsing = parser.parse(rawEquation);
        Integer result  = equationProcessor.process(afterParsing);
        System.out.println("The Final result is  " + result);

    }
}
