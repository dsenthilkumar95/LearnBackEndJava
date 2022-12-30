package com.improve.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    public List<Integer> insertionSorting(List<Integer> inList) {
        for(int i=0; i<inList.size(); i++) {
            int j = i;
            while(j>0 && inList.get(j)<inList.get(j-1)) {
                inList.set(j,inList.set(j-1,inList.get(j)));
                j = j-1;
            }
        }
        return inList;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(Arrays.toString(insertionSort.insertionSorting(new ArrayList<>(Arrays.asList(5,4,3,2,1))).toArray()));
    }
}
