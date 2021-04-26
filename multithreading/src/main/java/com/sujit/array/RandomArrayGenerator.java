package com.sujit.array;

import java.util.Random;

public class RandomArrayGenerator {
    private int[] intArray;
    Random random;

    public RandomArrayGenerator(){
        random = new Random();
    }

    public RandomArrayGenerator(int arraySize){
        this();

        intArray = new int[arraySize];
    }

    public int[] generate() {
        for (int index = 0; index < intArray.length; index++) {
            intArray[index] = random.nextInt(5);
        }
        System.out.println(intArray);
        return intArray;
    }
}
