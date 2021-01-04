package com.sujit.service.impl;

import com.sujit.service.CoronaPOJO;
import com.sujit.service.RandomDataGenetator;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;


public class CoronaInfoRandomDataGenerator implements RandomDataGenetator {


    private List<CoronaPOJO> coronaInfoList;
    private Integer numberOfColumn = 10000;

    public CoronaInfoRandomDataGenerator(Integer numberOfColumn) {
        this();
        this.numberOfColumn = numberOfColumn;

    }

    public CoronaInfoRandomDataGenerator(){
        coronaInfoList = new ArrayList<>(numberOfColumn);
    }
    @Override
    public List<CoronaPOJO> generate() {
        Random random = new Random(2);
        for (int i = 0; i < 10000; i++ ){
            CoronaPOJO coronaPOJO = new CoronaPOJO();

            coronaPOJO.setCountryID( random.nextInt(250));
            coronaPOJO.setPositive(random.nextInt(99999999));
            coronaPOJO.setNegative( random.nextInt(99999999));
            coronaPOJO.setRate(random.nextFloat() * random.nextInt(9999999));
            LocalDate someDate  = LocalDate.now().minusDays(new Random().nextInt(360) + 5);
            coronaPOJO.setDate(Date.valueOf(someDate));

            coronaInfoList.add(coronaPOJO);

        }
        Logger.getGlobal().info("Covid Data generated");

        return coronaInfoList;
    }
}
