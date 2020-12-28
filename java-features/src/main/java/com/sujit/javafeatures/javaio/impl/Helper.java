package com.sujit.javafeatures.javaio.impl;

import com.sujit.javafeatures.javaio.Item;

public class Helper {

    static public Item extractItemAttributeBySplitingLineData(String line) {
        Item item = new Item();
        line = line.trim();
        String[] chunks = line.split("\\s+");
        item.setName(chunks[0]);
        StringBuilder quantity = new StringBuilder();
        quantity.append(chunks[1]);
        if(chunks.length>3)
            quantity.append(" " +chunks[2]);
        item.setQuantity(quantity.toString());
        String price = chunks[chunks.length-1];
        item.setPrice(Double.parseDouble(price));

        return item;
    }
}
