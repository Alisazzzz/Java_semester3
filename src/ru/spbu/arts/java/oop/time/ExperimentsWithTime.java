package ru.spbu.arts.java.oop.time;

public class ExperimentsWithTime {

    public static void main(String[] args) {

        Time time1 = new Time(13, 4);
        System.out.println(time1.show());
        System.out.println(time1.isMorning());
        System.out.println(time1.isDay());
        System.out.println(time1.sayHello());
        time1.add(50);
        System.out.println(time1.show());
        time1.add(130);
        System.out.println(time1.show());
    }
}
