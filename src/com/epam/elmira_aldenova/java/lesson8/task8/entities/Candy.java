package com.epam.elmira_aldenova.java.lesson8.task8.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Candy implements Serializable {
    private String name;
    private Integer energy;
    private ArrayList<Ingredient> ingredients;
    private Value value;
    private String production;

    public Candy(String name, Integer energy, ArrayList<Ingredient> ingredients,
                 Value value, String production) {
        this.name = name;
        this.energy = energy;
        this.ingredients = ingredients;
        this.value = value;
        this.production = production;
    }

    public String getName() {
        return name;
    }

    public Integer getEnergy() {
        return energy;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public Value getValue() {
        return value;
    }

    public String getProduction() {
        return production;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name = ").append(name).append(", energy = ").append(energy).append(", production = ").
                append(production).append("\n").append("Ingredients:\n");
        for (Ingredient ingredient : this.ingredients) {
            stringBuilder.append(ingredient.toString()).append("\n");
        }

        stringBuilder.append(this.value.toString());
        return stringBuilder.toString();
    }
}
