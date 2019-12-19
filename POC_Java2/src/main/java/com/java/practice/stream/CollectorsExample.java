package com.java.practice.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CollectorsExample {

    public static void main(String[] args) {
        collectorsToMap();
        collectorsToList();
        collectorsToSet();

        collectorsToCollection();
        collectorsCollectingAndThen();
        collectorsPartitioningBy();
        collectorsGroupingBy();
        collectorsJoining();
    }

    private static void collectorsJoining() {
        System.out.println("\n Example Collectors.joining(): ");
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        String result = givenList.stream()
                .collect(joining());

        System.out.println(result);
    }

    private static void collectorsGroupingBy() {
        System.out.println("\n Example Collectors.groupingBy(): ");
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd", "bb", "dr");
        Map<Integer, Set<String>> result = givenList.stream()
                .collect(groupingBy(String::length, Collectors.toSet()));
        System.out.println(result);

        List<Integer> intList = Arrays.asList(1, 4, 5, 6, 6, 7, 7, 7, 8, 3);
        Map<Integer, Set<Integer>> intResult = intList.stream()
                .collect(groupingBy(i -> i, Collectors.toSet()));
        System.out.println(intResult);
    }

    private static void collectorsPartitioningBy() {
        System.out.println("\n Example Collectors.partitioningBy(): ");
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

        Map<Boolean, List<String>> result = givenList.stream()
                .collect(partitioningBy(s -> s.charAt(0) == 'a'));
        System.out.println(result);
    }

    /**
     * Collect first those element in any collection type, then perform finishing touch on it.
     */
    private static void collectorsCollectingAndThen() {
        System.out.println("\n Example Collectors.collectingAndThen(): ");
        List<String> givenList = Arrays.asList("a", "dd", "cc", "bb");
        List<String> result = givenList.stream()
                .collect(collectingAndThen(toList(), newList -> newList.stream().sorted().collect(toList())));

        System.out.println(result);
    }

    private static void collectorsToCollection() {
        System.out.println("\n Example Collectors.toCollection(): ");
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        List<String> result = new LinkedList<>(givenList);

        System.out.println(result);
    }

    private static void collectorsToSet() {
        System.out.println("\n Example Collectors.toSet(): ");
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd", "a");
        Set<String> result = givenList.stream().collect(toSet());

        System.out.println(result);
    }

    private static void collectorsToList() {
        System.out.println("\n Example Collectors.toList(): ");
        String[] givenList = {"a", "bb", "ccc", "dd"};
        List<String> result = Stream.of(givenList).collect(toList());

        System.out.println(result);
    }

    private static void collectorsToMap() {
        System.out.println("\n Example Collectors.toMap(): ");
        Map<String, String> stringMap =
                Stream.of(new String[][]{
                        {"g", "Geeks"},
                        {"f", "For"},
                        {"m", "Me"},
                        {"b", "Memem"},
                })
                        .collect(Collectors.toMap(p -> p[0], p -> p[1]));

        System.out.println(stringMap);
    }
}
