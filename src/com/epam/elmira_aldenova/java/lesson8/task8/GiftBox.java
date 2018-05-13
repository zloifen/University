package com.epam.elmira_aldenova.java.lesson8.task8;

import com.epam.elmira_aldenova.java.lesson8.task8.entities.Candy;
import com.epam.elmira_aldenova.java.lesson8.task8.helpers.SAXParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Альденова Эльмира
 * Домашнее задание 8
 */

public class GiftBox {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        GiftBox giftBox = new GiftBox();
        giftBox.start();
    }

    private void start() throws IOException, SAXException, ParserConfigurationException {
        SAXParser parser = new SAXParser();
        ArrayList<Candy> candies = parser.parse("gift.xml");
        for (Candy candy :
                candies) {
            System.out.println(candy.toString());
        }
    }
}
