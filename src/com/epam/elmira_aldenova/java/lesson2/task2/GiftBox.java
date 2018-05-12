package com.epam.elmira_aldenova.java.lesson2.task2;

import com.epam.elmira_aldenova.java.lesson2.task2.entities.*;
import com.epam.elmira_aldenova.java.lesson2.task2.exceptions.InvalidCaloriesException;
import com.epam.elmira_aldenova.java.lesson2.task2.exceptions.InvalidWeightException;

/**
 * @author Альденова Эльмира
 * Домашнее задание 4
 */

public class GiftBox {
    public static void main(String[] args) {
        GiftBox giftBox = new GiftBox();
        giftBox.start();
    }

    private void start() {
        Chocolate chocolate = null;
        try {
            System.out.println("Attempt to create chocolate");
            chocolate = new Chocolate(-10.2, 300, Chocolate.ChocolateType.MilkChocolate);
            System.out.println("Successful attempt");
        } catch (InvalidCaloriesException | InvalidWeightException e) {
            System.out.println("Unsuccessful attempt: " + e.getMessage());
        }

        try {
            System.out.println("Attempt to create gift");
            Gift gift = new Gift(-10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Gift gift = new Gift(3);
        try {
            System.out.println("Attempt to add confection to gift");
            gift.addConfection(chocolate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Attempt to create chocolate");
            chocolate = new Chocolate(10.2, 300, Chocolate.ChocolateType.MilkChocolate);
            System.out.println("Successful attempt");
        } catch (InvalidCaloriesException | InvalidWeightException e) {
            System.out.println("Unsuccessful attempt: " + e.getMessage());
        }

        Cookie cookie = null;
        try {
            System.out.println("Attempt to create cookie");
            cookie = new Cookie(12.34, -148.8, Cookie.CookieType.Oreo);
            System.out.println("Successful attempt");
        } catch (InvalidCaloriesException | InvalidWeightException e) {
            System.out.println("Unsuccessful attempt: " + e.getMessage());
        }

        try {
            System.out.println("Attempt to create cookie");
            cookie = new Cookie(12.34, 148.8, Cookie.CookieType.Oreo);
            System.out.println("Successful attempt");
        } catch (InvalidCaloriesException | InvalidWeightException e) {
            System.out.println("Unsuccessful attempt: " + e.getMessage());
        }

        Marmalade marmalade = null;
        try {
            System.out.println("Attempt to create marmalade");
            marmalade = new Marmalade(-22.8, -30.45, Marmalade.MarmaladeType.lemon);
            System.out.println("Successful attempt");
        } catch (InvalidCaloriesException | InvalidWeightException e) {
            System.out.println("Unsuccessful attempt: " + e.getMessage());
        }

        try {
            System.out.println("Attempt to create marmalade");
            marmalade = new Marmalade(22.8, 30.45, Marmalade.MarmaladeType.lemon);
            System.out.println("Successful attempt");
        } catch (InvalidCaloriesException | InvalidWeightException e) {
            System.out.println("Unsuccessful attempt: " + e.getMessage());
        }

        System.out.println("Gift: ");
        gift.addConfection(chocolate);
        gift.addConfection(cookie);
        gift.addConfection(marmalade);

        gift.printGift();

        try {
            System.out.println("Attempt to find confection in the range of calories");
            gift.findByCalories(100, 10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
