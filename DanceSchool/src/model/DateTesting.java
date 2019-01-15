package model;

import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;

public class DateTesting {
    public static void main(String args[]) {
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date.getDayOfWeek());
        System.out.println(date.withHour(12));
        date = date.withHour(12);
        //DayOfWeek test = new DayOfWeek(MONDAY);
        System.out.println(date);
        System.out.println(DayOfWeek.of(1));

        ArrayList test = new ArrayList();
        //test.add()
    }
}