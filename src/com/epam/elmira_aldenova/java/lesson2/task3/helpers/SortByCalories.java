package com.epam.elmira_aldenova.java.lesson2.task3.helpers;

import com.epam.elmira_aldenova.java.lesson2.task3.entities.Confection;

import java.util.Comparator;

public class SortByCalories implements Comparator<Confection> {
    @Override
    public int compare(Confection o1, Confection o2) {
        return Double.compare(o1.getCalories(), o2.getCalories());
    }
}
