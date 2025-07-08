package com.car_rental_system.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private final String dbName = "jdbc:mysql://localhost:3306/cardb";
    private final String dbUserName = "root";
    private final String dbPassword ="Karan@144007#";

    // return mysql connection
    public Connection getConnection() throws SQLException,ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(dbName, dbUserName, dbPassword);
    }
}
