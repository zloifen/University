package com.epam.elmira_aldenova.java.lesson8.task8.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Cookie extends Candy implements Serializable {
    public enum CookieType {
        AnimalCracker,
        Biscuit,
        Macaroon,
        Oreo
    }

    private CookieType cookieType;

    public Cookie(String name, Integer energy, CookieType type, ArrayList<Ingredient> ingredients, Value value, String production) {
        super(name, energy, ingredients, value, production);
        this.cookieType = type;
    }

    @Override
    public String toString() {
        return "Cookie:\n" + super.toString() + "\nType = " + this.cookieType.toString();
    }
}
