package com.improve.javaBasics;

public class ThreadEmployee {
    private int id;
    private String name;

    public static synchronized void staticSync1(){
        System.out.println("staticSync1 is called");
    }

    public static synchronized void staticSync2(){
        System.out.println("staticSync2 is called");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized void method1(){
        System.out.println("Method 1 is executed");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2(){
        System.out.println("Method 2 is executed");
    }

    public synchronized void waitmethod(){
        try {
            System.out.println("I am waiting");
            wait();
            System.out.println("I am fine now");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void notifymethod(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
