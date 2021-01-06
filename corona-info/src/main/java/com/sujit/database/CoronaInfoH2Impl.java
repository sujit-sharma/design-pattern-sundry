package com.sujit.database;

import com.sujit.Utils;
import com.sujit.service.CoronaPOJO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class CoronaInfoH2Impl implements CoronaInfoDAO {

    DatabaseConnection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    public CoronaInfoH2Impl(){
        this.connection = new DatabaseConnection(Utils.propertiesLoader());
    }

    public void createTable(){
        String createTableSQL = "CREATE TABLE IF NOT EXISTS COVID_INFO_2020" +
                "(info_Id INTEGER auto_increment," +
                "countryId INTEGER," +
                "positive INTEGER," +
                "negative INTEGER," +
                "rate DOUBLE," +
                "testedDate DATE ," +
                "PRIMARY KEY (info_Id))";
        try {
            connection.getConnectionString().createStatement().executeUpdate(createTableSQL);
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public void insert(CoronaPOJO coronaPOJO ) {
        String SQL = "INSERT INTO covid_info_2020 (countryID, positive, negative, rate, testedDate)" +
                "values(?,?,?,?,?)";
        try {
            preparedStatement = connection.getConnectionString().prepareStatement(SQL);
            preparedStatement.setInt(1, coronaPOJO.getCountryID());
            preparedStatement.setInt(2, coronaPOJO.getPositive());
            preparedStatement.setInt(3, coronaPOJO.getNegative());
            preparedStatement.setFloat(4, coronaPOJO.getRate());
            preparedStatement.setDate(5, coronaPOJO.getDate());

            preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
            Logger.getGlobal().severe("Error occurs while creating prepared statement");
        }
    }

    @Override
    public void insert(List<CoronaPOJO> coronaPOJOList) {
        String SQL = "INSERT INTO covid_info_2020 (countryID, positive, negative, rate, testedDate)" +
                "values(?,?,?,?,?)";
        try {
            preparedStatement = connection.getConnectionString().prepareStatement(SQL);
            for (CoronaPOJO coronaInfo: coronaPOJOList ) {
                preparedStatement.setInt(1, coronaInfo.getCountryID());
                preparedStatement.setInt(2,coronaInfo.getPositive());
                preparedStatement.setInt(3, coronaInfo.getNegative());
                preparedStatement.setFloat(3, coronaInfo.getRate());
                preparedStatement.setDate(5,coronaInfo.getDate());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        }
        catch (SQLException sqlException ){
            sqlException.printStackTrace();
        }


    }

    @Override
    public List<CoronaPOJO> getAllPaginatedCovidInfo(int limit){
        List<CoronaPOJO> result  = new ArrayList<>(10000);
        int totalRows = countRows("COVID_INFO_2020");
        for(int i = 0; i <= (int) (totalRows/limit); i++ ){
            String selectSql = "Select countryID, positive, negative, rate, testedDate from COVID_INFO_2020 " +
                    "ORDER By testedDate desc LIMIT " + limit + " OFFSET " + i*limit;
            try(ResultSet resultSet = connection.getStatementString().executeQuery(selectSql)) {
                while (resultSet.next()) {
                    CoronaPOJO info  =  new CoronaPOJO();
                    info.setCountryID(resultSet.getInt(1));
                    info.setPositive(resultSet.getInt(2));
                    info.setNegative(resultSet.getInt(3));
                    info.setRate(resultSet.getFloat(4));
                    info.setDate(resultSet.getDate(5));
                    result.add(info);
                }
            }
            catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        Logger.getGlobal().info("All data selected");
        return result;

    }

    @Override
    public int remove(int limit) {
        int affectedRows = 0;
        String removeSQL = "DELETE FROM COVID_INFO_2020 LIMIT " + limit;
        try {
            affectedRows = connection.getStatementString().executeUpdate(removeSQL);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return affectedRows;
    }

    @Override
    public void updateAll(List<CoronaPOJO> updateList) {
        int totalRows = countRows("COVID_INFO_2020");
        for(int i = 0; i < totalRows; i++ ) {
            String updateSQL = "UPDATE COVID_INFO_2020 SET countryID =" + updateList.get(i).getCountryID()
                    + ", positive=" + updateList.get(i).getPositive() + ", negative=" + updateList.get(i).getNegative()
                    + ", rate =" +updateList.get(i).getRate() + ", testedDate=" +updateList.get(i).getDate()
                    + " WHERE info_Id=" +i;
            try {
                PreparedStatement preparedStatement = connection.getConnectionString().prepareStatement(updateSQL);
            }
            catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }

    }

    private int countRows(String entity ){
        int noOfRows = 0;
        String countSQL = "SELECT COUNT(*) FROM COVID_INFO_2020";// + entity;
        try {
            ResultSet countResultSet = connection.getStatementString().executeQuery(countSQL);
            countResultSet.next();
            noOfRows = (int) countResultSet.getLong(1);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return 10000;
    }

}
