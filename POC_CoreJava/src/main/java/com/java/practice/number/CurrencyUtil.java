package com.java.practice.number;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {

    //Using India locale
//    Locale defaultLocale = new Locale("hi", "IN");
    Locale defaultLocale = Locale.ENGLISH;

    public String getCurrencyAmount(Number amount){
        return convertCurrency(amount, defaultLocale);
    }

    public double getDoubleCurrencyAmount(Number amount){
        return Double.parseDouble(convertCurrency(amount, defaultLocale));
    }

    public String convertCurrency(Number amount, Locale currentLocale){
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        return currencyFormatter.format(amount);
    }

    public static void main(String[] args) {
        CurrencyUtil cc = new CurrencyUtil();
        float amt = 12.566f;

        System.out.println(cc.getCurrencyAmount(amt));
        System.out.println(cc.getDoubleCurrencyAmount(amt));
    }
}
