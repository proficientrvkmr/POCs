package com.java.practice.hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 */
public class HackerRank_DiagnolDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {

        int sum1 = 0, sum2 = 0;
        int length = arr.size();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    sum1 += arr.get(i).get(j);
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if ((i + j) == (length - 1)) {
                    sum2 += arr.get(i).get(j);
                }
            }
        }
        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) throws IOException {

        List<Integer> a1 = Arrays.asList(2, 3, 4);
        List<Integer> a2 = Arrays.asList(4, 3, 1);
        List<Integer> a3 = Arrays.asList(1, 3, 2);
        List<List<Integer>> twoDArray = Arrays.asList(a1, a2, a3);

        int result = diagonalDifference(twoDArray);
        System.out.println(result);
    }


}
