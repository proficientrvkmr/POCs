package com.java.practice.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Example 1:
 * <p>
 * The list before flattening :
 * [ [2, 3, 5], [7, 11, 13], [17, 19, 23] ]
 * <p>
 * The list has 2 levels and consists of 3 small lists.
 * <p>
 * After Flattening, it gets transformed into “one level” structure as shown :
 * [ 2, 3, 5, 7, 11, 13, 17, 19, 23 ]
 */
public class FlatMapExample2 {

    public static void main(String[] args) {
        System.out.println("Example 1: ");
        example1();

        System.out.println();
        System.out.println("Example 2: ");
        example2();
    }

    private static void example2() {
        List<Integer> arr1 = Arrays.asList(2, 1, 3, 5);
        List<Integer> arr2 = Arrays.asList(21, 11, 13, 15);
        List<Integer> arr3 = Arrays.asList(24, 14, 34, 45);

        List<List<List<Integer>>> threeD_List =
                Arrays.asList(Arrays.asList(arr1, arr2), Arrays.asList(arr2, arr3), Arrays.asList(arr1, arr3));

        System.out.println("The Structure before flattening is : " + threeD_List);

        // flatMap UpTo 1 depth level
        List<List<Integer>> oneDepthList = threeD_List.stream()
                .flatMap(intList -> intList.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("The Structure after flattening at 1 depth level is : " + oneDepthList);

        // flatMap UpTo 0 depth level
        List<Integer> zeroDepthList = threeD_List.stream()
                .flatMap(intList -> intList.stream())
                .flatMap(intList -> intList.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("The Structure after flattening at 0 depth level is : " + zeroDepthList);
    }

    private static void example1() {
        // Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11, 13);
        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);
        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

        System.out.println("The Structure before flattening is : " + listOfListofInts);

        // Using flatMap for transformation and flattening.
        List<Integer> listofInts = listOfListofInts.stream()
                .flatMap(intList -> intList.stream())
                .sorted(Comparator.reverseOrder())  //Sort in descending order.
                .collect(Collectors.toList());

        System.out.println("The Structure after flattening is : " + listofInts);
    }
}
