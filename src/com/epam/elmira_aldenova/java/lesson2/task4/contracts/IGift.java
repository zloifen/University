package com.epam.elmira_aldenova.java.lesson2.task4.contracts;

import com.epam.elmira_aldenova.java.lesson2.task4.entities.Confection;

public interface IGift {
    void addConfection(Confection confection);

    double getWeight();

    void sortByCalories();

    Confection findByCalories(int min, int max);
}
