package com.epam.elmira_aldenova.java.lesson2.task1.entities;

public class Chocolate extends Confection {
    public enum ChocolateType {
        MilkChocolate,
        BitterChocolate
    }

    private ChocolateType chocolateType;

    public Chocolate(double calories, double weight, ChocolateType chocolateType) {
        super(calories, weight);
        this.chocolateType = chocolateType;
    }

    public ChocolateType getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(ChocolateType chocolateType) {
        this.chocolateType = chocolateType;
    }

    @Override
    public String toString() {
        return "Chocolate";
    }
}
