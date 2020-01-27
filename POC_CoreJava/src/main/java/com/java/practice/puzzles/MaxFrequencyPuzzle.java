package com.java.practice.puzzles;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * In given array, Find that number who have maximum frequency.
 */
public class MaxFrequencyPuzzle {

    public static void main(String[] str) {
        int[] arr = {4, 5, 2, 2, 8, 8, 1, 1, 9, 9, 9, 4, 4, 4, 4};

        sachinWay(arr);
        myWay(arr);
    }

    private static void myWay(int[] arr) {
        System.out.println("\nMy Ways :- ");

        List<Integer> intList = IntStream.of(arr).boxed().collect(Collectors.toList());

        intList.stream()
                .distinct()
                .collect(Collectors.toMap(key -> key, num -> Collections.frequency(intList, num)))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(1)
                .forEach(e -> System.out.println(e));
    }

    private static void sachinWay(int[] arr) {
        System.out.println("Sachin Ways :- ");

        int count = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            count = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }

            }
            if (!map.containsKey(arr[i]) && count > max) {
                max = count;
                map.put(arr[i], count);
            }
        }

        System.out.println(map);
    }
}
