package com.epam.elmira_aldenova.java.lesson2.task1.entities;

public class Confection {
    private double calories;
    private double weight;

    public Confection(double calories, double weight) {
        this.calories = calories;
        this.weight = weight;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        if (calories > 0) {
            this.calories = calories;
        } else {
            throw new IllegalArgumentException("Argument calories should be positive");
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Argument weight should be positive");
        }
    }

    @Override
    public String toString() {
        return "Confection";
    }
}
