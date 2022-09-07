package com.improve.javaBasics;

public class InheritanceLearner {
    public static void caller(Parent parent) throws Exception{
        parent.methoda();
    }

    public static void main(String[] args) throws Exception{
        Child child = new Child();
        InheritanceLearner.caller(child);
    }
}
