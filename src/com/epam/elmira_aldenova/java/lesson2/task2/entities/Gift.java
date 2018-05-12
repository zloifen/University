package com.epam.elmira_aldenova.java.lesson2.task2.entities;

import com.epam.elmira_aldenova.java.lesson2.task2.contracts.IGift;
import com.epam.elmira_aldenova.java.lesson2.task2.entities.Confection;
import com.epam.elmira_aldenova.java.lesson2.task2.helpers.DynamicArray;
import com.epam.elmira_aldenova.java.lesson2.task2.helpers.SortByCalories;
import com.sun.javaws.exceptions.InvalidArgumentException;

public class Gift implements IGift {
    private DynamicArray<Confection> confections;

    public Gift(int size) {
        if (size < 0) {
            throw new NegativeArraySizeException("Size should be positive");
        }

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
        if (confection == null) {
            throw new IllegalArgumentException("Confection can't be null");
        }

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
        if (min > max) {
            throw new IllegalArgumentException("Min should be less then max");
        }

        for (int i = 0; i < this.confections.getLength(); i++) {
            if (this.confections.get(i).getCalories() > min && this.confections.get(i).getCalories() < max) {
                return this.confections.get(i);
            }
        }

        return null;
    }
}
