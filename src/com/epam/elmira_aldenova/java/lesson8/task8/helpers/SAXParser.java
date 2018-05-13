package com.epam.elmira_aldenova.java.lesson8.task8.helpers;

import com.epam.elmira_aldenova.java.lesson8.task8.entities.Candy;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

public class SAXParser {
    public ArrayList<Candy> parse(String fileName) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser parser = factory.newSAXParser();
        SAXHandler handler = new SAXHandler();
        parser.parse(fileName, handler);
        return handler.getCandies();
    }
}
