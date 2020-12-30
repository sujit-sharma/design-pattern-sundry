package com.sujit.javafeatures.javaio.impl;

import com.sujit.javafeatures.javaio.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        assertNotEquals(item, Helper.extractItemAttributeBySplitingLineData(line));
        assertEquals(item.convertToCSV(), Helper.extractItemAttributeBySplitingLineData(line).convertToCSV());

    }

    @Test
    public void testWithParameterContainingLessThen3Words_ShouldThrowException(){
        String line1 = "momo 50.0";
        String line2 = "momo            ";
        String line3 = "";

        Assertions.assertThrows(IncorrectInformationInParamsException.class,() ->
                Helper.extractItemAttributeBySplitingLineData(line1));

        Assertions.assertThrows(IncorrectInformationInParamsException.class,() ->
                Helper.extractItemAttributeBySplitingLineData(line2));

        Assertions.assertThrows(IncorrectInformationInParamsException.class,() ->
                Helper.extractItemAttributeBySplitingLineData(line3));
    }
    @Test
    public void givenTwoWordForQuantity_shouldParseSuccefully(){
        String line  = "chaumean two plate 375.25";
        assertEquals(new Item("chaumean", "two plate",375.25).convertToCSV(),
                Helper.extractItemAttributeBySplitingLineData(line).convertToCSV());

    }

    @Test
    public void testWithParameterContainingMoreThanFourWords() {
        String line1 = "Chicken Chaumean three plate 485.75";
        String line2 = "Buff Fry Rice two half 562.0";

        Assertions.assertThrows(IncorrectInformationInParamsException.class,() ->
                Helper.extractItemAttributeBySplitingLineData(line1));

        Assertions.assertThrows(IncorrectInformationInParamsException.class,() ->
                Helper.extractItemAttributeBySplitingLineData(line2));
    }


}