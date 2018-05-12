package com.epam.elmira_aldenova.java.lesson2.task3.entities;

import com.epam.elmira_aldenova.java.lesson2.task3.exceptions.InvalidCaloriesException;
import com.epam.elmira_aldenova.java.lesson2.task3.exceptions.InvalidWeightException;

public class Confection {
    private double calories;
    private double weight;

    public Confection(double calories, double weight) throws InvalidCaloriesException, InvalidWeightException {
        if (calories > 0) {
            this.calories = calories;
        } else {
            throw new InvalidCaloriesException("Argument calories should be positive");
        }

        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new InvalidWeightException("Argument weight should be positive");
        }
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) throws InvalidCaloriesException {
        if (calories > 0) {
            this.calories = calories;
        } else {
            throw new InvalidCaloriesException("Argument calories should be positive");
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws InvalidWeightException {
        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new InvalidWeightException("Argument weight should be positive");
        }
    }

    @Override
    public String toString() {
        return "Confection";
    }
}
