package com.Library;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library",
                    "root",
                    "soham4519N_N@"
            );

            System.out.println("Database Connected!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}