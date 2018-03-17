package com.epam.elmira_aldenova.java.lesson1.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Альденова Эльмира
 * Домашнее задание 1
 */
public class StringProcessor {
    public static void main(String[] args) throws IOException {
        StringProcessor stringProcessor = new StringProcessor();
        stringProcessor.start();
    }

    private void start() throws IOException {
        String[] strings = readStrings();
        printLongestAndShortestStrings(strings);
        printStringWithLengthMoreThanAverage(strings);
        printStringWithLengthLessThanAverage(strings);
        printStringWithMinNumberOfDifferentChars(strings);
        printStringThatContainsOnlyDifferentChars(strings);
        printStringThatContainsOnlyDigit(strings);
    }

    private String[] readStrings() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter n: ");
        int n = Integer.parseInt(reader.readLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = reader.readLine();
        }

        reader.close();
        return strings;
    }

    private void printStringThatContainsOnlyDigit(String[] strings) {
        String answer = "";
        boolean endOfSearch = false;
        for (int i = 0; i < strings.length && !endOfSearch; i++) {
            boolean isNumber = true;
            for (int j = 0; j < strings[i].length() && isNumber; j++) {
                if (!Character.isDigit(strings[i].charAt(j))) {
                    isNumber = false;
                }
            }

            if (isNumber && !answer.isEmpty()) {
                endOfSearch = true;
            }

            answer = strings[i];
        }

        System.out.println("String that contains only digit: " + answer);
    }

    private void printStringThatContainsOnlyDifferentChars(String[] strings) {
        String answer = "";
        for (int i = 0; i < strings.length && answer.isEmpty(); i++) {
            Character[] chars = strings[i].chars().mapToObj(c -> (char)c).toArray(Character[]::new);
            Set<Character> diffChars = new HashSet<>(Arrays.asList(chars));
            if (diffChars.size() == strings[i].length()) {
                answer = strings[i];
            }
        }

        System.out.println("String only with different chars: " + answer);
    }

    private void printStringWithMinNumberOfDifferentChars(String[] strings) {
        String answer = "";
        int numberOfDiffChars = Integer.MAX_VALUE;
        for (String string: strings) {
            Character[] chars = string.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
            Set<Character> diffChars = new HashSet<>(Arrays.asList(chars));
            if (diffChars.size() < numberOfDiffChars) {
                answer = string;
                numberOfDiffChars = diffChars.size();
            }
        }

        System.out.println("String with min number of different chars: " + answer);
    }

    private void printStringWithLengthLessThanAverage(String[] strings) {
        double averageLength = strings[0].length();
        for (int i = 1; i < strings.length; i++) {
            averageLength += strings[i].length();
        }

        averageLength = Math.round(averageLength / strings.length);

        System.out.println("Strings with length less than average length: ");
        for (String string : strings) {
            if (string.length() < averageLength) {
                System.out.println(string);
                System.out.println("Length: " + string.length());
            }
        }
    }

    private void printStringWithLengthMoreThanAverage(String[] strings) {
        double averageLength = strings[0].length();
        for (int i = 1; i < strings.length; i++) {
            averageLength += strings[i].length();
        }

        averageLength = Math.round(averageLength / strings.length);

        System.out.println("Strings with length more than average length: ");
        for (String string : strings) {
            if (string.length() > averageLength) {
                System.out.println(string);
                System.out.println("Length: " + string.length());
            }
        }
    }

    private void printLongestAndShortestStrings(String[] strings) {
        String longest = strings[0];
        String shortest = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() > longest.length()) {
                longest = strings[i];
            }

            if (strings[i].length() < shortest.length()) {
                shortest = strings[i];
            }
        }

        System.out.println("Longest string: " + longest);
        System.out.println("Length: " + longest.length());
        System.out.println("Shortest string: " + shortest);
        System.out.println("Length: " + shortest.length());
    }
}
