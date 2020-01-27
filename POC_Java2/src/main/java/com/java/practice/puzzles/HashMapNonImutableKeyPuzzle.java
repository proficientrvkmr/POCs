package com.java.practice.puzzles;

import java.util.HashMap;

/**
 * Puzzle 1 :-
 * <p>
 * What if I change any properties after putting it into HashMap.
 * Would it give null definitely, or may be not?
 * Ans:- Return same object.
 * <p>
 * Puzzle 2 :-
 * <p>
 * What would be the result if override the hashcode and equals method of Emp ?
 * Ans:- Return null.
 */
public class HashMapNonImutableKeyPuzzle {

    public static void main(String[] args) {

        HashMap<Employee, Integer> map = new HashMap<>();

        Employee ee1 = new Employee();
        ee1.setAge(12);
        ee1.setName("Amit");
        System.out.println("Hashcode of ee1: " + ee1);
        map.put(ee1, 100000);

        Employee e2 = new Employee();
        e2.setAge(35);
        e2.setName("Ravi");
        System.out.println("Hashcode of e2: " + e2);
        map.put(e2, 5550000);

        System.out.println(map.size());

        System.out.println("Result, Before Modification: " + map.get(ee1));
        // Modifying the properties.
        ee1.setName("Aman");
        ee1.setAge(63);
        System.out.println("Result, After Modification: " + map.get(ee1));

        System.out.println("Hashcode of ee1: " + ee1);
        System.out.println("Hashcode of e2: " + e2);

    }

    static class Employee {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
