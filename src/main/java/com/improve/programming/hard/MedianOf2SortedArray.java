package com.improve.programming.hard;

public class MedianOf2SortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sum = len1 + len2;
        if(sum == 1) {
            return len1 == 1? nums1[0] : nums2[0];
        }
        int halfLen = sum/2;
        halfLen++;
        boolean isEven = true;
        if((nums1.length + nums2.length)%2!=0){
            isEven = false;
        }
        int i = 0;
        int j = 0;
        int prev = 0;
        int next = 0;
        while(i+j<halfLen) {
            if(i==len1){
                prev = next;
                next = nums2[j];
                j ++;
                System.out.println("prev -> "+prev + " next -> "+next);
            } else if(j==len2){
                prev = next;
                next = nums1[i];
                i++;
                System.out.println("prev -> "+prev + " next -> "+next);
            } else if(nums1[i] < nums2[j]) {
                prev = next;
                next = nums1[i];
                i++;
                System.out.println("prev -> "+prev + " next -> "+next);
            } else {
                prev = next;
                next = nums2[j];
                j++;
                System.out.println("prev -> "+prev + " next -> "+next);
            }
        }
        if(isEven) {
            double out = prev + next;
            return out/2;
        } else {
            return next;
        }
    }

    public static void main(String[] args) {
        MedianOf2SortedArray medianOf2SortedArray = new MedianOf2SortedArray();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4,5};
        System.out.println(medianOf2SortedArray.findMedianSortedArrays(nums1,nums2));
    }
}
