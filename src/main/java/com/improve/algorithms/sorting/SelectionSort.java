package com.improve.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {
    public List<Integer> selectionSortingList(List<Integer> inList) {
        int len = inList.size();
        for(int i=0; i<len; i++) {
            int minPos = i;
            for(int j=i+1; j<len; j++) {
                if(inList.get(j) < inList.get(i)) {
                    minPos = j;
                }
            }
            inList.set(minPos,inList.set(i,inList.get(minPos)));
        }
        return inList;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        List<Integer> integerList = new ArrayList<Integer>(Arrays.asList(4,3,2,1));
        selectionSort.selectionSortingList(integerList);
        System.out.println(Arrays.toString(integerList.toArray()));
    }
}
