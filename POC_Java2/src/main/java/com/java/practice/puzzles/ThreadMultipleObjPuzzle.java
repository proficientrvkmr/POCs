package com.java.practice.puzzles;

public class ThreadMultipleObjPuzzle {

    public static void main(String[] args) throws InterruptedException {
        Emp e1 = new Emp("Ravi", 23);
        Emp e2 = new Emp("Ram", 21);

        synchronized (e1) {
            System.out.println(e1.getAge() + " : " + e1.getName());
            e2.wait();
        }
    }

    static class Emp {
        private String name;
        private int age;

        public Emp(String name, int age) {
            this.name = name;
            this.age = age;
        }

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
