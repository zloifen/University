package com.epam.elmira_aldenova.java.lesson2.task1.entities;

import com.epam.elmira_aldenova.java.lesson2.task1.contracts.IGift;
import com.epam.elmira_aldenova.java.lesson2.task1.helpers.SortByCalories;
import com.epam.elmira_aldenova.java.lesson2.task1.helpers.DynamicArray;

public class Gift implements IGift {
    private DynamicArray<Confection> confections;

    public Gift(int size) {
        this.confections = new DynamicArray<>(size);
    }

    public DynamicArray<Confection> getConfections() {
        return confections;
    }

    public void printGift() {
        for (int i = 0; i < this.confections.getLength(); i++) {
            Confection confection = this.confections.get(i);
            System.out.println(confection.toString() + " with " + confection.getCalories() +
                    " calories and " + confection.getWeight() + " weight");
        }
    }

    @Override
    public void addConfection(Confection confection) {
        this.confections.add(confection);
    }

    @Override
    public double getWeight() {
        double giftWeight = 0;
        for (int i = 0; i < this.confections.getLength(); i++) {
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
        for (int i = 0; i < this.confections.getLength(); i++) {
            if (this.confections.get(i).getCalories() > min && this.confections.get(i).getCalories() < max) {
                return this.confections.get(i);
            }
        }

        return null;
    }
}
