package com.epam.elmira_aldenova.java.lesson1.task3;

import com.epam.elmira_aldenova.java.lesson1.task1.ArrayProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Альденова Эльмира
 * Домашнее задание 1
 */

public class Calculator {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        calculator.start();
    }

    private void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a: ");
        int a = Integer.parseInt(reader.readLine());
        System.out.print("Enter b: ");
        int b = Integer.parseInt(reader.readLine());
        System.out.println("Choose operation: ");
        System.out.println("1 - addition (+)");
        System.out.println("2 - subtraction (-)");
        System.out.println("3 - multiplication (*)");
        System.out.println("4 - division (/)");
        int operation = Integer.parseInt(reader.readLine());
        switch (operation) {
            case 1:
                System.out.println("a + b = " + add(a, b));
                break;

            case 2:
                System.out.println("a - b = " + subtract(a, b));
                break;

            case 3:
                System.out.println("a * b = " + multiply(a, b));
                break;

            case 4:
                System.out.println("a / b = " + divide(a, b));
                break;

            default:
                System.out.println("Invalid operation");
                break;
        }
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private double divide(double a, double b) {
        return a / b;
    }
}
