package com.improve.javaBasics;

import java.util.concurrent.atomic.AtomicInteger;

public class NonBlockingCollections {
    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger();

        // Automatically initialized to Zero
        System.out.println("Intial value of atomicInteger without initialization -> " + atomicInteger.get());
        atomicInteger.incrementAndGet();

        // applies the function with x value provided and updates the atomicInteger without any side effects
        System.out.println("atomicInteger.accumulateAndGet -> " + atomicInteger.accumulateAndGet(5, (x,y)->{return x*y;}));

        //atomicInteger.compareAndExchangeRelease();
    }
}
