package com.epam.elmira_aldenova.java.lesson2.task4.helpers;

import java.io.*;

public class Connector {
    public static void serialize(File file, Object object) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(object);
        }
    }

    public static Object deserialize(File file) throws IOException, ClassNotFoundException {
        Object readObject = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            readObject = objectInputStream.readObject();
        }
        return readObject;
    }
}
