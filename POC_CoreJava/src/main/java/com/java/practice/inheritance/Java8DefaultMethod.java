package com.java.practice.inheritance;

//how to fix the below error ?
public class Java8DefaultMethod implements PI1, PI2 {
    public static void main(String[] args) {
        Java8DefaultMethod obj = new Java8DefaultMethod();
        obj.show();
    }

//    @Override
//    public void show() {
//        PI1.super.show();
//    }
}

// Interface 1
interface PI1 {
    default void show() {
        System.out.println("Default PI1");
    }
}

// Interface 2
interface PI2 {
    default void show() {
        System.out.println("Default PI2");
    }
}