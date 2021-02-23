package com.comcast.javaBasics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BasicJava {

    public static void main(String[] args) {
        // Ambiguity in multiple inheritance
        InterA interA = new Ambigious();
        interA.common();
        Object arrList = new ArrayList<String>();

        // ArrayList construction from another collection
        String[] sourceArray = new String[]{"senthil"};
        String[] targetArray = java.util.Arrays.copyOf(sourceArray, 1);

        sourceArray[0] = "saro";
        System.out.println(targetArray[0]);

        // remove method overloading in ArrayList between index and object
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.remove(1);
        intList.remove(new Integer(1));
        intList.forEach(i -> System.out.println(i));
    }
}
