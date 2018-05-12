package com.epam.elmira_aldenova.java.lesson2.task4.exceptions;

public class InvalidCaloriesException extends Exception {
    public InvalidCaloriesException() {
        super();
    }

    public InvalidCaloriesException(String message) {
        super(message);
    }
}
