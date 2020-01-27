package com.java.practice.collection;

import java.util.Arrays;
import java.util.List;

public class SwapAList {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Abc", "Reni", "ttttt", "dffff");
        swap(list, 0, 3);
        System.out.println(list);

    }

    private static void swap(List<String> list, int i, int j) {
        String obj1 = list.get(i);
        String obj2 = list.get(j);

        list.set(i, obj2);
        list.set(j, obj1);
    }
}
