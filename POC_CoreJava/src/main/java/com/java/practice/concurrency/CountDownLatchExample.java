package com.java.practice.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String args[])
            throws InterruptedException {
        // Let us create task that is going to
        // wait for four threads before it starts
        CountDownLatch latch = new CountDownLatch(4);

        // Let us create four worker
        // threads and start them.
        MyWorker first = new MyWorker(1000, latch,
                "WORKER-1");
        MyWorker second = new MyWorker(2000, latch,
                "WORKER-2");
        MyWorker third = new MyWorker(3000, latch,
                "WORKER-3");
        MyWorker fourth = new MyWorker(4000, latch,
                "WORKER-4");
        first.start();
        second.start();
        third.start();
        fourth.start();

        // The main task waits for four threads
        latch.await();

        // Main thread has started
        System.out.println(Thread.currentThread().getName() +
                " has finished");
    }
}

// A class to represent threads for which
// the main thread waits.
class MyWorker extends Thread {
    private int delay;
    private CountDownLatch latch;

    public MyWorker(int delay, CountDownLatch latch,
                    String name) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName()
                    + " finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
