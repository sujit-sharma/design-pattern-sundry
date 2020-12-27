package com.sujit.four_eqn_processor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Parser {

    private static final Set<String> operators= new HashSet<>(Arrays.asList("+","-","*","/","$","(",")"));

    public boolean isOperator(String value){
        if(operators.contains(value))
            return true;
        return false;
    }

    public int precedence(Character operator){
        if ( !isOperator(Character.toString(operator))){
            throw new IllegalArgumentException("The character is not a operator");
        }
        if(operator == '+'  || operator == '-')
            return 1;
        else if(operator == '*' || operator=='/' )
            return 2;
        else if(operator == '$')
            return 3;
        return 0;
    }

    public String[] parse(String rawEquation){
        char[] charEquation;
        String[] parseResult = new String[20];
        charEquation = rawEquation.toCharArray();
        int charEquationLength = charEquation.length;
        int i = 0;
        int parseResultNumber = 0;
        StringBuilder builder = new StringBuilder();
        for(char temp: charEquation){
            temp = charEquation[i];
            if (Character.isDigit(temp)){
                builder.append(temp);
                if(i+1 >= charEquationLength ){
                    parseResult[parseResultNumber] = builder.toString();
                }
                else if( !Character.isDigit(charEquation[i+1])){
                    parseResult[parseResultNumber] = builder.toString();
                    parseResultNumber++;
                    builder.delete(0,builder.length());
                }
            }
            else if(isOperator(Character.toString(temp))){
                builder.append(temp);
                parseResult[parseResultNumber] = builder.toString();
                parseResultNumber++;
                builder.delete(0,builder.length());
            }
            else if(Character.isLetter(temp)){
                builder.append(temp);
                if(i+1 >= charEquationLength ){
                    parseResult[parseResultNumber] = builder.toString();
                }
                else if( !Character.isLetter(charEquation[i+1])){
                    parseResult[parseResultNumber] = builder.toString();
                    parseResultNumber++;
                    builder.delete(0,builder.length());
                }
            }
            i++;
        }
       return parseResult;
    }
}
