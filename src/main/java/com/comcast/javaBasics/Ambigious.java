package com.comcast.javaBasics;

public class Ambigious implements InterB,InterA {

    public void common() {
        InterB.super.common();
    }
}
