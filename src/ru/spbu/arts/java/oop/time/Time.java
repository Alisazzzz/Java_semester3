package ru.spbu.arts.java.oop.time;

public class Time {
    private int hours;
    private int min;

    Time(int a, int b) {
        this.hours = a;
        this.min = b;
    }


    public String show() {
        String a = Integer.toString(hours);
        String b = Integer.toString(min);
        if (a.length() < 2)
            a = "0" + a;
        if (b.length() < 2)
            b = "0" + b;
        return "%s:%s".formatted(a, b);
    }


    public boolean isDay() {
        return (11 < hours && hours < 18);
    }

    public boolean isMorning() {
        return (3 < hours && hours < 12);
    }

    public boolean isEvening() {
        return (17 < hours && hours < 23);
    }

    public boolean isNight() {
        return (22 < hours || hours < 4);
    }


    public String sayHello() {
        if (isMorning())
            return "Доброе утро";
        if (isDay())
            return "Добрый день";
        if (isEvening())
            return "Добрый вечер";
        if (isNight())
            return "Доброй ночи";
        return null;
    }


    public void add(int toAdd) {
        int hoursToAdd = toAdd / 60;
        int minutesToAdd = toAdd % 60;
        this.hours = this.hours + hoursToAdd;
        this.min = this.min + minutesToAdd;

        if (this.min > 59) {
            this.hours = this.hours + 1;
            this.min = this.min % 60;
        }
    }

}
