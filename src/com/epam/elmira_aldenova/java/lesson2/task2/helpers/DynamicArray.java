package com.epam.elmira_aldenova.java.lesson2.task2.helpers;

import java.util.Arrays;
import java.util.Comparator;

public class DynamicArray<T> {
    private T[] collectionArray;
    private int length;
    private int capacity;

    public DynamicArray() {
        this.collectionArray = (T[]) new Object[8];
        this.length = 0;
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity can't be negative");
        }

        this.collectionArray = (T[]) new Object[capacity];
        this.length = 0;
    }

    public T get(int index) {
        if (index < 0 || index > this.length) {
            return null;
        }

        return this.collectionArray[index];
    }

    public void add(T item) {
        if (this.length == this.getCapacity()) {
            this.setCapacity(this.getCapacity() * 2);
        }

        this.collectionArray[this.length++] = item;
    }

    public boolean removeAt(int index) {
        if (index < 0 || index > this.length) {
            return false;
        }

        System.arraycopy(this.collectionArray, index + 1, this.collectionArray, index, this.length - 1 - index);
        this.length--;
        return true;
    }

    public int getLength() {
        return length;
    }

    public int getCapacity() {
        return this.collectionArray.length;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity can't be negative");
        }

        if (this.length > capacity) {
            this.length = capacity;
        }

        if (this.collectionArray.length < capacity) {
            this.editArray(capacity);
        }
    }

    public void sort(Comparator<T> comparator) {
        this.editArray(this.length);
        Arrays.sort(this.collectionArray, comparator);
    }

    private void editArray(int capacity) {
        T[] array = (T[]) new Object[capacity];
        System.arraycopy(this.collectionArray, 0, array, 0, this.length);

        this.collectionArray = array;
    }
}
