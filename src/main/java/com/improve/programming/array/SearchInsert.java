package com.improve.programming.array;

public class SearchInsert {
    /* Find the position of element in an array, if not found, find the
    insert position(position of number just higher than the given number)
     */
    public int find(int[] nums, int target, int start, int end) {
        if(end-start <= 1) {
            if(nums[start] < target && target < nums[end]) {
                return end;
            } else if (target <= nums[start]) {
                return start;
            } else if (nums[end] < target) {
                return end + 1;
            } else if (nums[end] == target) {
                return end;
            }
        }
        int mid = (start+end)/2;
        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] > target) {
            return find(nums,target,start,mid);
        } else {
            return find(nums,target,mid,end);
        }
    }

    // Solution provided
    public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            System.out.println("low -> " + low);
            System.out.println("high -> " + high);
            System.out.println("mid -> " + mid);
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int[] nums1 = {1,3};
        SearchInsert searchInsert = new SearchInsert();
//        System.out.println(searchInsert.binarySearch(nums,7,0,nums.length-1));
//        System.out.println(searchInsert.binarySearch(nums,2,0,nums.length-1));
        System.out.println(searchInsert.find(nums1,3,0,nums1.length-1));
        System.out.println("----------------------------------------");
//        System.out.println(searchInsert.searchInsert(nums,7)); // expected output 4
//        System.out.println(searchInsert.searchInsert(nums,2)); // expected output 1
        //System.out.println(searchInsert.searchInsert(nums,0));
    }
}
