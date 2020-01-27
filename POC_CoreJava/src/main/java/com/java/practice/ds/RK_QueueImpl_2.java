package com.java.practice.ds;

/**
 * Linked list based Implementation of Queue.
 */
public class RK_QueueImpl_2 {

    public static void main(String[] args) throws Exception {
        LinkedListQueue customQueue = new LinkedListQueue();
        customQueue.addItem(2);
        customQueue.addItem(6);
        customQueue.addItem(7);
        customQueue.addItem(5);

        System.out.println("LinkedListQueue : " + customQueue.getItem());
        System.out.println("LinkedListQueue : " + customQueue.getItem());
        System.out.println("LinkedListQueue : " + customQueue.getItem());
        System.out.println("LinkedListQueue : " + customQueue.getItem());
    }

    static class LinkedListQueue {

        QNode front, rear;

        public void addItem(int value) throws Exception {
            QNode newNode = new QNode(value);

            if (this.rear == null) {
                this.front = this.rear = newNode;
            }

            /**
             * LinkedList creates in this form
             * 5 <-- 7 <-- 6 <-- 2
             */
            this.rear.next = newNode;
            this.rear = newNode;
        }

        public int getItem() throws Exception {
            if (this.front == null)
                return -1;

            QNode item = this.front;
            this.front = this.front.next;

            if (this.front == null)
                this.rear = null;

            return item.data;
        }

        class QNode {
            int data;
            QNode next;

            QNode(int value) {
                this.data = value;
                this.next = null;
            }
        }

    }
}

