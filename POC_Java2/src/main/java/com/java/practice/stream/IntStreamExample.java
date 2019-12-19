package com.java.practice.stream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamExample {

    public static void main(String[] args) {
        getStatsOfList();
        searchKeyInList();

        convertIntArrayToStream();
        convertIntArrayToIntegerList();
        totalSumOfIntArray();
    }

    private static void totalSumOfIntArray() {
        System.out.println("Example totalSumOfIntArray : ");

        int[] integerList = {21, 32, 43, 55, 42, 33, 23, 23, 35, 25, 13};
        int totalSum = IntStream.of(integerList).sum();
        System.out.println("totalSum: " + totalSum);
    }

    private static void convertIntArrayToIntegerList() {
        System.out.println("Example convertIntArrayToIntegerList : ");

        int[] integerList = {21, 32, 43, 55, 42, 33, 23, 23, 35, 25, 13};
        List<Integer> intList = IntStream.of(integerList).boxed().collect(Collectors.toList());
        System.out.println(intList);

        // Vice - Versa
        int[] intArray = intList.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Vice-Versa: ");
        for (int a : intArray) {
            System.out.println(a);
        }
    }

    private static void convertIntArrayToStream() {
        System.out.println("Example convertIntArrayToStream : ");

        int[] integerList = {21, 32, 43, 55, 42, 33, 23, 23, 35, 25, 13};
        IntStream.of(integerList).distinct().forEach(System.out::println);


        // Vice - Versa
        // Convert stream into array.
        System.out.println("\n Sorted Array :");
        int[] sortedList = IntStream.of(integerList).distinct().sorted().toArray();
        for (int i : sortedList) {
            System.out.println(i);
        }
    }

    private static void searchKeyInList() {
        System.out.println("Example 2: ");

        int key = 26;
        int[] integerList = {21, 32, 43, 55, 42, 33, 23, 23, 35, 25, 13};
        boolean isKeyExist = IntStream.of(integerList).anyMatch(k -> k == key);

        if (isKeyExist)
            System.out.println("Yes, Key Found");
        else
            System.out.println("No, Key Not Found");
    }

    private static void getStatsOfList() {
        System.out.println("Example 1: ");

        int[] integerList = {21, 32, 43, 55, 42, 33, 23, 23, 35, 25, 13};
        IntSummaryStatistics intSummaryStatistics = IntStream.of(integerList).summaryStatistics();

        System.out.println("Sum: " + intSummaryStatistics.getSum());
        System.out.println("Average: " + intSummaryStatistics.getAverage());
        System.out.println("Count: " + intSummaryStatistics.getCount());
        System.out.println("Max: " + intSummaryStatistics.getMax());
        System.out.println("Min: " + intSummaryStatistics.getMin());
    }
}
