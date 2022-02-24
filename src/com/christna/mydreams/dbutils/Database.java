/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    static String username = null;
    static String password = null;
    static String databaseName = null;

    static String url = null;
    static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            username = "root";
            password = "";
            databaseName = "mydreams_db";
            
            url = "jdbc:mysql://localhost:3306/" + databaseName;
            
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        return connection;
    }
}
