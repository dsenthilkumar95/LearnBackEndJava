package com.comcast.javaBasics;

public interface InterB {

    default void common(){
        System.out.println("I am from InterB");
    }
}
