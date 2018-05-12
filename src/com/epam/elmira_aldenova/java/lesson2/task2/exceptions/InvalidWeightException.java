package com.epam.elmira_aldenova.java.lesson2.task2.exceptions;

public class InvalidWeightException extends Exception {
    public InvalidWeightException() {
        super();
    }

    public InvalidWeightException(String message) {
        super(message);
    }
}
