package com.sujit.database;

import java.sql.*;

public class DatabaseConnection {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void main(String[] args) {
        {
            try
            {
                Class.forName("org.h2.Driver");
                Connection con = DriverManager.getConnection("jdbc:h2:~/test", "test", "" );
                Statement stmt = con.createStatement();
                //stmt.executeUpdate( "DROP TABLE table1" );

                System.out.println("Generate output ");
                while( rs.next() )
                {
                    String name = rs.getString("user");
                    System.out.println( name );
                }
                stmt.close();
                con.close();
            }
            catch( Exception e )
            {
                System.out.println( e.getMessage() );
            }
        }
    }



}
