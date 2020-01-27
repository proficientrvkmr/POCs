package com.java.practice.ds;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Array based Implementation of Queue.
 */
public class RK_QueueImpl_1 {

    public static void main(String[] args) throws Exception {
        ArrayQueue customQueue = new ArrayQueue(4);
        customQueue.addItem(2);
        customQueue.addItem(6);
        customQueue.addItem(7);
        customQueue.addItem(5);
//        customQueue.addItem(55);
        System.out.println("ArrayQueue : " + customQueue.getItem());
        System.out.println("ArrayQueue : " + customQueue.getItem());
        System.out.println("ArrayQueue : " + customQueue.getItem());
        System.out.println("ArrayQueue : " + customQueue.getItem());
        System.out.println("ArrayQueue : " + customQueue.getItem());

        ArrayBlockingQueue<Integer> originalQueue = new ArrayBlockingQueue<>(5);
        originalQueue.add(2);
        originalQueue.add(6);
        originalQueue.add(7);
        originalQueue.add(5);
        System.out.println("originalQueue : " + originalQueue.take());
        System.out.println("originalQueue : " + originalQueue.take());
        System.out.println("originalQueue : " + originalQueue.take());
        System.out.println("originalQueue : " + originalQueue.take());
    }

    static class ArrayQueue {
        private Object[] queue;
        private int front, rear, capacity;//, currentSize;

        ArrayQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new Object[this.capacity];
            this.front = 0;
            this.rear = 0;
//            this.rear = capacity - 1;
//            this.currentSize = 0;
        }

        public void addItem(Object object) throws Exception {
            if (!isFull()) {
                //this.rear = (this.rear + 1) % this.capacity;
                queue[this.rear] = object;
                this.rear++;
//                currentSize++;
            } else {
                throw new Exception("Queue is overflow. No more space available.");
            }
        }

        private boolean isFull() {
            return this.rear == this.capacity;
        }

        public Object getItem() throws Exception {
            if (!isEmpty()) {
                Object item = queue[front];
                queue[front] = null;
//                this.front = (this.front + 1) % this.capacity;
                this.front++;
                return item;
            } else {
                resetQueue();
                throw new Exception("Stack is underflow. No items available.");
            }
        }

        private void resetQueue() {
            this.queue = new Object[this.capacity];
            this.front = 0;
            this.rear = 0;
        }

        private boolean isEmpty() {
            return this.front == this.rear;
        }

    }
}

