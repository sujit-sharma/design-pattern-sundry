package com.sujit.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomArrayGeneratorTest {
    RandomArrayGenerator randomArrayGenerator;

    @BeforeEach
    public void init() {
       randomArrayGenerator = new RandomArrayGenerator();
    }


    @Test
    public void whenGenerateArrayShouldHaveValueLessThen5(){
        int[] generatedArray = randomArrayGenerator.generate();
    }

}