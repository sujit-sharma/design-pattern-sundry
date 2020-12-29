package com.sujit.javafeatures.javaio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    Item item = new Item();

    @Test
    public void testSettingFieldWillReturnSameField(){
        item.setName("Item1");
        item.setQuantity("two half");
        item.setPrice(250.0);
        assertEquals("Item1,two half,250.0\n", item.convertToCSV());

    }

    @Test
    public void testCSVHeaderFormat(){
        assertEquals("Name,Quantity,Price\n", Item.getCSVHeader());
    }

}