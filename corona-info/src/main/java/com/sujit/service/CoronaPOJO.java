package com.sujit.service;

import java.sql.Date;

public class CoronaPOJO {

    private Integer countryID;
    private Integer positive;
    private Integer negative;
    private Float rate;
    private Date date;

    private static final String CSV_LINEBREAK = "\n";
    private static final String CSV_SEPARATOR = ",";

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public int getPositive() {
        return positive;
    }

    public void setPositive(int positive) {
        this.positive = positive;
    }

    public int getNegative() {
        return negative;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString(){
        return countryID + CSV_SEPARATOR + positive + CSV_SEPARATOR + negative + CSV_SEPARATOR + rate + CSV_SEPARATOR + date;
    }
}
