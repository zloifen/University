package com.epam.elmira_aldenova.java.lesson3.task1.entitites;

import com.epam.elmira_aldenova.java.lesson3.task1.entitites.Program;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Student {
    private String firstName;
    private String lastName;
    private Program program;

    public Student(String firstName, String lastName, Program program) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.program = program;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Program getProgram() {
        return program;
    }

    public String getShortReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.lastName).append(" ").append(this.firstName).append(" ");
        builder.append("(").append(this.program.getCurriculum()).append(") - ");
        if (this.getProgram().isProgramCompleted()) {
            builder.append("Обучение закончено. ");
        } else {
            builder.append("Обучение не закончено. ");
        }

        builder.append(this.program.getDateDiff());
        return builder.toString();
    }

    public String getFullReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("ФИО: ").append(this.lastName).append(" ").append(this.firstName).append("\n");
        builder.append("Рабочее время: с ").append(Program.getStartHour()).append(" до ").append(Program.getEndHour()).append("\n");
        builder.append("Название программы: ").append(this.program.getCurriculum()).append("\n");
        builder.append("Длительность программы: ").append(this.program.getDuration()).append("ч\n");
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        builder.append("Дата старта: ").append(dateFormat.format(this.program.getStartDate())).append("\n");
        builder.append("Дата завершения: ").append(dateFormat.format(this.program.getEndDate())).append("\n");
        if (this.getProgram().isProgramCompleted()) {
            builder.append("Обучение закончено. ");
        } else {
            builder.append("Обучение не закончено. ");
        }

        builder.append(this.program.getDateDiff());
        return builder.toString();
    }
}
