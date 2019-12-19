package com.java.practice.concurrency;

public class WaitNotifyExample {

    public static void main(String[] args) throws InterruptedException {
        PC pc = new PC();

        Thread t1 = new Thread(pc::produce);
        t1.start();
        Thread t2 = new Thread(pc::consume);
        t2.start();

        // t1 finishes before t2
        t1.join();
        t2.join();
    }

    // PC (Produce Consumer) class with produce() and
    // consume() methods.
    static class PC {

        public void produce() {
            synchronized (this) {
                System.out.println("Task Produced.");

                // releases the lock on shared resource
                try {
                    System.out.println("Producer-Thread: going into WAIT State.");
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Producer-Thread: come back to RUNNABLE State from WAIT State.");
                }
                // and waits till some other method invokes notify().
                System.out.println("Producer-Thread: Resumed");
            }
        }

        public void consume() {
            try {
                System.out.println("Consumer-Thread: going to sleep for 1 sec.");
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("Consumer-Thread: is sleeping. Why you are disturbing him ?");
            }
            synchronized (this) {
                System.out.println("Task Consumed.");
                // notifies the produce thread that it
                // can wake up.

                notify();
                try {
                    System.out.println("Consumer-Thread: going to sleep for 2 sec.");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Consumer-Thread: is sleeping. Why you are disturbing him?");
                }
            }
        }
    }
}

