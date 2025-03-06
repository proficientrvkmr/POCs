package com.java.practice.collection;

import java.util.ArrayList;
import java.util.List;

public class CommonStringList {
    public static void main(String[] args) {
        List nonStringList = new ArrayList();
        nonStringList.add("Hello");
        nonStringList.add(1);
        nonStringList.add("!One");
        nonStringList.add("Tw$o");
        nonStringList.add("Thr$ee");

        System.out.println(nonStringList);

        List<String> stringList = nonStringList.stream().map(CommonStringList::getPureString)
                                               .filter(s -> s != null)
                                               .toList();
        System.out.println(stringList);
    }

    private static String getPureString(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            return str.replaceAll("[^a-zA-Z]", "");
        }
        return null;
    }
}
