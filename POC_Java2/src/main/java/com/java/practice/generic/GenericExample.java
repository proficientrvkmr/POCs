package com.java.practice.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericExample<T> {

    public static void main(String[] args) {
        //List of grand parents
        List<GrandParent> grandParents = new ArrayList<>();
        grandParents.add(new GrandParent());

        playWithGrandChildren(grandParents); // grandParents can playWithGrandChildren.
        playWithChildren(grandParents); // grandParents can playWithGrandChildren.
        playWithGrandParents(grandParents); // grandParents can playWithGrandParents. Both are same.
        playWithParents(grandParents); // grandParents can playWithGrandParents. Both are same.

        //List of parents
        List<Parent> parents = new ArrayList<>();
        parents.add(new Parent());
        playWithGrandChildren(parents); // parents can also playWithGrandChildren.
        playWithChildren(parents); // parents can also playWithGrandChildren.
        playWithGrandParents(parents); // parents can also playWithGrandParents.
        playWithParents(grandParents);

        //List of children
        List<Child> children = new ArrayList<>();
        children.add(new Child());
        playWithGrandChildren(children); // children can playWithGrandChildren. Both are same.
        playWithGrandParents(children); // children can playWithGrandParents.

        //List of grand children
        List<GrandChild> grandChildren = new ArrayList<>();
        grandChildren.add(new GrandChild());
//        playWithChildren(grandChildren); // Incompatible Types, Compile error
        playWithGrandParents(grandParents); // grandChildren can playWithGrandParents.

        List<Number> doubles = Arrays.asList(2, 1.5d, 2d, 3d);
        System.out.println(sum(doubles));
    }

    //Method will accept
    private static Number sum(List<? extends Number> numbers) {
        double s = 0.0;
        for (Number n : numbers)
            s += n.doubleValue();
        return s;
    }

    // Here list 'playGroup' can't accept above the Child Type.
    // It is lower bound wildcard example.
    public static void playWithGrandChildren(List<? super GrandChild> playGroup) {

        System.out.println("Playing With GrandChildren :: " + playGroup);
    }

    public static void playWithChildren(List<? super Child> playGroup) {

        System.out.println("Playing With Children :: " + playGroup);
    }

    public static void playWithParents(List<? super Parent> playGroup) {
        System.out.println("Playing With Parent :: " + playGroup);
    }

    public static void playWithGrandParents(List<? extends GrandParent> playGroup) {
//        playGroup.add(new Parent());
//        playGroup.add(new Child());
//        playGroup.add(new GrandParent());
        System.out.println("Playing With GrandParents :: " + playGroup);
    }
}

class GrandParent {

}

class Parent extends GrandParent {

}

class Child extends Parent {

}

class GrandChild extends Child {

}
