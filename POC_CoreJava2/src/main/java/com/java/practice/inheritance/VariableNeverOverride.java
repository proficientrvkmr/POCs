package com.java.practice.inheritance;

public class VariableNeverOverride {

    public static void main(String[] args) {
        ParentClass a = new ChildClass();
        System.out.println(a.X);  // print 10.
        System.out.println(a.getX()); // print 20.
    }

    static class ParentClass {
        public int X = 10;

        public int getX() {
            return this.X;
        }
    }

    static class ChildClass extends ParentClass {
        public int X = 20;

        public int getX() {
            return this.X;
        }
    }
}
