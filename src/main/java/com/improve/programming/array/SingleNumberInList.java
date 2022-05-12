package com.improve.programming.array;

public class SingleNumberInList {

    // My try
    public int singleNumber(int[] nums) {
        String numString="";
        for(int i=0; i<nums.length; i++) {
            System.out.println("numString before - " + i + " - " + numString);
            if(numString.indexOf(String.valueOf(nums[i])) == -1) {
                numString = numString + String.valueOf(nums[i]);
            } else {
                System.out.println(String.valueOf(nums[i]));
                numString = numString.replace(String.valueOf(nums[i]),"");
            }
            System.out.println("numString after - " + i + " - " + numString);
        }
        return Integer.valueOf(numString);
    }

    public static void main(String[] args) {
        SingleNumberInList singleNumberInList = new SingleNumberInList();
        int[] nums = {2,2,1} ;
        singleNumberInList.singleNumber(nums);
    }
}
