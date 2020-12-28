package com.sujit.javafeatures.javaio.impl;

import com.sujit.javafeatures.javaio.FileExportor;
import com.sujit.javafeatures.javaio.Item;

import java.io.*;
import java.util.List;

public class IOFileExporter implements FileExportor {
    @Override
    public void writeInFile(List<Item> items, File fileName) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter( fileName, true))){
            writer.write(Item.getCSVHeader());
            for (Item item : items ){
                writer.write(item.convertToCSV());
            }
            writer.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
