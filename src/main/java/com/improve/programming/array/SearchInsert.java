package com.improve.programming.array;

public class SearchInsert {
    /* Find the position of element in an array, if not found, find the
    insert position(position of number just higher than the given number)
     */
    public int binarySearch(int[] nums, int target, int low, int high) {
        if(high-low <= 1) {
            if(nums[low] == target) {
                return low;
            } else if (nums[high] == target) {
                return high;
            } else {
                return high;
            }
        }
        int mid = (low + high) / 2;
        System.out.println("low -> " + low);
        System.out.println("high -> " + high);
        System.out.println("mid -> " + mid);
        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] > target) {
            return binarySearch(nums,target,low,mid);
        } else {
            return binarySearch(nums,target,mid,high);
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
        SearchInsert searchInsert = new SearchInsert();
//        System.out.println(searchInsert.binarySearch(nums,7,0,nums.length-1));
//        System.out.println(searchInsert.binarySearch(nums,2,0,nums.length-1));
        System.out.println("----------------------------------------");
//        System.out.println(searchInsert.searchInsert(nums,7)); // expected output 4
//        System.out.println(searchInsert.searchInsert(nums,2)); // expected output 1
        System.out.println(searchInsert.searchInsert(nums,0));
    }
}
