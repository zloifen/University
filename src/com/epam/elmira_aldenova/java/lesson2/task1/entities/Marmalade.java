package com.epam.elmira_aldenova.java.lesson2.task1.entities;

public class Marmalade extends Confection {
    public enum MarmaladeType {
        Kumquat,
        lemon,
        Lime,
        Mandarin
    }

    private MarmaladeType marmaladeType;

    public Marmalade(double calories, double weight, MarmaladeType marmaladeType) {
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
