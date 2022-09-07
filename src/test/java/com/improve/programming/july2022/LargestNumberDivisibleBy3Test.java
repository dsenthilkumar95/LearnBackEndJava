package com.improve.programming.july2022;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestNumberDivisibleBy3Test {
    LargestNumberDivisibleBy3 largestNumberDivisibleBy3;

    @Before
    public void setup() {
        largestNumberDivisibleBy3 = new LargestNumberDivisibleBy3();
    }

    @Test
    public void allDivisible() {
        int[] l = {3,1,4,1};
        int ans = largestNumberDivisibleBy3.solution(l);
        assertEquals(4311,ans);
    }

    @Test
    public void remainingOneAvailable() {
        int[] l = {3,4,5,7};
        int ans = largestNumberDivisibleBy3.solution(l);
        assertEquals(753,ans);
    }

    @Test
    public void remainingOneNotAvailable() {
        int[] l = {5,5,3};
        int ans = largestNumberDivisibleBy3.solution(l);
        assertEquals(3,ans);
    }

    @Test
    public void remainingOneNotTwoEmpty() {
        int[] l = {8,8};
        int ans = largestNumberDivisibleBy3.solution(l);
        assertEquals(0,ans);
    }

    @Test
    public void remainingOneNotTwoNot() {
        int[] l = {7};
        int ans = largestNumberDivisibleBy3.solution(l);
        assertEquals(0,ans);
    }

    @Test
    public void remainingTwoAvailable() {
        int[] l = {8,4,5,9};
        int ans = largestNumberDivisibleBy3.solution(l);
        assertEquals(984,ans);
    }

    @Test
    public void remainingTwoNotAvailable() {
        int[] l = {4,4,9};
        int ans = largestNumberDivisibleBy3.solution(l);
        assertEquals(9,ans);
    }

    @Test
    public void remainingTwoNotOne() {
        int[] l = {4,4};
        int ans = largestNumberDivisibleBy3.solution(l);
        assertEquals(0,ans);
    }

    @Test
    public void remainingTwoOneNot() {
        int[] l = {8};
        int ans = largestNumberDivisibleBy3.solution(l);
        assertEquals(0,ans);
    }
}
