package com.java.practice.puzzles;

/**
 * HCL
 */
public class MethodOverLoad {

    public static void main(String[] args) {
        MethodOverLoad temp = new MethodOverLoad();
        temp.printObj("abc");
        temp.method();
        temp.printNum(1);
    }

    public void printObj(String str) {
        System.out.println("Matched String type arg");
    }

    public void printObj(Object obj) {
        System.out.println("Matched Object type arg");
    }

    private final void method() {
        System.out.println("private final method()");
    }

    public void printNum(Integer i) {
        System.out.println(i);
    }

    public void printNum(float f) {
        System.out.println(f);
    }
}
