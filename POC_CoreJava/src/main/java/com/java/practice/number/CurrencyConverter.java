package com.java.practice.number;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyConverter {

    public static void main(String[] args) {
        double payment = 12234.45;

        // Write your code here.
//        NumberFormat indianFormat = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        NumberFormat indianFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String india = indianFormat.format(payment);

        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        String us = usFormat.format(payment);

        NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = chinaFormat.format(payment);

        NumberFormat franceFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = franceFormat.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
