package com.eikholm.jpamini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class JpaminiApplication
{
    private static final String DB_URL = "jdbc:mysql://3.237.17.120:3306";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static Connection conn = null;
    public static void main(String[] args)
    {
        System.out.println("Before Application");
        connectToDB();
        SpringApplication.run(JpaminiApplication.class, args);
    }
    
    private static void connectToDB()
    {
        Statement statement = null;
        try
        {
            System.out.println("Connecting to database..."); //STEP 1: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);// automatically
            statement = conn.createStatement();
            String sql = "SHOW databases;";
            ResultSet resultSet = statement.executeQuery(sql);
            
            if (resultSet.next()) //STEP 4: Extract data from result set
            {
                String brugernavn = resultSet.getString("Database");
                System.out.println("scheme: " + brugernavn );
            }
            else
            {
                System.out.println("no scheme found");
            }
            
            resultSet.close(); //STEP 5: Clean-up environment
            statement.close();
            conn.close();
        }
        catch(SQLException se)
        {
            //Handle errors for JDBC
            System.out.println("Error connecting to MySQL Server");
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println("Goodbye!");
    }
}