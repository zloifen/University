package com.epam.elmira_aldenova.java.lesson8.task8.entities;

public class Value {
    private int proteins;
    private int fats;
    private int carbohydrates;

    public Value(int proteins, int fats, int carbohydrates) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public int getProteins() {
        return proteins;
    }

    public int getFats() {
        return fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    @Override
    public String toString() {
        return "Value: proteins = " + proteins + ", fats = " + fats + ", carbohydrates = " + carbohydrates;
    }
}
