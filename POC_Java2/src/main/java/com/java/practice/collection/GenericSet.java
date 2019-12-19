package com.java.practice.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class GenericSet {

    public static void main(String[] args) {
//        problem1();   // Gives ClassCastException
        problem2();

    }

    private static void problem2() {
        System.out.println("\nProblem 2: ");
        Set set = new HashSet();
        set.add("3");
        set.add(2);
        set.add("4");

        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static void problem1() {
        System.out.println("\nProblem 1: ");
        Set set = new TreeSet();

        set.add("3");
        set.add(2);
        set.add("1");

        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
