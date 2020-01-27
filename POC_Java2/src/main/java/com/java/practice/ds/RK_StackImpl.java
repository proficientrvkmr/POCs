package com.java.practice.ds;

import java.util.Stack;

public class RK_StackImpl {

    public static void main(String[] args) throws Exception {
        CustomStack customStack = new CustomStack(10);
        customStack.push(2);
        customStack.push(6);
        customStack.push(7);
        customStack.push(5);
        System.out.println("CustomStack : " + customStack.pop());
        System.out.println("CustomStack : " + customStack.pop());
        System.out.println("CustomStack : " + customStack.pop());
        System.out.println("CustomStack : " + customStack.pop());
        //System.out.println("CustomStack : "+customStack.pop());

        Stack<Integer> originalStack = new Stack<>();
        originalStack.push(2);
        originalStack.push(6);
        originalStack.push(7);
        originalStack.push(5);
        System.out.println("OriginalStack : " + originalStack.pop());
        System.out.println("OriginalStack : " + originalStack.pop());
        System.out.println("OriginalStack : " + originalStack.pop());
        System.out.println("OriginalStack : " + originalStack.pop());
    }

    static class CustomStack {
        private Object[] stack;
        private int top = -1;
        private int size = 0;

        CustomStack(int size) {
            this.size = size;
            this.stack = new Object[this.size];
            this.top = -1;
        }

        public void push(Object object) throws Exception {
            if (!isFull()) {
                top++;
                stack[top] = object;
            } else {
                throw new Exception("Stack is overflow. No more space available.");
            }
        }

        private boolean isFull() {
            return (top == (this.size - 1));
        }

        public Object pop() throws Exception {
            if (!isEmpty()) {
                Object item = stack[top];
                top--;
                return item;
            } else {
                throw new Exception("Stack is underflow. No items available.");
            }
        }

        private boolean isEmpty() {
            return top == -1;
        }
    }

}

