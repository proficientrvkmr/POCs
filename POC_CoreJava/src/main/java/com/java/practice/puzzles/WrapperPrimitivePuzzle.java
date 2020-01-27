package com.java.practice.puzzles;

public class WrapperPrimitivePuzzle {

    public static void main(String[] args) {
        WrapperPrimitivePuzzle obj = new WrapperPrimitivePuzzle();
        obj.increment(123);
    }

    public void increment(Integer i) {
        System.out.println(++i);
    }

    public void increment(float f) {
        System.out.println(++f);
    }
}
