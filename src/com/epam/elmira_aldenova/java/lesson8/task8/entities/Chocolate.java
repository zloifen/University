package com.epam.elmira_aldenova.java.lesson8.task8.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Chocolate extends Candy implements Serializable {
    public enum ChocolateType {
        Stuffed,
        WithoutStuffing
    }

    private ChocolateType chocolateType;

    public Chocolate(String name, Integer energy, ChocolateType type, ArrayList<Ingredient> ingredients,
                     Value value, String production) {
        super(name, energy, ingredients, value, production);
        this.chocolateType = type;
    }

    @Override
    public String toString() {
        return "Chocolate:\n" + super.toString() + "\nType = " + this.chocolateType.toString();
    }
}
