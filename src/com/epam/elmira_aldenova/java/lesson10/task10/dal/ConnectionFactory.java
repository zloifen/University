package com.epam.elmira_aldenova.java.lesson10.task10.dal;

import com.epam.elmira_aldenova.java.lesson10.task10.dal.contracts.IConnection;

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
