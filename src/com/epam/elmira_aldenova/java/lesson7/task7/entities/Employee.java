package com.epam.elmira_aldenova.java.lesson7.task7.entities;

public class Employee {
    private Integer id;
    private String name;
    private String job;

    public Employee(Integer id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getJob() {
        return job;
    }
}
