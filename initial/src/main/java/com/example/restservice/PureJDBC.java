package com.example.restservice;

import java.sql.*;

public class PureJDBC {
    private static final String DB_URL = "jdbc:mysql://localhost/backend";
    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "offers4u";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
//            //STEP 1: Register JDBC driver, old way, not necessary
//            Class.forName("com.mysql.jdbc.Driver");
            //STEP 2: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + name);
            }
            rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch ( Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
            // }
            // end try
            System.out.println("Goodbye!");
        }//end main
    }//end JDBCExample
}
