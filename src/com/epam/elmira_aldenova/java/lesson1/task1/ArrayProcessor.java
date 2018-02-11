package com.epam.elmira_aldenova.java.lesson1.task1;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Альденова Эльмира
 * Домашнее задание 1
 */
public class ArrayProcessor {
    public static void main(String[] args) {
        ArrayProcessor arrayProcessor = new ArrayProcessor();
        arrayProcessor.start();
    }

    private void start() {
        int[] array = this.generateArray(20, -10, 20);
        System.out.println("Initial array");
        this.printArray(array);

        int[] result = new int[array.length];
        System.arraycopy(array, 0, result, 0, array.length);
        int[] swappedMaxNegativeAndMinPositiveElements = this.swapMaxNegativeAndMinPositiveElements(result);
        System.out.println("Swapped max negative and min positive elements:");
        this.printArray(swappedMaxNegativeAndMinPositiveElements);

        int sum = this.getSumOfElementsOnEvenPositions(array);
        System.out.println("Sum of elements on even positions: " + sum);

        System.arraycopy(array, 0, result, 0, array.length);
        int[] replacedNegativeElementsToZero = this.replaceNegativeElementsToZero(result);
        System.out.println("Replaced negative elements to zero:");
        this.printArray(replacedNegativeElementsToZero);

        System.arraycopy(array, 0, result, 0, array.length);
        int[] tripledPositiveElementBeforeNegative = this.triplePositiveElementBeforeNegative(result);
        System.out.println("Tripled positive element before negative:");
        this.printArray(tripledPositiveElementBeforeNegative);

        System.arraycopy(array, 0, result, 0, array.length);
        int diff = this.differenceBetweenAverageValueAndMinValue(result);
        System.out.println("Difference between average value and minimum value: " + diff);

        System.arraycopy(array, 0, result, 0, array.length);
        int[] elementsOccurMoreThanOnceAndOnOddPositions  = this.getElementsOccurMoreThanOnceAndOnOddPositions(result);
        System.out.println("Elements that on odd positions and occurred more than once:");
        this.printArray(elementsOccurMoreThanOnceAndOnOddPositions);
    }

    /**
     * Генерация массива
     *
     * @param length - количество элементов в массиве
     * @param a      - отвечает за диапазон значения элемента массива
     * @param b      - отвечает за диапазон значения элемента массива
     */
    private int[] generateArray(int length, int a, int b) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = a + (int) (Math.random() * b);
        }

        return array;
    }

    private int[] swapMaxNegativeAndMinPositiveElements(int[] array) {
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
        }

        return array;
    }

    private int getSumOfElementsOnEvenPositions(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                sum += array[i];
            }
        }

        return sum;
    }

    private int[] replaceNegativeElementsToZero(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = 0;
            }
        }

        return array;
    }

    private int[] triplePositiveElementBeforeNegative(int[] array) {
        boolean flag = false;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] < 0) {
                flag = true;
            }
            else {
                if (array[i] > 0) {
                    if (flag) {
                        array[i] *= 3;
                    }

                    flag = false;
                }
            }
        }

        return array;
    }

    private int differenceBetweenAverageValueAndMinValue(int[] array) {
        int average = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            average += array[i];
            if (array[i] < min) {
                min = array[i];
            }
        }

        return average / array.length - min;
    }

    private int[] getElementsOccurMoreThanOnceAndOnOddPositions(int[] array) {
        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> occurrences = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                int size = occurrences.size();
                occurrences.add(array[i]);
                if (size == occurrences.size()) {
                    result.add(array[i]);
                }
            }
        }

        int[] toArray = new int[result.size()];
        int i = 0;
        for (Integer item: result) {
            toArray[i++] = item;
        }

        return toArray;
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
