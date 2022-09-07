package com.improve.javaBasics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8Features {
    public void streamsFeatures() {
        // FlatMap example
        List<Integer> integerList = Arrays.asList(1,2,2,3);
        List<Integer> integerList1 = Arrays.asList(3,3,2);
        List<List<Integer>> inList = Arrays.asList(integerList,integerList1);
        System.out.println("-------------------FlatMap example---------------------------");
        System.out.println("input list1 -> "+Arrays.toString(integerList.toArray()));
        System.out.println("input list2 -> "+Arrays.toString(integerList1.toArray()));
        Set<Integer> checkSet = new HashSet<>();
        List<Integer> collect = inList.stream().flatMap(inputList -> inputList.stream()).filter(i -> checkSet.add(i)).collect(Collectors.toList());
        System.out.println("FlatMap for getting unique elements -> " +Arrays.toString(collect.toArray()));
        System.out.println("-------------------------------------------------------------");

    }

    public static void main(String[] args) {
        Java8Features java8Features = new Java8Features();
        java8Features.streamsFeatures();
    }
}
