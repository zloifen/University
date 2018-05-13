package com.epam.elmira_aldenova.java.lesson8.task8.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Marmalade extends Candy implements Serializable {
    public enum MarmaladeType {
        Kumquat,
        Lemon,
        Lime,
        Mandarin
    }

    private MarmaladeType marmaladeType;

    public Marmalade(String name, Integer energy, MarmaladeType type, ArrayList<Ingredient> ingredients, Value value, String production) {
        super(name, energy, ingredients, value, production);
        this.marmaladeType = type;
    }

    @Override
    public String toString() {
        return "Marmalade:\n" + super.toString() + "\nType = " + this.marmaladeType.toString();
    }
}
