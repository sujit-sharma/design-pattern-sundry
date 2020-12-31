package com.sujit.service.fileoperation.impl;

import com.sujit.service.fileoperation.FileExporter;
import com.sujit.service.CoronaPOJO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CoronaFileExporter implements FileExporter {

    @Override
    public void writeCoronaInfo(List<CoronaPOJO> listOfData , File fileName ) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter( fileName, true))){
            for (CoronaPOJO data : listOfData ){
                writer.write(data.toString());
                writer.newLine();
            }
            writer.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
