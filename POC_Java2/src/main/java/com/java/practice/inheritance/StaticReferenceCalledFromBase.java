package com.java.practice.inheritance;

public class StaticReferenceCalledFromBase {

    public static void main(String[] args) {
        Base b = new Derived();
        b.show(); // print: Base::show() called
    }


    static class Base {
        public static void show() {
            System.out.println("Base::show() called");
        }
    }

    static class Derived extends Base {
        public static void show() {
            System.out.println("Derived::show() called");
        }
    }
}
