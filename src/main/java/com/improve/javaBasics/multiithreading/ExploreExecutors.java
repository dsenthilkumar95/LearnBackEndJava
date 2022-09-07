package com.improve.javaBasics.multiithreading;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ExploreExecutors {
    Callable<Integer> callable = () -> {
        try {
            Thread.sleep(20000);
        } catch (Exception e) {

        }
        return 1;
    };
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public void invokeAllInExecutorService() throws InterruptedException {
        // Invoke all will wait for all the callables to return a value and then result to all the callables are returned.
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futureList = executorService.invokeAll(Arrays.asList(callable, callable, callable, callable));
        futureList.forEach(f -> {
            Date date = new Date();
            System.out.println(formatter.format(date));
            while(!f.isDone()){}
            date = new Date();
            System.out.println(formatter.format(date));
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    public void submitInExecutorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<Integer> integerFuture = executorService.submit(callable);
        Date date = new Date();
        System.out.println(formatter.format(date));
        while(!integerFuture.isDone()){}
        date = new Date();
        System.out.println(formatter.format(date));
    }

    public static void main(String[] args) throws Exception{
        ExploreExecutors exploreExecutors = new ExploreExecutors();
//        exploreExecutors.invokeAllInExecutorService();
        exploreExecutors.submitInExecutorService();
    }

}
