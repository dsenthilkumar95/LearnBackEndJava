package com.improve.javaBasics.multiithreading;

import java.util.Arrays;
import java.util.List;

public class SimpleObjectWaitNotify {
    public void write(String stringToWrite, Object obj) {
        synchronized (obj) {
            System.out.println("writing to file done");
        }
    }

    public String read(Object obj) {
        synchronized (obj) {
            try {
                wait();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("reading from file done");
            notifyAll();
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleObjectWaitNotify simpleObjectWaitNotify = new SimpleObjectWaitNotify();
        Object obj = new Object();
        Runnable t1 = () -> {simpleObjectWaitNotify.write("writing", obj);};
        Runnable t2 = () -> {simpleObjectWaitNotify.read(obj);};
        Thread ti1 = new Thread(t1);
        ti1.setPriority(Thread.MAX_PRIORITY);
        Thread ti2 = new Thread(t2);
        ti2.setPriority(Thread.MIN_PRIORITY);
        Thread ti3 = new Thread(t2);
        ti3.setPriority(Thread.MIN_PRIORITY);
        Thread ti4 = new Thread(t2);
        ti4.setPriority(Thread.MIN_PRIORITY);
        Thread ti5 = new Thread(t2);
        ti5.setPriority(Thread.MIN_PRIORITY);
        ti2.start();
        Thread.sleep(1000);
        List<Thread> threadList = Arrays.asList(ti1, ti3, ti4, ti5);
        threadList.forEach(t -> t.start());
    }
}
