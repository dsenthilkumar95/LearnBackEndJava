package com.improve.algorithms;

public class BinarySearch {
    public int binarySearchRecur(int[] array,int target, int low, int high) {
        if(low>high) {
            return -1;
        }
        int mid = (low + high)>>>1;
        if(array[mid] == target) {
            return mid;
        }
        if(array[mid] < target) {
            return binarySearchRecur(array,target,mid+1,high);
        } else {
            return binarySearchRecur(array,target,low,mid-1);
        }
    }

    public int binarySearchIter(int[] array, int target) {
        int low=0;
        int high = array.length -1;
        while(low<=high) {
            int mid = (low+high)>>>1;
            if(array[mid] == target) {
                return mid;
            }
            if(array[mid]<target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] a = {1,2,3,4,5};
        System.out.println(binarySearch.binarySearchRecur(a,5,0,a.length-1));
        System.out.println(binarySearch.binarySearchRecur(a,3,0,a.length-1));
        System.out.println(binarySearch.binarySearchRecur(a,6,0,a.length-1));
        System.out.println(binarySearch.binarySearchRecur(a,0,0,a.length-1));
        System.out.println("---------------------------------------------------------------");
        System.out.println(binarySearch.binarySearchIter(a,5));
        System.out.println(binarySearch.binarySearchIter(a,3));
        System.out.println(binarySearch.binarySearchIter(a,6));
        System.out.println(binarySearch.binarySearchIter(a,0));
    }
}
