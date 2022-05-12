package com.improve.programming.array;

public class MovingZeroesToEndOfArray {
    public void moveZeroes_myTry(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int swap;
        while(i<nums.length && j>-1) {
            if(nums[i] == 0) {
                while(nums[j] != 0 && j>-1) {
                    j--;
                }
                if(i<j){
                    swap = nums[i];
                    nums[i] = nums[j];
                    nums[j] = swap;
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        MovingZeroesToEndOfArray movingZeroesToEndOfArray = new MovingZeroesToEndOfArray();

    }
}
