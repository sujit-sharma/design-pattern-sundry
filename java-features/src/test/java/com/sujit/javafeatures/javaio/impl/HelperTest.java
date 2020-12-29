package com.sujit.javafeatures.javaio.impl;

import com.sujit.javafeatures.javaio.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {
    Item item = new Item();

    @Test
    public void givenAlineWithEachFieldSepratedBySpaceShouldMakeItemObjectCorrectly(){
        String line  = "burger full 370.0";
        StringTokenizer token  = new StringTokenizer(line);
        item.setName(token.nextToken());
        item.setQuantity(token.nextToken());
        item.setPrice(Double.parseDouble(token.nextToken()));

        assertThrows(null,(Executable) Helper.extractItemAttributeBySplitingLineData(""));
        assertNotEquals(item, Helper.extractItemAttributeBySplitingLineData(line));
        assertEquals(item.convertToCSV(), Helper.extractItemAttributeBySplitingLineData(line).convertToCSV());

    }

    @Test
    public void givenEmptyLineOrLineLessThan3WordShouldThrowException(){

    }

}