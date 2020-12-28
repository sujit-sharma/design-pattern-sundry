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

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
            String line =  reader.readLine();

            while (line != null && !line.trim().equals("")){
                item = Helper.extractItemAttributeBySplitingLineData(line);
                items.add(item);
                line = reader.readLine();
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }

        return items;
    }


}
