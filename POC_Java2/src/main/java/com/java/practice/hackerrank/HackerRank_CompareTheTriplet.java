package com.java.practice.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

/**
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
public class HackerRank_CompareTheTriplet {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> scores = new ArrayList<>();
        int aScore = 0;
        int bScore = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                ++aScore;
            } else if (a.get(i) < b.get(i)) {
                ++bScore;
            }
        }

        long[] ar = {3};

        long sum = LongStream.of(ar).sum();

        scores.add(0, aScore);
        scores.add(1, bScore);
        return scores;
    }

    public static void main(String[] args) throws IOException {

        List<Integer> a = Arrays.asList(2, 3, 4);

        List<Integer> b = Arrays.asList(4, 3, 1);

        List<Integer> result = compareTriplets(a, b);

        System.out.println(result);
    }


}
