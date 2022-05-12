package com.improve.javaBasics;

public class Child extends Parent{
    @Override
    protected void methoda() {
        System.out.println("I am method A of child");
    }
    public static void main(String[] args) {
        Child child = new Child();
        child.callMethodA();

    }
}
