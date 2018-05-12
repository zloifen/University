package com.epam.elmira_aldenova.java.lesson2.task4.entities;

import com.epam.elmira_aldenova.java.lesson2.task4.exceptions.InvalidCaloriesException;
import com.epam.elmira_aldenova.java.lesson2.task4.exceptions.InvalidWeightException;

public class Marmalade extends Confection {
    public enum MarmaladeType {
        Kumquat,
        lemon,
        Lime,
        Mandarin
    }

    private MarmaladeType marmaladeType;

    public Marmalade(double calories, double weight, MarmaladeType marmaladeType) throws InvalidCaloriesException, InvalidWeightException {
        super(calories, weight);
        this.marmaladeType = marmaladeType;
    }

    public MarmaladeType getMarmaladeType() {
        return marmaladeType;
    }

    public void setMarmaladeType(MarmaladeType marmaladeType) {
        this.marmaladeType = marmaladeType;
    }

    @Override
    public String toString() {
        return "Marmalade";
    }
}
