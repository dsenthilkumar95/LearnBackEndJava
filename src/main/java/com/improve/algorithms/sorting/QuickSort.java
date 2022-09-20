package com.improve.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
    public int[] quickSortArray(int[] array, int l, int r) {
        System.out.println(Arrays.toString(array));
        if(r-l <= 1) {
            return array;
        }
        int pivot = array[l];
        int lower = l+1;
        int upper = l+1;
        for(int i=l+1; i<r; i++) {
            if(array[i] > pivot) {
                upper++;
            } else {
                int temp = array[i];
                array[i] = array[lower];
                array[lower] = temp;
                lower++;
                upper++;
            }
        }
        lower--;
        int temp = array[lower];
        array[lower] = array[l];
        array[l] = temp;
        quickSortArray(array, l, lower);
        quickSortArray(array, lower+1,upper);
        return array;
    }
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {3,1,5,2,4};
        array = quickSort.quickSortArray(array,0,array.length);
        System.out.println(Arrays.toString(array));
    }
}
