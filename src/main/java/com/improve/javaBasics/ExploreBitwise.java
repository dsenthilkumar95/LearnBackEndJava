package com.improve.javaBasics;

public class ExploreBitwise {
    public void exploreSignedOperations() {
        System.out.println("Signed Operations");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Signed >> operation on " + String.valueOf(10) + " is " + String.valueOf(10>>1));
        System.out.println("Signed >> operation on " + String.valueOf(11) + " is " + String.valueOf(11>>1));
        System.out.println("--------------------------------------------------------------------------");

    }

    public static void main(String[] args) {
        ExploreBitwise exploreBitwise = new ExploreBitwise();
        exploreBitwise.exploreSignedOperations();
    }
}
