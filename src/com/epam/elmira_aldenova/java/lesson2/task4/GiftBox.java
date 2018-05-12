package com.epam.elmira_aldenova.java.lesson2.task4;

import com.epam.elmira_aldenova.java.lesson2.task4.entities.*;
import com.epam.elmira_aldenova.java.lesson2.task4.exceptions.InvalidCaloriesException;
import com.epam.elmira_aldenova.java.lesson2.task4.exceptions.InvalidWeightException;
import com.epam.elmira_aldenova.java.lesson2.task4.helpers.Connector;

import java.io.File;
import java.io.IOException;

/**
 * @author Альденова Эльмира
 * Домашнее задание 6
 */

public class GiftBox {
    public static void main(String[] args) throws InvalidCaloriesException, InvalidWeightException, IOException, ClassNotFoundException {
        GiftBox giftBox = new GiftBox();
        giftBox.start();
    }

    private void start() throws InvalidCaloriesException, InvalidWeightException, IOException, ClassNotFoundException {
        Chocolate chocolate = new Chocolate(10.2, 300, Chocolate.ChocolateType.MilkChocolate);
        Cookie cookie = new Cookie(12.34, 148.8, Cookie.CookieType.Oreo);
        Marmalade marmalade = new Marmalade(22.8, 30.45, Marmalade.MarmaladeType.lemon);

        Gift gift = new Gift();
        gift.addConfection(marmalade);
        gift.addConfection(chocolate);
        gift.addConfection(cookie);

        System.out.println("Created gift:");
        gift.printGift();

        File fileOutput = new File("gift.json");
        Connector.serialize(fileOutput, gift);

        File fileInput = new File("gift.json");
        Gift desGift = (Gift) Connector.deserialize(fileInput);
        System.out.println("Deserialized gift:");
        desGift.printGift();
    }
}
