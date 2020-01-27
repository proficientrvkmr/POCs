package com.java.practice.inheritance;

public class ParentCannotAccessChildStuff {

    public static void main(String[] args) {
        Parent p = new Child();
        p.printMe();
        System.out.println(p.a);    // prints 20;

        /* Parent Cannot Access Child Stuff.
        Parent can't access Child stuff other than override common methods. */
//         p.getChild();
//         System.out.println(p.b);

    }

    static class Parent {
        int a = 20;

        public void printMe() {
            System.out.println("Parent.printMe()");
        }

        public void getParent() {
            System.out.println("PARENT.getParent()");
        }
    }

    static class Child extends Parent {

        int a = 20;
        int b = 30;

        public void printMe() {
            System.out.println("Child.printMe()");
        }

        public void getChild() {
            System.out.println("Child.getChild()");
        }
    }
}
