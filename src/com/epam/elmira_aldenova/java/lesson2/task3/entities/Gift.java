package com.epam.elmira_aldenova.java.lesson2.task3.entities;

import com.epam.elmira_aldenova.java.lesson2.task3.contracts.IGift;
import com.epam.elmira_aldenova.java.lesson2.task3.helpers.SortByCalories;

import java.util.ArrayList;

public class Gift implements IGift {
    private ArrayList<Confection> confections;

    public Gift() {
        this.confections = new ArrayList<>();
    }

    public ArrayList<Confection> getConfections() {
        return confections;
    }

    public void printGift() {
        for (int i = 0; i < this.confections.size(); i++) {
            Confection confection = this.confections.get(i);
            System.out.println(confection.toString() + " with " + confection.getCalories() +
                    " calories and " + confection.getWeight() + " weight");
        }
    }

    @Override
    public void addConfection(Confection confection) {
        if (confection == null) {
            throw new IllegalArgumentException("Confection can't be null");
        }

        this.confections.add(confection);
    }

    @Override
    public double getWeight() {
        double giftWeight = 0;
        for (int i = 0; i < this.confections.size(); i++) {
            giftWeight += this.confections.get(i).getWeight();
        }

        return giftWeight;
    }

    @Override
    public void sortByCalories() {
        this.confections.sort(new SortByCalories());
    }

    @Override
    public Confection findByCalories(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min should be less then max");
        }

        for (int i = 0; i < this.confections.size(); i++) {
            if (this.confections.get(i).getCalories() > min && this.confections.get(i).getCalories() < max) {
                return this.confections.get(i);
            }
        }

        return null;
    }
}
