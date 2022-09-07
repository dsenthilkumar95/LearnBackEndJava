package com.improve.javaBasics;

public class Parent implements Cloneable{
    public static void staticMethod() {
        System.out.println("Static method in parent");
    }
    protected void methoda() throws Exception {
        System.out.println("I am method A of parent");
    }

    protected void callMethodA() throws Exception {
        methoda();
    }

    protected Parent clone() throws CloneNotSupportedException {
        return (Parent) super.clone();
    }
}
