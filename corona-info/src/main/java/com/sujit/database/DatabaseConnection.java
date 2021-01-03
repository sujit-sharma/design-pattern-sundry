package com.sujit.database;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class DatabaseConnection {

    private Properties properties;

    public DatabaseConnection(Properties properties ){
        this.properties = properties;
    }

    public Connection getConnectionString() throws SQLException {
        Connection connection = null;

       try {connection = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.user"), properties.getProperty("db.password"));

       }
       catch (SQLException sqlException){
           connection.close();
           Logger.getGlobal().severe("Error Occur While Connecting to Database......");
       }
       return connection;
    }

    public Statement getStatementString() throws SQLException{
        Statement statement = null;
        Connection connection = null;
        try {
            connection = this.getConnectionString();
            statement =  connection.createStatement();
        }

        catch (SQLException sqlException){
            statement.close();
            Logger.getGlobal().severe("Error Occur While Connecting Database......");
        }
        return statement;
    }

    public void closeConnection(Connection connection){
        if(connection == null)
            return;
        try {
            connection.close();
        }
        catch (SQLException sqlException ){
            sqlException.printStackTrace();
        }
    }

}
