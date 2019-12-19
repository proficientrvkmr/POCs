package com.java.practice.inheritance;

interface AmazingInterface {
    public static final int value = 1;

    public void printMe();
}

abstract class AbstractClass implements AmazingInterface {
    public void printMe() {
        System.out.println("I'm abstract class");
    }
}

public class AbstractClassImpl {
    public static void main(String[] args) {
//        AbstractClass abs = new AbstractClass();
//        abs.printMe();
    }
}
