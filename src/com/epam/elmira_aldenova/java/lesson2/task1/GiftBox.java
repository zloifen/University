package com.epam.elmira_aldenova.java.lesson2.task1;

import com.epam.elmira_aldenova.java.lesson2.task1.entities.*;

/**
 * @author Альденова Эльмира
 * Домашнее задание 2
 */

public class GiftBox {
    public static void main(String[] args) {
        GiftBox giftBox = new GiftBox();
        giftBox.start();
    }

    private void start() {
        Chocolate chocolate = new Chocolate(10.2, 300, Chocolate.ChocolateType.MilkChocolate);
        Cookie cookie = new Cookie(12.34, 148.8, Cookie.CookieType.Oreo);
        Marmalade marmalade = new Marmalade(22.8, 30.45, Marmalade.MarmaladeType.lemon);

        Gift gift = new Gift(1);
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
