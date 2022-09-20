package com.improve.programming.medium;

public class LC33SearchInRotatedArray {
    public int findOrigin(int[] nums, int start, int end, int prev) {
        int mid = (start+end)/2;
        if(mid==end) {
            return mid;
        }
        int rem = nums[mid];
        if(nums[mid]>nums[mid+1]) {
            return mid;
        } else {

        }
        return 0;
    }
    public int search(int[] nums, int target) {
        return 0;
    }

    public int search(int A[], int n, int target) {
        int lo=0,hi=n-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(A[mid]>A[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=n-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%n;
            if(A[realmid]==target)return realmid;
            if(A[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
}
