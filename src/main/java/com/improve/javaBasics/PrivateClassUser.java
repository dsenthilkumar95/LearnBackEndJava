package com.improve.javaBasics;

public class PrivateClassUser {
    public static void main(String[] args) {
        PrivateClassSample privateClassSample = new PrivateClassSample();
        System.out.println(privateClassSample.getNewPrivateGuy().count());
    }
}
