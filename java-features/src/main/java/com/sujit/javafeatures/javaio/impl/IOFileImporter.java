package com.sujit.javafeatures.javaio.impl;

import com.sujit.javafeatures.javaio.FileImporter;
import com.sujit.javafeatures.javaio.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFileImporter implements FileImporter {

    @Override
    public List<Item> readFile(File inputFile) {
        List<Item> items = new ArrayList<>();
        Item item;

        try(BufferedReader bur = new BufferedReader(new FileReader(inputFile))){
            String line =  bur.readLine();

            while (line != null && !line.trim().equals("")){
                item = extractItemAttributeBySplitingLineData(line);
                items.add(item);
                line = bur.readLine();
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }

        return items;
    }

    private Item extractItemAttributeBySplitingLineData(String line) {
        Item item = new Item();
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
