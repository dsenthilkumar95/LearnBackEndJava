package com.improve.javaBasics;

import java.util.Calendar;

public class ThreadsJava extends Thread{
    public static String sample = "sample";
    public void objectLevelLocking() {
        ThreadEmployee e = new ThreadEmployee();
        Thread t1 = new Thread1(e);
        Thread t2 = new Thread2(e);
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        t2.start();
    }
    public void classLevelLocking() {
        Thread t3 = new Thread3();
        Thread t4 = new Thread4();
        t3.start();
        t4.start();
    }
    public void waitAndNotify() {
        ThreadEmployee e = new ThreadEmployee();
        new Thread(){
            public void run(){
                e.waitmethod();
            }
        }.start();

        new Thread(){
            public void run(){
                e.notifymethod();
            }
        }.start();
    }
    public void joiningThreads() {
        ThreadEmployee e = new ThreadEmployee();
        Thread t5 = new Thread1(e);
        t5.start();
        try {
            t5.join(1000);
            System.out.println("Time after join " + Calendar.getInstance().getTime());
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
    public static void main(String[] args){
        ThreadsJava threadsJava = new ThreadsJava();
        threadsJava.objectLevelLocking();
    }
}

class Thread1 extends Thread{
    private ThreadEmployee e;
    public Thread1(ThreadEmployee e){
        this.e = e;
    }
    @Override
    public void run(){
        System.out.println("Time before method 1 " + Calendar.getInstance().getTime());
        e.method1();
        System.out.println("Time after method 1 " + Calendar.getInstance().getTime());
    }
}

class Thread2 extends Thread{
    private ThreadEmployee e;
    public Thread2(ThreadEmployee e){
        this.e = e;
    }
    @Override
    public void run(){
        e.method2();
    }
}

class Thread3 extends Thread{
    @Override
    public void run(){
        ThreadEmployee.staticSync1();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

class Thread4 extends Thread{
    @Override
    public void run(){
        ThreadEmployee.staticSync2();
    }
}
