package com.java.practice.puzzles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReadOnlyListSetMap {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Delhi", "Agra", "Mumbai", "Kolkata");
        List<String> readOnlyList = Collections.unmodifiableList(list);

        System.out.println(readOnlyList);

        readOnlyList.add("2334");   // UnsupportedOperationException
    }
}
