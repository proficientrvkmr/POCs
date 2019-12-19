package com.java.practice.inheritance;

public class NonStaticReferenceCalledFromDerived {

    public static void main(String[] args) {
        Base b = new Derived();
        b.show();   // print: Derived::show() called
    }

    static class Base {
        public void show() {
            System.out.println("Base::show() called");
        }
    }

    static class Derived extends Base {
        public void show() {
            System.out.println("Derived::show() called");
        }
    }
}

