package com.epam.elmira_aldenova.java.lesson8.task8.helpers;

import com.epam.elmira_aldenova.java.lesson8.task8.entities.*;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SAXHandler extends DefaultHandler {
    private String className;
    private String name;
    private Integer energy;
    private String type;
    private String production;
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    private Value value;

    private ArrayList<Candy> candies = new ArrayList<>();
    private boolean hasClass = false;
    private boolean hasIngredients = false;
    private boolean hasValue = false;

    public void startDocument() {
        System.out.println("Start document");
    }

    public void endDocument() {
        System.out.println("End document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "chocolate":
            case "cookie":
            case "marmalade":
                this.className = qName;
                this.name = attributes.getValue("name");
                this.energy = Integer.valueOf(attributes.getValue("energy"));
                this.type = attributes.getValue("type");
                this.production = attributes.getValue("production");
                this.hasClass = true;
                break;

            case "ingredients":
                for (int i = 0; i < attributes.getLength(); i++) {
                    this.ingredients.add(new Ingredient(attributes.getQName(i), Integer.valueOf(attributes.getValue(i))));
                }

                this.hasIngredients = true;
                break;

            case "value":
                int proteins = Integer.valueOf(attributes.getValue("proteins"));
                int fats = Integer.valueOf(attributes.getValue("fats"));
                int carbohydrates = Integer.valueOf(attributes.getValue("carbohydrates"));
                this.value = new Value(proteins, fats, carbohydrates);
                this.hasValue = true;
                break;

            default:
                break;
        }

        if (hasClass && hasIngredients && hasValue) {
            switch (this.className) {
                case "chocolate":
                    this.candies.add(new Chocolate(this.name, this.energy, Chocolate.ChocolateType.valueOf(this.type),
                            this.ingredients, this.value, this.production));
                    break;

                case "cookie":
                    this.candies.add(new Cookie(this.name, this.energy, Cookie.CookieType.valueOf(this.type),
                            this.ingredients, this.value, this.production));
                    break;

                case "marmalade":
                    this.candies.add(new Marmalade(this.name, this.energy, Marmalade.MarmaladeType.valueOf(this.type),
                            this.ingredients, this.value, this.production));
                    break;

                default:
                    break;
            }

            hasClass = false;
            hasIngredients = false;
            hasValue = false;
            this.ingredients = new ArrayList<>();
        }
    }

    public ArrayList<Candy> getCandies() {
        return candies;
    }
}
