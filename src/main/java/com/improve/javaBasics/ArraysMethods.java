package com.improve.javaBasics;

import java.util.Arrays;
import java.util.List;

public class ArraysMethods {
    public static void main(String[] args) {
        // Different ways to initialize an array
        int[] array;
        array = new int[] {1,2,3,4,5};
        int[] array1 = {6,7,8,9,11};
        int array2[] = {11,12,13,14,15};
        int array3[] = new int[4];

        // Methods present in Arrays class to handle array
        // Arrays.asList(T... a)
        List<int[]> list = Arrays.asList(array);
        array[0] = 6;
        list.stream().forEach(s -> System.out.println(Arrays.toString(s)));
        List<Integer> intList = Arrays.asList(1, 2, 3);
        // This will give error since it is unmodifiable list
//        intList.add(5);
        // We can't add or remove, but we can modify the elements
        intList.set(0, 5);
        System.out.println(Arrays.toString(intList.toArray()));
        System.out.println("-----------------------------------------------------------------------------------");
        // Arrays.binarySearch(int[] a, int key)
        // Should provide sorted array without duplicates. Returns index if found
        int resultIndex = Arrays.binarySearch(array1, 8);
        System.out.println("resultIndex = " + resultIndex);
        // If element not present insertion point - position where it can be inserted
        // to maintain sorted order is returned.
        // Values will be between -1 to -(length+1)
        int resultIndex1 = Arrays.binarySearch(array1, 10);
        System.out.println("resultIndex = " + resultIndex1);
        int resultIndex3 = Arrays.binarySearch(array1, 12);
        System.out.println("resultIndex = " + resultIndex3);
        System.out.println("-----------------------------------------------------------------------------------");
        // Arrays.binarySearch(int[] a, int fromIndex, int toIndex, int key)
        // Similar behaviour as above but toIndex is excluded.
        int resultIndex4 = Arrays.binarySearch(array1, 0, 3, 8);
        System.out.println("resultIndex4 = " + resultIndex4);
        System.out.println("-----------------------------------------------------------------------------------");
        // Arrays.binarySearch(T[] a, T key, Comparator<? super T> c)


    }
}
