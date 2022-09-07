package com.improve.javaBasics.bitwise;

public class ExploreBitwise {
    public void exploreSignedOperations() {
        System.out.println("Signed Operations");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Signed >> 1 operation on " + String.valueOf(10) + " is " + String.valueOf(10>>1));
        System.out.println("Signed >> 1 operation on " + String.valueOf(11) + " is " + String.valueOf(11>>1));
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Signed << 1 operation on " + String.valueOf(6) + " is " + String.valueOf(6<<1));
        System.out.println("Signed << 1 operation on " + String.valueOf(Integer.MAX_VALUE) + " is " + String.valueOf(Integer.MAX_VALUE<<1));
        System.out.println((Integer.MAX_VALUE));
        System.out.println("4294967295");
        System.out.println((Integer.MAX_VALUE+1)/2);
        System.out.println(-2/2);
        System.out.println(~-4);
        System.out.println(~3);
    }

    public static void main(String[] args) {
        ExploreBitwise exploreBitwise = new ExploreBitwise();
        exploreBitwise.exploreSignedOperations();
    }
}
