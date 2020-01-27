package com.java.practice.puzzles.string;

/**
 * Ques: What happens if string variables assign with crores of characters in java ?
 * Ans:
 * <p>
 * INT DATA TYPE  = 4 bytes. This is the default integer type. Most of the times we use int type
 * only to work with whole numbers even though they can be managed with byte or short.
 * <p>
 * We can use up to a 10 digit number (up to 200 crores nearly) with int type.
 */
public class StringUnlimited {

    public static void main(String[] args) {
        int a = 2147483647;
        int b = 2147483647;
        int c = a + b;

        // 1999999998
        System.out.println(a + 1);
        System.out.println(c);
    }
}
