package com.comcast.javaBasics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JavaCompare {
    public static void main(String[] args){
        CompareAObj compareAObj1 = new CompareAObj();
        compareAObj1.setId(1);
        CompareAObj compareAObj2 = new CompareAObj();
        compareAObj2.setId(2);
        CompareAObj[] compareAObjsArray = {compareAObj1, compareAObj2};
        Arrays.sort(compareAObjsArray);
        Arrays.stream(compareAObjsArray).forEach(i-> System.out.println(i.toString()));

        CompareBObj compareBObj1 = new CompareBObj();
        compareBObj1.setId(1);
        CompareBObj compareBObj2 = new CompareBObj();
        compareBObj2.setId(2);
        CompareBObj[] compareBObjsArray = {compareBObj1, compareBObj2};

        class IdComparator implements Comparator<CompareBObj> {
            @Override
            public int compare(CompareBObj o1, CompareBObj o2) {
                return o1.getId() - o2.getId();
            }
        }

        Arrays.sort(compareBObjsArray, new IdComparator());
        Arrays.stream(compareBObjsArray).forEach(i-> System.out.println(i.toString()));

        int[] intArray = {4,3,2,1};
        Arrays.sort(intArray);

    }
}


