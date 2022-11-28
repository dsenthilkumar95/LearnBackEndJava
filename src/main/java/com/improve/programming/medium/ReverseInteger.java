package com.improve.programming.medium;

public class ReverseInteger {
    public int reverse(int x) {
        int out=0;
        int maxval = Integer.MAX_VALUE/10;
        int minval = Integer.MIN_VALUE/10;
        while(x!=0) {
            if(out < maxval && out > minval) {
                out *= 10;
                out += x%10;
                x = x/10;
            } else if(out == maxval){
                if(x<=7){
                    out *= 10;
                    out += x;
                    return out;
                } else {
                    return 0;
                }
            } else if (out == minval) {
                if(x>=-8) {
                    out *= 10;
                    out += x;
                    return out;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(1463847412));

    }
}
