package com.epam.elmira_aldenova.java.lesson2.task1.entities;

public class Cookie extends Confection {
    public enum CookieType {
        AnimalCracker,
        Biscuit,
        Macaroon,
        Oreo
    }

    private CookieType cookieType;

    public Cookie(double calories, double weight, CookieType cookieType) {
        super(calories, weight);
        this.cookieType = cookieType;
    }

    public CookieType getCookieType() {
        return cookieType;
    }

    public void setCookieType(CookieType cookieType) {
        this.cookieType = cookieType;
    }

    @Override
    public String toString() {
        return "Cookie";
    }
}
