package com.epam.elmira_aldenova.java.lesson3.task1.entitites;

import com.epam.elmira_aldenova.java.lesson3.task1.entitites.Course;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Program {
    private static int academicHours = 8;
    private static int startHour = 10;
    private static int endHour = 18;

    private String curriculum;
    private Date startDate;
    private Course[] courses;

    public Program(String curriculum, Date startDate, Course[] courses) {
        this.curriculum = curriculum;
        this.startDate = startDate;
        this.courses = courses;
    }

    public boolean isProgramCompleted() {
        Date endDate = this.getEndDate();
        return new Date().after(endDate);
    }

    public String getDateDiff() {
        Date end = this.getEndDate();
        Date current = new Date();
        LocalDateTime endTime = LocalDateTime.ofInstant(end.toInstant(), ZoneId.systemDefault());
        LocalDateTime currentTime = LocalDateTime.ofInstant(current.toInstant(), ZoneId.systemDefault());

        long days = 0;
        long hours = 0;
        if (end.after(current)) {
            if (currentTime.getHour() >= startHour && currentTime.getHour() < endHour) {
                hours += (endHour - currentTime.getHour());
                currentTime = currentTime.plusHours(24 - currentTime.getHour() + startHour);
            }
            else {
                if (currentTime.getHour() < startHour) {
                    currentTime = currentTime.plusHours(startHour - currentTime.getHour());
                } else {
                    if (currentTime.getHour() >= endHour) {
                        currentTime = currentTime.plusHours(24 - currentTime.getHour() + startHour);
                    }
                }
            }

            LocalDateTime tempDateTime = LocalDateTime.from(currentTime);
            days = tempDateTime.until(endTime, ChronoUnit.DAYS);
            tempDateTime = tempDateTime.plusDays(days);
            hours += (endTime.getHour() - tempDateTime.getHour());
            return "До окончания осталось " + days + " д " + hours + " ч.";
        }
        else {
            if (endTime.getHour() >= startHour && endTime.getHour() < endHour) {
                hours += (endHour - endTime.getHour());
                endTime = endTime.plusHours(24 - endTime.getHour() + startHour);
            }
            else {
                if (endTime.getHour() < startHour) {
                    endTime = endTime.plusHours(startHour - endTime.getHour());
                } else {
                    if (endTime.getHour() >= endHour) {
                        endTime = endTime.plusHours(24 - endTime.getHour() + startHour);
                    }
                }
            }

            LocalDateTime tempDateTime = LocalDateTime.from(endTime);
            days = tempDateTime.until(currentTime, ChronoUnit.DAYS);
            tempDateTime = tempDateTime.plusDays(days);
            if (currentTime.getHour() >= endHour) {
                days++;
            }
            else {
                if (currentTime.getHour() >= startHour) {
                    hours += (currentTime.getHour() - startHour);
                }
            }

            return "После окончания прошло " + days + " д " + hours + " ч.";
        }
    }

    public Integer getDuration() {
        Integer programDuration = 0;
        for (Course course : this.courses) {
            programDuration += course.getDuration();
        }

        return programDuration;
    }

    public Date getEndDate() {
        Integer programDuration = this.getDuration();

        LocalDateTime dateTime = LocalDateTime.ofInstant(this.startDate.toInstant(), ZoneId.systemDefault());
        //Add hours of first day of program
        if (dateTime.getHour() >= startHour && dateTime.getHour() < endHour) {
            programDuration -= (endHour - dateTime.getHour());
        }
        else {
            if (dateTime.getHour() < startHour) {
                programDuration -= academicHours;
            }
        }

        dateTime = dateTime.plusHours(24 - dateTime.getHour());

        //Add full days of program
        int days = programDuration / academicHours;
        dateTime = dateTime.plusDays(days);

        //Add last hours of program
        int hours = programDuration % academicHours;
        if (hours == 0) {
            dateTime = dateTime.minusDays(1);
            dateTime = dateTime.plusHours(endHour);
        }
        else {
            dateTime = dateTime.plusHours(startHour + hours);
        }
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public String getCurriculum() {
        return curriculum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public static int getStartHour() {
        return startHour;
    }

    public static int getEndHour() {
        return endHour;
    }
}
