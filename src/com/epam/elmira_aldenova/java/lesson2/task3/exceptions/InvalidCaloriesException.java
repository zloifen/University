package com.epam.elmira_aldenova.java.lesson2.task3.exceptions;

public class InvalidCaloriesException extends Exception {
    public InvalidCaloriesException() {
        super();
    }

    public InvalidCaloriesException(String message) {
        super(message);
    }
}
