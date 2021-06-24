package com.improve.javaBasics;

import org.apache.tomcat.jni.Time;

import java.util.Calendar;
import java.util.Date;

public class JavaThreads extends Thread{
    public static String sample = "sample";
    public static void main(String[] args){
        Employee e = new Employee();
//        Thread t1 = new Thread1(e);
//        Thread t2 = new Thread2(e);
//        t1.start();
//        t2.start();

//        Thread t3 = new Thread3();
//        Thread t4 = new Thread4();
//        t3.start();
//        t4.start();

//        new Thread(){
//            public void run(){
//                e.waitmethod();
//            }
//        }.start();
//
//        new Thread(){
//            public void run(){
//                e.notifymethod();
//            }
//        }.start();

        Thread t5 = new Thread1(e);
        t5.start();
        try {
            t5.join(1000);
            System.out.println("Time after join " + Calendar.getInstance().getTime());
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

    }
}

class Thread1 extends Thread{
    private Employee e;
    public Thread1(Employee e){
        this.e = e;
    }
    @Override
    public void run(){
        e.method1();
        try {
            System.out.println("Time before sleep " + Calendar.getInstance().getTime());
            Thread.sleep(5000);
            System.out.println("Time after sleep " + Calendar.getInstance().getTime());
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

class Thread2 extends Thread{
    private Employee e;
    public Thread2(Employee e){
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
        Employee.staticSync1();
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
        Employee.staticSync2();
    }
}
