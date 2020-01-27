package com.java.practice.date;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

public class CalendarQuestion {

    public static void main(String[] args) {
        int month = 7;
        int day = 31;
        int year = 2017;

        java7(month, day, year);
        java8(month, day, year);

    }

    private static void java8(int month, int day, int year) {
        LocalDate dt = LocalDate.of(year, month, day);
        System.out.print(dt.getDayOfWeek());
    }

    private static void java7(int month, int day, int year) {
        Calendar cc = Calendar.getInstance();
        cc.set(Calendar.DATE, day);
        cc.set(Calendar.MONTH, month);
        cc.set(Calendar.YEAR, year);

        String dayOfWeek = cc.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()).toUpperCase();
        System.out.println(dayOfWeek);
    }
}
