package com.epam.elmira_aldenova.java.lesson1.task1;

import java.util.Random;

public class ArrayProcessor {
    public static void main(String[] args) {
        ArrayProcessor arrayProcessor = new ArrayProcessor();
        arrayProcessor.start();
    }

    private void start() {
        this.swapMaxNegativeAndMinPositiveElements(this.generateArray(20, -10, 20));
        this.getSumElementsOnEvenPositions(this.generateArray(20, -10, 20));
    }

    private int[] generateArray(int length, int a, int b) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = a + (int) (Math.random() * b);
        }

        return array;
    }

    private void swapMaxNegativeAndMinPositiveElements(int[] array) {
        System.out.println("Initial array: ");
        this.printArray(array);

        int maxNegativeValue = Integer.MIN_VALUE;
        int maxNegativePos = -1;
        int minPositiveValue = Integer.MAX_VALUE;
        int minPositivePos = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 && array[i] > maxNegativeValue) {
                maxNegativeValue = array[i];
                maxNegativePos = i;
            }
            if (array[i] > 0 && array[i] < minPositiveValue) {
                minPositiveValue = array[i];
                minPositivePos = i;
            }
        }

        if (maxNegativePos != -1 && minPositivePos != -1) {
            array[maxNegativePos] = minPositiveValue;
            array[minPositivePos] = maxNegativeValue;
            System.out.println("Swap max negative element " + maxNegativeValue + " and min positive " + minPositiveValue + ": ");
            this.printArray(array);
        }
    }

    private void getSumElementsOnEvenPositions(int[] array) {
        System.out.println("Initial array: ");
        this.printArray(array);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                sum += array[i];
            }
        }

        System.out.println("Sum of elements on even positions: " + sum);
    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i]);
            }
        }
    }
}
