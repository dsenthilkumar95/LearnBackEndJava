package com.improve.programming.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryOfRanges {
    // Given a sorted unique integer list, we need to write the range of numbers in the list
    /* Example:
    Input: nums = [0,2,3,4,6,8,9]
    Output: ["0","2->4","6","8->9"]
    Explanation: The ranges are:
    [0,0] --> "0"
    [2,4] --> "2->4"
    [6,6] --> "6"
    [8,9] --> "8->9"
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList();
        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
                i++;
            }
            if(a!=nums[i]){
                list.add(a+"->"+nums[i]);
            }else{
                list.add(a+"");
            }
        }
        return list;
    }

    public List<String> summaryRanges_myTry(int[] nums) {
        List<String> output = new ArrayList<>();
        int n = nums.length;
        String range = "";
        int rangeIndex = 0;
        for(int i=0; i<nums.length; i++) {
            if(range.isEmpty()){
                range = String.valueOf(nums[i]);
                rangeIndex = i;
            } else {
                if(Math.abs(nums[i-1]-nums[i]) != 1) {
                    if(rangeIndex != i-1) {
                        range = range + "->" + String.valueOf(nums[i-1]);
                    }
                    output.add(range);
                    range = String.valueOf(nums[i]);
                    rangeIndex = i;
                }
            }
        }
        if(rangeIndex < n-1) {
            range = range + "->" + String.valueOf(nums[n-1]);
            output.add(range);
        } else if (rangeIndex == n-1){
            output.add(range);
        }
        return output;
    }

    public static void main(String[] args) {
        SummaryOfRanges summaryOfRanges = new SummaryOfRanges();
        int[] nums = {0,2,3,4,6,8,9};
        List<String> output = summaryOfRanges.summaryRanges_myTry(nums);
        output.forEach(s -> System.out.println(s));
    }
}
