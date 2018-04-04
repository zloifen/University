package com.epam.elmira_aldenova.java.lesson3.task1;

import com.epam.elmira_aldenova.java.lesson3.task1.entitites.Course;
import com.epam.elmira_aldenova.java.lesson3.task1.entitites.Program;
import com.epam.elmira_aldenova.java.lesson3.task1.entitites.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Альденова Эльмира
 * Домашнее задание 3
 */

public class EducationCenter {
    public static void main(String[] args) throws ParseException {
        EducationCenter educationCenter = new EducationCenter();
        educationCenter.start();
    }

    private void start() throws ParseException {
        Course course1 = new Course("Технология Java Servlets", 16);
        Course course2 = new Course("Struts Framework", 23);
        Program program1 = new Program("J2EE Developer",
                new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-03-14 10:00"),
                new Course[]{course1, course2});
        Student student1 = new Student("Ivan", "Ivanov", program1);

        Course course3 = new Course("Обзор технологий Java", 8);
        Course course4 = new Course("Библиотека JFC/Swing", 16);
        Course course5 = new Course("Технология JDBC", 14);
        Program program2 = new Program("Java Developer",
                new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-04-01 15:00"),
                new Course[]{course3, course4, course5});
        Student student2 = new Student("Petr", "Petrov", program2);

        System.out.println("Введите 0 - короткий отчет");
        System.out.println("Введите 1 - подробный отчет");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int mode = Integer.parseInt(reader.readLine());
            switch (mode) {
                case 0:
                    System.out.println(student1.getShortReport());
                    System.out.println(student2.getShortReport());
                    break;

                case 1:
                    System.out.println(student1.getFullReport());
                    System.out.println(student2.getFullReport());
                    break;

                default:
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
