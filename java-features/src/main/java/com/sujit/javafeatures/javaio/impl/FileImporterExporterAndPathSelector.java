package com.sujit.javafeatures.javaio.impl;

import com.sujit.javafeatures.javaio.FileDataManager;
import com.sujit.javafeatures.javaio.FileExportor;
import com.sujit.javafeatures.javaio.FileImporter;

import java.io.File;

public class FileImporterExporterAndPathSelector extends FileDataManager {

    @Override
    public FileImporter getFileImporter() {
        return new IOFileImporter();
    }

    @Override
    public FileExportor getFileExporter() {
        return new IOFileExporter();

    }

    public void prepareFiles(){
        File inputFile = new File("." + File.separator + "Items.txt");
        String outputFilePath = "." + File.separator + "ItemOutput";
        try {
            new FileImporterExporterAndPathSelector().splitInputFileAndWriteBasedOnName(inputFile, outputFilePath);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("File has splited and Stored on "+ outputFilePath + "Directory");
    }

    public static void main(String[] args) {
        FileImporterExporterAndPathSelector fileImporterExporterAndPathSelector = new FileImporterExporterAndPathSelector();
        fileImporterExporterAndPathSelector.prepareFiles();
    }

}
