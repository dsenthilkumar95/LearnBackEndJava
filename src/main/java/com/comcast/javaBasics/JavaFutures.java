package com.comcast.javaBasics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaFutures {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(7);
        executorService.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                System.out.println("Got a exception from callable");
            }
            return 1;
        });

    }
}
