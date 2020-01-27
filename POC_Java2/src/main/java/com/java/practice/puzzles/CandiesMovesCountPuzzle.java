package com.java.practice.puzzles;

import java.util.Scanner;


/**
 * An Annual learning competition was organised by a college in its various branches. Various students
 * enrolled their name in the competition for their participation. Children are assigned a task on the
 * spot about a puzzle which they have to solve in a very limited duration of time. They have been given
 * a right isosceles triangle made of n > 0 lines containing 1, 3, . . . , 2n âˆ’ 1 identical candies,
 * respectively. They have to find out the minimum number of candies that will be needed to move these
 * candies to create a square made up of all the candies given in the triangle. The student who solves
 * this puzzle first will be awarded first and so on.
 * <p>
 * You have to return the minimum number of candies that is needed to move to convert the isosceles
 * triangle into square made up of all the candies.
 * <p>
 * <p>
 * For example, assuming the number of lines of candies in the triangle is 3.
 * <p>
 * <p>
 * Hence, the minimum number of candies that is needed to move to convert the isosceles triangle
 * into square will be 2.
 * <p>
 * Input Format
 * Total number of lines of candies in the triangle.
 * <p>
 * Constraints
 * 0 < N <=10000
 * <p>
 * Output Format
 * Minimum number of candies that is needed to move to convert the isosceles triangle into square.
 * <p>
 * Sample TestCase 1
 * Input
 * 3
 * Output
 * 2
 */
public class CandiesMovesCountPuzzle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int moveCandies = 0;
        int squareFullRowCount = 0;

        for (int requiredMoveCount = 0; (requiredMoveCount < n) && (squareFullRowCount < n); requiredMoveCount++) {

            if (requiredMoveCount == 0) {
                squareFullRowCount = 1;

            } else if ((n % 2 == 0) && (requiredMoveCount % 2 == 0)) {
                int remainRows = n - squareFullRowCount;
                moveCandies = moveCandies + remainRows * requiredMoveCount;
                squareFullRowCount = squareFullRowCount + remainRows;

            } else {
                squareFullRowCount = squareFullRowCount + 2;
                moveCandies = moveCandies + (requiredMoveCount * 2);
            }
        }

        System.out.println("Total rows in square: " + n);
        System.out.println("Required moved candies: " + moveCandies);
    }
}
