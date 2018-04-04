package com.epam.elmira_aldenova.java.lesson3.task1.entitites;

public class Course {
    private String name;
    private Integer duration;

    public Course(String name, Integer duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }
}
