package com.improve.programming.easy;

public class SquareRoot {
    public int mySqrt(int x) {
        if(x <= 0) {
            return 0;
        }
        int l=1;
        int r=x;
        int out=x;
        while(l<r) {
            int mid = l + (r-l)/2;
            if(mid > x/mid) {
                r = mid;
            } else {
                out = mid;
                l = mid + 1;
            }
        }
        return out;
    }
}
