package com.sujit.javafeatures.javaio;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public abstract class FileDataManager {

    public abstract FileImporter getFileImporter();
    public abstract FileExportor getFileExporter();

    public void splitInputFileAndWriteBasedOnName(File inputFile, String outputPath) throws Exception {

        //Reading File
        FileImporter itemImporter = getFileImporter();
        List<Item> items = itemImporter.readFile(inputFile);

        //filter by name of item
        Map<String, List<Item>> itemNameMap = splitByName(items);

        //prepating for writing
        chooseFileNameAndReadyForWriter(itemNameMap, outputPath);


    }

    //insert into set to make unique keys for map and then split based on name using stream
    private Map<String, List<Item>> splitByName(List<Item> items) {
        Map<String, List<Item>> splitedItemMap = new LinkedHashMap<>();
        Set<String> itemNameSet = new HashSet<>();
        items.stream().forEach(itm -> {
            itemNameSet.add(itm.getName());
        });

        itemNameSet.stream().forEach(name -> {
            List<Item> itemPerName = items.stream().filter(item -> item.getName().equals(name)).collect(Collectors.toList());
            splitedItemMap.put(name, itemPerName);
        });

        return splitedItemMap;
    }

    private void chooseFileNameAndReadyForWriter(Map<String, List<Item>> mapFilteredByName, String outputFilePath) throws IOException {

        new File(outputFilePath).mkdir();
        for(Map.Entry<String, List<Item>> nameMap : mapFilteredByName.entrySet()){
            String name = nameMap.getKey();
            List<Item> itemPerName = nameMap.getValue();
            File outputFile  = new File( outputFilePath + File.separator + name + ".csv");
            //Deleting and recreating file to remove already inserted contents
            outputFile.delete();
            outputFile.createNewFile();

            FileExportor itemExporter = getFileExporter();
            itemExporter.writeInFile(itemPerName, outputFile);

        }
    }

}
