package com.java.practice.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumerSolvedProblem {

    public static void main(String[] args) {
        List<Integer> taskQueue = new ArrayList<Integer>();
        int MAX_CAPACITY = 5;
        Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
        Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");
        tProducer.start();
        tConsumer.start();
    }

    static class Producer implements Runnable {

        private final List<Integer> taskQueue;
        private final int MAX_CAPACITY;

        public Producer(List<Integer> sharedQueue, int size) {
            this.taskQueue = sharedQueue;
            this.MAX_CAPACITY = size;
        }

        @Override
        public void run() {
            Random random = new Random();
            for (; ; ) {
                try {
                    synchronized (taskQueue) {
                        while (taskQueue.size() == MAX_CAPACITY) {
                            System.out.println("Queue is full. " + Thread.currentThread().getName() + " is waiting " +
                                    ", size: " + taskQueue.size());
                            taskQueue.wait();
                        }

                        Thread.sleep(100);
                        int newValue = random.nextInt();
                        taskQueue.add(newValue);
                        System.out.println("Produced: " + newValue);
                        taskQueue.notifyAll();
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        private final List<Integer> taskQueue;

        public Consumer(List<Integer> sharedQueue) {
            this.taskQueue = sharedQueue;
        }

        @Override
        public void run() {
            for (; ; ) {
                try {
                    synchronized (taskQueue) {
                        while (taskQueue.isEmpty()) {
                            System.out.println("Queue is empty. " + Thread.currentThread().getName() + " is waiting ," +
                                    " size: " + taskQueue.size());
                            taskQueue.wait();
                        }
                        Thread.sleep(100);
                        int i = taskQueue.remove(0);
                        System.out.println("Consumed: " + i);
                        taskQueue.notifyAll();
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
