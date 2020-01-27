package com.java.practice.collection;

import java.util.HashMap;

/**
 * @author ravi.kushwah
 */
public class HashCodeOverrideEqualsNot {

    public static void main(String[] args) {
        HashMap<Student, String> map = new HashMap<>();
        Student s1 = new Student("Ram", 20);
        Student s2 = new Student("Ram", 20);

        System.out.println("s1.hashCode(): " + s1.hashCode());
        System.out.println("s2.hashCode(): " + s2.hashCode());

        map.put(s1, "First");
        map.put(s2, "Second");

        System.out.println(map.size());
        System.out.println(map.get(s1));
        System.out.println(map.get(s2));

        Student s3 = new Student("Ram", 20);
        System.out.println(map.get(s3));
    }

    static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int hashCode() {
            return 13;
        }


        /**
         * comes in picture to check whether object is for update the value
         * or insert it as new object.
         */
//        @Override
//        public boolean equals(Object obj) {
//            return super.equals(obj);  // default
////            return this.name.equalsIgnoreCase(((Student) obj).name);
//        }
        @Override
        public String toString() {
            return "[" + this.name + "," + this.age + "]";
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
