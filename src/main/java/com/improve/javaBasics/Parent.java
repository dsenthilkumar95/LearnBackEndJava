package com.improve.javaBasics;

public class Parent {
    protected void methoda() {
        System.out.println("I am method A of parent");
    }

    protected void callMethodA() {
        methoda();
    }
}
