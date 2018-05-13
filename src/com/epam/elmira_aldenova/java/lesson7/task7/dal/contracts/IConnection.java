package com.epam.elmira_aldenova.java.lesson7.task7.dal.contracts;

import com.mysql.jdbc.Connection;

public interface IConnection {
    void process(String url, String user, String password);

    void close();

    Connection getConnection();
}
