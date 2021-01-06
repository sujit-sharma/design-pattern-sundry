package com.sujit.database;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class DatabaseConnection {

    private Properties properties;

    public DatabaseConnection(Properties properties ){
        this.properties = properties;
    }

    public Connection getConnectionString() {
        Connection connection = null;

       try { connection = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.user"), properties.getProperty("db.password"));
       }
       catch (SQLException sqlException){
           closeConnection(connection);
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
            closeConnection(connection);
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
    public void setAutoCommit(Connection connection, boolean value){
        if(connection == null)
            return;
        try {
            connection.setAutoCommit(value);
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            closeConnection(connection);
        }

    }

    public void commit(Connection connection) {
        if (connection == null)
            return;
        try {
            connection.commit();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            closeConnection(connection);
        }

    }

}
