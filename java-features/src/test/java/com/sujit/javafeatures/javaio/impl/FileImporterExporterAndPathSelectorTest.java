package com.sujit.javafeatures.javaio.impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

class FileImporterExporterAndPathSelectorTest {

    @BeforeAll
    @DisplayName("Initilize Directory and Files")
    static public void initFiles(){
        String fileTestDirectory = "." + File.separator + "src" + File.separator + "test" + File.separator + "TestItemOutput";
        new File(fileTestDirectory ).mkdir();

        File inputFile  = new File(fileTestDirectory + File.separator + "testItem.txt");

        try(BufferedWriter writer = new BufferedWriter(new FileWriter( inputFile, true))){
            writer.write("momo one plate 250.0\n");
            writer.write("vegmomo half 50.25\n");
            writer.write("fryRice three plate 550.75\n");
            writer.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testFileecporterisInitiated(){
        File inputFile = new File("." + File.separator + "src" + File.separator + "test" + File.separator + "TestItemOutput" + File.separator + "testItem.txt");
        String outputFilePath = "." + File.separator + "src" + File.separator + "test" + File.separator + "TestItemOutput";
        try {
            new FileImporterExporterAndPathSelector().splitInputFileAndWriteBasedOnName(inputFile, outputFilePath);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @AfterAll
    @DisplayName("Destroying all test created files")
    static public void destroyFilesCreatedByTest(){
        File outputDirectory = new File("." + File.separator + "src" + File.separator + "test" + File.separator + "TestItemOutput");
        String[] Files =  outputDirectory.list();
        for(String currentFilePath : Files ){
            File currentFile  = new File(outputDirectory.getPath(), currentFilePath);
            currentFile.delete();
        }
        outputDirectory.delete();
    }

}