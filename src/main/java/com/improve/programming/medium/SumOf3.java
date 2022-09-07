package com.improve.programming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOf3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            recurSum(out,new ArrayList<Integer>(3), nums, i, nums.length, 0, 0);
        }
        return out;
    }

    public void recurSum(List<List<Integer>> out, List<Integer> prev, int[] nums, int start, int end, int sum, int height) {
        System.out.println("Start -> " + start + " End -> " + end + " Height -> " + height + " Sum -> " + sum + " Prev -> " + Arrays.toString(prev.toArray()));
        height++;
        prev.add(nums[start]);
        sum += nums[start];
        if(height == 2) {
            int target = 0 - sum;
            if(Integer.MIN_VALUE == binarySearch(target, nums, start+1,end-1)) {
                return;
            } else {
                prev.add(target);
                if(out.size()>0) {
                    if (!(out.get(out.size() - 1).equals(prev))) {
                        System.out.println("added prev");
                        out.add(prev);
                    }
                } else {
                    System.out.println("added prev");
                    out.add(prev);
                }
                return;
            }
        }
        for(int i=start+1; i<end; i++) {
            recurSum(out,new ArrayList<>(prev), nums, i, end, sum, height);
        }
        return;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        int i=0;
        boolean iFlag = false;
        boolean jFlag = false;
        while(i< nums.length-2){
            if(nums[i] != nums[i+1]) {
                break;
            }
            i++;
        }
        while(i<nums.length-2){
            int j = i+1;
            while(j<nums.length-1) {
                while(j<nums.length-1) {
                    if(nums[j] != nums[j+1]) {
                        break;
                    }
                    j++;
                }
                int sum = 0-nums[i]-nums[j];
                if(sum > nums[j]) {
                    int target = binarySearch(sum, nums, j + 1, nums.length - 1);
                }
            }

        }
        return null;
    }

    public int binarySearch(int target, int[] nums, int start, int end) {
        System.out.println("Binary Start -> " + start + " end -> " + end);
        if(end < start) {
            return Integer.MIN_VALUE;
        }
        int mid = (start + end)/2;
        if(target == nums[mid]) {
            return target;
        } else if(target<nums[mid]) {
            return binarySearch(target, nums, start, mid-1);
        } else {
            return binarySearch(target, nums, mid+1, end);
        }
    }

    public static void main(String[] args) {
        SumOf3 sumOf3Object = new SumOf3();
        int[] nums = {-1,0,1,2,-1,4};
        List<List<Integer>> lists = sumOf3Object.threeSum(nums);
        lists.forEach(l -> {
            System.out.println(Arrays.toString(l.toArray()));
        });
    }
}
