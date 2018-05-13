package com.epam.elmira_aldenova.java.lesson10.task10;

import com.epam.elmira_aldenova.java.lesson10.task10.dal.ConnectionFactory;
import com.epam.elmira_aldenova.java.lesson10.task10.dal.contracts.IConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.epam.elmira_aldenova.java.lesson10.task10.entities.Employee;
import com.mysql.jdbc.Statement;

/**
 * @author Альденова Эльмира
 * Домашнее задание 7
 */

public class JDBCConnection {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        JDBCConnection main = new JDBCConnection();
        main.start();
    }

    private void start() {
        IConnection connection = ConnectionFactory.getConnection(ConnectionFactory.DBType.MySql);
        if (connection != null) {
            connection.process(url, user, password);
            try {
                ArrayList<Employee> employees = new ArrayList<>();
                Statement statement = (Statement) connection.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT empno, ename, job from emp");
                int maxPK = 0;
                while (resultSet.next()) {
                    Integer id = Integer.parseInt(resultSet.getString("empno"));
                    String name = resultSet.getString("ename");
                    String job = resultSet.getString("job");
                    employees.add(new Employee(id, name, job));
                    System.out.println("Id: " + id + " Name: " + name + " Job: " + job);
                    if (id > maxPK) {
                        maxPK = id;
                    }
                }

                for (Employee e : employees) {
                    for (int i = 0; i < 10; i++) {
                        statement.executeUpdate("INSERT INTO emp " +
                                "VALUES (" + ++maxPK + ", '" + e.getName() + "', '" + e.getJob() + "')");
                    }
                }

                resultSet = statement.executeQuery("SELECT empno, ename, job from emp");
                while (resultSet.next()) {
                    Integer id = Integer.parseInt(resultSet.getString("empno"));
                    String name = resultSet.getString("ename");
                    String job = resultSet.getString("job");
                    employees.add(new Employee(id, name, job));
                    System.out.println("Id: " + id + " Name: " + name + " Job: " + job);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection.close();
            }
        }
    }
}
