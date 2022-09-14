package com.improve.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
    public int[] mergeSorter(int[] array1, int[] array2) {
        int a1 = array1.length;
        int a2 = array2.length;
        int i=0,j=0,k=0;
        int[] out = new int[a1+a2];
        while(k < a1+a2) {
            if(i==a1) {
                while(j<a2) {
                    out[k] = array2[j];
                    j++;
                    k++;
                }
            } else if (j == a2) {
                while(i<a1) {
                    out[k] = array1[i];
                    i++;
                    k++;
                }
            } else if (array1[i] < array2[j]) {
                out[k] = array1[i];
                k++;
                i++;
            } else {
                out[k] = array2[j];
                j++;
                k++;
            }
        }
        return out;
    }

    public int[] mergeSortRec(int[] input, int depth) {
        System.out.println("Array -> "+Arrays.toString(input) + " Depth -> " + depth);
        int n = input.length;
        if(n <= 1) {
            return input;
        }
        int[] array1 = mergeSortRec(Arrays.copyOfRange(input,0, n/2),depth+1);
        int[] array2 = mergeSortRec(Arrays.copyOfRange(input,n/2,n), depth+1);

        int[] out = mergeSorter(array1,array2);
        return out;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] input = {3,1,4,6,2,7,5,8};
        int[] out = mergeSort.mergeSortRec(input,1);
        System.out.println(Arrays.toString(out));
    }
}
