package com.java.practice.puzzles.string;

import java.util.Scanner;

public class PrintOutput {

    public static void main(String[] args) {

        printPattern1();
    }

    /**
     * n = ?, Matrix of n x n.
     * A A A A A
     * B B B B B
     * C C C C C
     * D D D D D
     * E E E E E
     */
    private static void printPattern1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int charN = 65;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%c ", charN);
            }
            charN++;

            if (i < n - 1)
                System.out.println();
        }
    }

}
