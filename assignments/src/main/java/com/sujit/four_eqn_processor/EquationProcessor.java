package com.sujit.four_eqn_processor;
import com.sujit.four_eqn_processor.datastructures.LinkedStack;
import com.sujit.four_eqn_processor.datastructures.Stack;
import com.sujit.four_eqn_processor.exception.IncorrectEquationException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EquationProcessor {
    Parser parser;
    Stack<Integer> operandStack = new LinkedStack<>();
    Stack<Character> operatorStack = new LinkedStack<>();

    public EquationProcessor(Parser parser){
        this.parser = parser;
    }

    private Integer operate(Character operator){
        if(operandStack.size()<2 ){
            throw new IncorrectEquationException("Given equation is not a valid equation");
        }
        Integer operandA = operandStack.pop();
        Integer operandB = operandStack.pop();
        Integer result = 0;

        switch (operator){
            case '-': result = operandB - operandA;
                    break;
            case '+': result = operandA + operandB;
                    break;
            case '*': result = operandA * operandB;
                    break;
            case '/': result = operandB / operandA;
                    break;
            case '$': Double res = Math.pow(operandB, operandA);
                        result = res.intValue();
                        break;

        }
        return result;
    }

    private void operatorProcessor(Character currentOperator){
        Integer result;
        if(operatorStack.isEmpty() || currentOperator == '(')
            operatorStack.push(currentOperator);
        else if(currentOperator == ')'){
            while (operatorStack.peek() != '('){
                result = operate(operatorStack.pop());
                operandStack.push(result);
            }
            operatorStack.pop();//eliminating '(' braces

        }
        else if(parser.precedence(operatorStack.peek()) < parser.precedence(currentOperator)){
            operatorStack.push(currentOperator);
        }
        else {
            if ( !operatorStack.isEmpty()){
                while (parser.precedence(operatorStack.peek()) >= parser.precedence(currentOperator) ){
                    result = operate(operatorStack.pop());
                    operandStack.push(result);
                    if(operatorStack.isEmpty())
                        break;
                }
                operatorStack.push(currentOperator);
            }
        }
    }

    public Integer process(String[] input) {
        int i = 0;
        Map<String, Integer> variables = new LinkedHashMap<>(3);
        Integer temp;
        String currentValue;
        while(input[i] != null){
            currentValue = input[i];

            if(parser.isOperator(currentValue)){
                operatorProcessor(currentValue.charAt(0));
            }
            else {
                if(currentValue.matches("[0-9]+")){
                    operandStack.push(Integer.valueOf(currentValue));
                }
                else {
                    if(variables.containsKey(currentValue)) {
                        input[i] = variables.get(currentValue).toString();
                    }
                    else {
                        System.out.println("Enter Value of variable " + currentValue);
                        temp = new Scanner(System.in).nextInt();
                        variables.put(currentValue, temp);
                        input[i] = temp.toString();
                    }
                    i--;
                }
            }
            i++;
        }
        while ( !operatorStack.isEmpty()){
           operandStack.push( operate(operatorStack.pop()));
        }
        return operandStack.pop();
    }
}
