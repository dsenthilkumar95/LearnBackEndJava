package com.improve.javaBasics;

public interface InterA {

    default void common(){
        System.out.println("I am from InterA");
    }
}
