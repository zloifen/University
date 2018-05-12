package com.epam.elmira_aldenova.java.lesson2.task3;

import com.epam.elmira_aldenova.java.lesson2.task3.entities.*;
import com.epam.elmira_aldenova.java.lesson2.task3.exceptions.InvalidCaloriesException;
import com.epam.elmira_aldenova.java.lesson2.task3.exceptions.InvalidWeightException;

/**
 * @author Альденова Эльмира
 * Домашнее задание 5
 */

public class GiftBox {
    public static void main(String[] args) throws InvalidCaloriesException, InvalidWeightException {
        GiftBox giftBox = new GiftBox();
        giftBox.start();
    }

    private void start() throws InvalidCaloriesException, InvalidWeightException {
        Chocolate chocolate = new Chocolate(10.2, 300, Chocolate.ChocolateType.MilkChocolate);
        Cookie cookie = new Cookie(12.34, 148.8, Cookie.CookieType.Oreo);
        Marmalade marmalade = new Marmalade(22.8, 30.45, Marmalade.MarmaladeType.lemon);

        Gift gift = new Gift();
        gift.addConfection(marmalade);
        gift.addConfection(chocolate);
        gift.addConfection(cookie);

        System.out.println("Gift weight: " + gift.getWeight());

        System.out.println("Gift before sort: ");
        gift.printGift();

        gift.sortByCalories();
        System.out.println("Gift after sort: ");
        gift.printGift();

        System.out.println("Find confection with calories between 20 and 30:");
        Confection confection = gift.findByCalories(20, 30);
        System.out.println(confection.toString() + " with " + confection.getCalories() + " calories");
    }
}
