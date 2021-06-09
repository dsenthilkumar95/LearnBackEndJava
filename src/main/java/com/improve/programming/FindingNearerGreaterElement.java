package com.improve.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindingNearerGreaterElement {
    public static int findingLargerNumbersStartIndex(List<Integer> sortedList, Integer input){
        int greaterNumberIndex = -1;
        if(sortedList instanceof ArrayList){
            int startIndex = 0;
            int endIndex = sortedList.size()-1;
            int midIndex;

            while(startIndex < endIndex){
                midIndex = (startIndex + endIndex)/2;
                if(sortedList.get(midIndex) > input){
                    endIndex = midIndex;
                } else if (sortedList.get(midIndex) <= input){
                    startIndex = midIndex + 1;
                }
                System.out.println("Start Index -> " + startIndex + " End Index -> " + endIndex);
            }
            greaterNumberIndex = startIndex;
        }
        return greaterNumberIndex;
    }

    public static void main(String[] args){
        List<Integer> inputList = new ArrayList<>();
        Integer[] inputArray = {1,1,1,1,2,2,2,2,2,2,4,7,8};
        inputList.addAll(Arrays.asList(inputArray));
        Integer input = 5;
        System.out.println(findingLargerNumbersStartIndex(inputList, input));
    }
}