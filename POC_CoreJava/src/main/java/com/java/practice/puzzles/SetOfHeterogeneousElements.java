package com.java.practice.puzzles;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetOfHeterogeneousElements {
    public static void main(String[] args) {

        hashSetExample();
//        treeSetExample();
    }

    private synchronized static void hashSetExample() {
        Set hashSet = new HashSet();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        hashSet.add(2);
        hashSet.add(1);

        Iterator itr = hashSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    private synchronized static void treeSetExample() {
        Set treeSet = new TreeSet();
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add("c");

        Iterator itr = treeSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
