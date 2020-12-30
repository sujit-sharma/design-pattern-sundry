package com.sujit.javafeatures.javaio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Item POJO")
class ItemTest {
    Item item = new Item();

    @Test
    @DisplayName("Testing is convertToCSV ")
    public void testSettingFieldWillReturnSameField(){
        item.setName("Item1");
        item.setQuantity("two half");
        item.setPrice(250.0);
        assertEquals("Item1,two half,250.0\n", item.convertToCSV());

    }

    @Test
    @DisplayName("Testing CSV header ")
    public void testCSVHeaderFormat(){

        assertEquals("Name,Quantity,Price\n", Item.getCSVHeader());
    }

}