package com.sujit.service.fileoperation.impl;

import com.sujit.service.fileoperation.FileImporter;
import com.sujit.service.CoronaPOJO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CoronaFileImporter implements FileImporter {
    @Override
    public List<CoronaPOJO> readFile(File fileName) {
        List<CoronaPOJO> listOfData  = new ArrayList<>(10000);
        CoronaPOJO data;

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line =  reader.readLine();

            while (line != null && !line.trim().equals("")){
                data = extractInfoFrom(line);
                listOfData.add(data);
                line = reader.readLine();
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
        return listOfData;
    }

    private CoronaPOJO extractInfoFrom(String line) {
        CoronaPOJO coronaPOJO = new CoronaPOJO();
        StringTokenizer tokenizer = new StringTokenizer(line,",");

        coronaPOJO.setCountryID(Integer.parseInt(tokenizer.nextToken()));
        coronaPOJO.setPositive(Integer.parseInt(tokenizer.nextToken()));
        coronaPOJO.setNegative(Integer.parseInt(tokenizer.nextToken()));
        coronaPOJO.setRate(Float.parseFloat(tokenizer.nextToken()));
        coronaPOJO.setDate(Date.valueOf(tokenizer.nextToken()));

        return coronaPOJO;
    }
}
