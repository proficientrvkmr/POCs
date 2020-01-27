package com.java.practice.puzzles;

/**
 * Difference between == and .equals() method in Java.
 */
public class EqualMethod_Vs_DoubleEqualOperator {

    public static void main(String[] args) {
        String s1 = new String("HELLO");
        String s2 = new String("HELLO");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
