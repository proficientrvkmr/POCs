package com.java.practice.puzzles;

import java.util.HashMap;

public class HashMapNeedWhyOverride {

    public static void main(String[] args) {
        HashMap<Employee, Integer> map = new HashMap<>();
        Employee e1 = new Employee("Ravi");
        Employee e2 = new Employee("Ravi");

        System.out.println(e1.equals(e2));

        System.out.println("Before = e1.hashCode(): " + e1.hashCode());
        System.out.println("Before = e2.hashCode(): " + e2.hashCode());

        // Employee, Salary
        map.put(e1, 500000);
        map.put(e2, 5550000);

        System.out.println(map.size());
        System.out.println(map.get(e1));
    }

    static class Employee {
        private String name;

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return this.name.equals(((Employee) obj).name);
        }
    }

}
