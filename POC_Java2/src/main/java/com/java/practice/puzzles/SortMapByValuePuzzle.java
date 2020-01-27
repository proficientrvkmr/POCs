package com.java.practice.puzzles;

import java.util.HashMap;
import java.util.Map;

public class SortMapByValuePuzzle {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 3);
        map.put("b", 2);
        map.put("d", 1);
        map.put("c", 4);

        for (Map.Entry<String, Integer> e : map.entrySet()) {

        }
        System.out.println("EntrySet: " + map.entrySet());

        sortMapByValue(map);
        sortMapByKey(map);
    }

    private static void sortMapByKey(HashMap<String, Integer> map) {
        System.out.println("\nSort Map By Key: ");

        map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e));
    }

    private static void sortMapByValue(HashMap<String, Integer> map) {
        System.out.println("\nSort Map By Value: ");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.println(e));
    }
}
