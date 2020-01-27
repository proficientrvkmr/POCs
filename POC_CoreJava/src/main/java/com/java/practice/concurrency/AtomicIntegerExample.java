package com.java.practice.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicIntegerExample {
    public static void main(String[] args) {

        AtomicInteger atomicInt = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ThreadPoolExecutor tp = (ThreadPoolExecutor) executor;

        IntStream.range(0, 1000)
                .forEach(i -> {
                    Runnable task = () ->
                            atomicInt.updateAndGet(n -> n + 2);
                    System.out.println("i: " + i + ", Atomic Int: " + atomicInt.get());

                    // I believe submit a new task is doing by main thread.
                    // 2 child thread are available to execute them.
                    executor.execute(task);
                    System.out.println("Task Added: " + tp.getQueue().size());
                });

        executor.shutdown();
        System.out.println(atomicInt.get());

    }
}
