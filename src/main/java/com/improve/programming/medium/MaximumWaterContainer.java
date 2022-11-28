package com.improve.programming.medium;

public class MaximumWaterContainer {
    //Leet code problem 11 - medium
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length - 1;
        int maxArea=0;
        while(left<right) {
            int width=right-left;
            maxArea = Math.max(maxArea, Math.min(height[left],height[right])*width);
            if(height[left]<=height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // 1ms solution
    public int maxAreaEffective(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        int bar = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            if (area > max) max = area;
            if (height[l] > height[r]) {
                bar = height[r];
                while (l < r && height[r] <= bar) --r;
            }
            else{
                bar = height[l];
                while (l < r && height[l] <= bar) ++l;
            }
        }
        return max;
    }
}
