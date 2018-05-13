package com.epam.elmira_aldenova.java.lesson8.task8.entities;

public class Ingredient {
    private String name;
    private Integer quantity;

    public Ingredient(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "name = " + name + ", quantity = " + quantity;
    }
}
