package com.improve.programming;

import java.util.ArrayList;
import java.util.List;

public class CombinationGeneratorRecursion {
    public static void main(String args[]) {
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);
//        List<List<Integer>> outputList = comb(inputList, 2);
//        System.out.println(outputList.size());
    }

    public static List<List<Integer>> comb(List<List<Integer>> inputList, int r) {
        if(r==0) {
            List<List<Integer>> emptyList = new ArrayList<>();
            return emptyList;
        }
        List<List<Integer>> outputList = new ArrayList<>();
        for(int i=0; i<inputList.size(); i++) {
            List<Integer> integerList = inputList.get(i);

        }
        return outputList;
    }
}
