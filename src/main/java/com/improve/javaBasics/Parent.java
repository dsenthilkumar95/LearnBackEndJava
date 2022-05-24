package com.improve.javaBasics;

public class Parent {
    public static void staticMethod() {
        System.out.println("Static method in parent");
    }
    protected void methoda() {
        System.out.println("I am method A of parent");
    }

    protected void callMethodA() {
        methoda();
    }
}
