package com.java.practice.puzzles;

public class ExceptionHandlingPuzzle {

    public static void main(String args[]) {

        try {
            throw new Derived();

        } catch (Base b) {
            System.out.println("Base");

        }
        /* Compile Time Error: Base class has already caught this.
        catch (Derived d) {
            System.out.println("Drived");
        }*/

    }

    //filename Main.java
    static class Base extends Exception {
    }

    static class Derived extends Base {
    }

}
