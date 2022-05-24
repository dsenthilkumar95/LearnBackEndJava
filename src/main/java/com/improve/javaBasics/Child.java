package com.improve.javaBasics;

public class Child extends Parent{
    public static void staticMethod() {
        System.out.println("Static method in child");
    }
    @Override
    protected void methoda() {
        System.out.println("I am method A of child");
    }
    public static void main(String[] args) {
        Child child = new Child();
        child.methoda();
        child.callMethodA();
        Parent parent = child;
        parent.methoda();
        Child.staticMethod();
    }
}
