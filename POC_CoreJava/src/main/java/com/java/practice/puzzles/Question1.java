package com.java.practice.puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Question1 {
    public static void main(String[] args) {
        double number = 0d;
        System.out.println((double) Math.round(number * 100000d) / 100000d);

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("A", 28));
        persons.add(new Person("A", 20));
        persons.add(new Person("B", 29));
        persons.add(new Person("C", 12));
        persons.add(new Person("D", 22));

        Collections.sort(persons, new Comparator<Person>() {

            @Override
            public int compare(Person t1, Person t2) {
                int comp = t1.getFname().compareTo(t2.getFname());

                if (comp != 0) {
                    return comp;
                } else {
                    return t1.getAge() - t2.getAge();
                }

            }

        });
        System.out.println(persons);

//        Collections.sort(persons, Comparator.comparing(Person::getFname)
//                .thenComparing(Person::getAge));

        //  persons.sort(Comparator.comparing(Person::getAge));

//        System.out.println(persons);


    }

    static class Person {

        String fname;

        int age;

        public Person(String fname, int age) {
            this.fname = fname;

            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        @Override
        public String toString() {
            return fname + age;
        }
    }
}
