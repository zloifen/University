package com.epam.elmira_aldenova.java.lesson7.task7.dal;

import com.epam.elmira_aldenova.java.lesson7.task7.dal.contracts.IConnection;

public class ConnectionFactory {
    public enum DBType {
        MySql
    }

    public static IConnection getConnection(DBType dbType) {
        switch (dbType) {
            case MySql:
                return new MySqlServerConnection();
            default:
                return null;
        }
    }
}
