package com.sujit.service;

import com.sujit.service.fileoperation.FileExporter;
import com.sujit.service.fileoperation.FileImporter;
import com.sujit.service.fileoperation.impl.CoronaFileExporter;
import com.sujit.service.fileoperation.impl.CoronaFileImporter;

import java.io.File;
import java.util.List;

public class InfoTransferMediator {

    private FileImporter fileImporter;
    private FileExporter fileExporter;

    public InfoTransferMediator(){
        fileImporter = new CoronaFileImporter();
        fileExporter = new CoronaFileExporter();
    }

    public InfoTransferMediator(FileImporter fileImporter, FileExporter fileExporter) {
        this.fileImporter = fileImporter;
        this.fileExporter = fileExporter;
    }

    public void exportToFile(List<CoronaPOJO> list, File fileName){
        fileExporter.writeCoronaInfo(list, fileName);
    }
    public List<CoronaPOJO> importFromFile(File fileName) {
        return  fileImporter.readFile(fileName);
    }
}
