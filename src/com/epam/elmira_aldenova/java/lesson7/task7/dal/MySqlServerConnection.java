package com.epam.elmira_aldenova.java.lesson7.task7.dal;

import com.epam.elmira_aldenova.java.lesson7.task7.dal.contracts.IConnection;
import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlServerConnection implements IConnection {
    private Connection connection;

    @Override
    public void process(String url, String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.connection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("MySqlServer connection established");
        } catch (Exception e) {
            System.out.println("Connection not established");
        }
    }

    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("Connection closed");
        }
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }
}
