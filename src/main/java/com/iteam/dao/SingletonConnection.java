package com.iteam.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
    private static Connection connection = null;

    static {
        try {
        	System.out.print("connected");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iteam", "root", "");
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
