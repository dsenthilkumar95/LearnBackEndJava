package com.improve.programming.medium;

public class ElementInRotatedSortedArray {
    public int findInSortedArray(int[] array, int low, int high, int target) {
        if(low > high) {
            return -1;
        }
        int mid = (low + high)/2;
        if(array[mid] == target){
            return mid;
        }
        if(target < array[mid]) {
            if(array[low] <= array[mid]) {
                if(array[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        } else {
            if(array[mid] <= array[high]) {
                if(target <= array[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return findInSortedArray(array,low,high,target);
    }

    public static void main(String[] args) {
        ElementInRotatedSortedArray element = new ElementInRotatedSortedArray();
        int[] array = {4,5,6,7,0,1,2,3};
        int[] arr = {5,1,3};
        int[] arr2 = {4,5,6,7,8,1,2,3};
//        System.out.println(element.findInSortedArray(array,0,array.length-1,0));
//        System.out.println(element.findInSortedArray(array,0,array.length-1,-2));
//        System.out.println(element.findInSortedArray(arr,0,arr.length-1,5));
        System.out.println(element.findInSortedArray(arr2,0,arr2.length-1,8));

    }
}
