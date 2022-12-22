package com.improve.programming.easy;

public class ClimbingStepsLeetCode70 {
    public int climbStairs(int n) {
        int[] count = new int[n+1];
        return climbStairsRec(n, count);
    }

    public int climbStairsRec(int n, int[] count) {
        if(n==0) {
            return 1;
        }
        if(n<0) {
            return 0;
        }
        if(count[n] > 0) {
            return count[n];
        }
        count[n] = climbStairsRec(n-1, count) + climbStairsRec(n-2, count);
        return count[n];
    }

    public static void main(String[] args) {
        ClimbingStepsLeetCode70 climbingStepsLeetCode70 = new ClimbingStepsLeetCode70();
        System.out.println(climbingStepsLeetCode70.climbStairs(5));
    }
}
