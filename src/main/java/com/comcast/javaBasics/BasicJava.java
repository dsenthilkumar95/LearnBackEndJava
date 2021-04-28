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
        // Here 1 is casted to int primitive as removes "2" from list, while only 1 created as Integer object is only removes the "1" from list
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.remove(1);
        intList.remove(new Integer(1));
        intList.forEach(i -> System.out.println(i));

        // Here String print method is called and null casts to String before Object
        print(null);

        // using / operator in int
        int a;
        a = 8/3;
        int b = -1/2;
        System.out.println("a -> " + a + " b -> " + b);
    }

    public static void print(Object o){
        System.out.println("Object method is called");
    }

    public static void print(String s){
        System.out.println("String method is called");
    }

    public static void print(int s){
        System.out.println("int method is called");
    }
}
