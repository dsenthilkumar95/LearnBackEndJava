package com.improve.javaBasics;

import java.util.*;

public class ExploreList {
    public void exploreArrayList(String mode) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        if(mode.equals("delete")) {
            System.out.println("List -> Delete Operations");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("To fix size of ArrayList to current number of elements in it and to remove off extra memory occupied by elementData array");
            System.out.println("void .trimToSize() method can be used");
            integerArrayList.trimToSize();
            System.out.println("--------------------------------------------------------------------------");
        }
    }

    public void exploreList(String mode) {
        List<Integer> integerList = new ArrayList<>();
        if(mode.equals("read")){
            System.out.println("List -> Read Options");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Get integer size of the list. If list is larger then Integer.MAX_VALUE, Integer.MAX_VALUE is got");
            System.out.println("integerList.size() -> " + integerList.size());
            System.out.println("--------------------------------------------------------------------------");
            ArrayList<Integer> integerArrayList = new ArrayList<>();
            System.out.println("Using .containsAll(Collection) to get boolean result if its a sub collection");
            boolean containsAll = integerArrayList.containsAll(integerList);
            System.out.println("integerArrayList.containsAll(integerList) -> " + containsAll);
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Using .get(int index) to get element from specified index in the list");

        } else if (mode.equals("update")) {
            System.out.println("List -> Update options");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Using .add(element) method to add element to the end of list");
            integerList.add(1);
            System.out.println(Arrays.toString(integerList.toArray()));
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Using .add(index,element) method to insert element at any index");
            integerList.add(0,2);
            System.out.println(Arrays.toString(integerList.toArray()));
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Using .addAll(collection) method to insert element at any index");
            System.out.println("Before operation " + Arrays.toString(integerList.toArray()));
            List<Integer> secondList = new ArrayList<>();
            secondList.add(3);
            secondList.add(4);
            integerList.addAll(secondList);
            System.out.println("After operation " + Arrays.toString(integerList.toArray()));
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Using .addAll(index,collection) method to insert element at any index");
            System.out.println("Before operation " + Arrays.toString(integerList.toArray()));
            integerList.addAll(1,secondList);
            System.out.println("After operation " + Arrays.toString(integerList.toArray()));
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Sorting list using void .sort() method");
            System.out.println("Before operation " + Arrays.toString(integerList.toArray()));
//            integerList.sort(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o1-o2;
//                }
//            });
            integerList.sort((a,b) -> a-b);
            System.out.println("integerList.sort((a,b) -> a-b) can also construct a comparator since it's a functional interface");
            System.out.println("After operation " + Arrays.toString(integerList.toArray()));
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("To update value at particular index E .set(index,element) can be used");
            System.out.println("Before operation " + Arrays.toString(integerList.toArray()));
            System.out.println("integerList.set(0,5) Element earlier present at index 0 is " + integerList.set(0,5));
            System.out.println("After operation " + Arrays.toString(integerList.toArray()));
            System.out.println("--------------------------------------------------------------------------");
        } else if(mode.equals("delete")) {
            Integer[] listData = {1,4,5,8,9,7,2};
            integerList.addAll(Arrays.asList(listData));
            System.out.println("List -> Delete Options");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Removing elements from index a to index b in a list.(Index b exclusive)");
            System.out.println(Arrays.toString(integerList.toArray()));
            integerList.subList(0,1).clear();
            System.out.println(Arrays.toString(integerList.toArray()));
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Removing element from list using E .remove(index)");
            System.out.println("Before operation " + Arrays.toString(integerList.toArray()));
            System.out.println("Element removed -> " + integerList.remove(0));
            System.out.println("After operation " + Arrays.toString(integerList.toArray()));
            System.out.println("--------------------------------------------------------------------------");

        } else if(mode.equals("misc")) {
            Integer[] listData = {1,4,5,8,9,7,2};
            integerList.addAll(Arrays.asList(listData));
            System.out.println("Miscellaneous operations in list");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Sublist from list");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Creating sublist with List<> .subList(indexA, indexB) to get a part of list - similar to creating iterator");
            System.out.println("Before " + Arrays.toString(integerList.toArray()));
            List<Integer> subList = integerList.subList(0,2);
            System.out.println("After " + Arrays.toString(integerList.toArray()));
            System.out.println("Sublist " + Arrays.toString(subList.toArray()));
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Deleting element in sublist - deletes the respective element in original list");
            System.out.println("Before " + Arrays.toString(integerList.toArray()));
            subList.remove(subList.get(0));
            System.out.println("Sublist " + Arrays.toString(subList.toArray()));
            System.out.println("After " + Arrays.toString(integerList.toArray()));
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Adding element to sublist - adds the element from indexB in original list");
            System.out.println("Before " + Arrays.toString(integerList.toArray()));
            subList.add(9);
            System.out.println("Sublist " + Arrays.toString(subList.toArray()));
            System.out.println("After " + Arrays.toString(integerList.toArray()));
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Modifying element in original arrayList");
            System.out.println("Before " + Arrays.toString(integerList.toArray()));
            try {
                integerList.remove(integerList.get(0));
                System.out.println("Sublist " + Arrays.toString(subList.toArray()));
            } catch (Exception e) {
                System.out.println("Once original list is modified, sublist becomes invalid and accessing it will cause ConcurrentModificationException");
            }
            System.out.println("After " + Arrays.toString(integerList.toArray()));
            System.out.println("--------------------------------------------------------------------------");
        }
    }

    public void exploreLinkedList(String mode) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        Integer[] listData = {4,6,7,9,2,0,1};
        integerLinkedList.addAll(Arrays.asList(listData));
        if(mode.equals("update")) {
            System.out.println("Linked List -> Update Operations");
            System.out.println("__________________________________________________________________________");
            System.out.println("Using boolean .offer(E) to add element to end of LinkedList - offer returns false if add is failing");
            System.out.println("But .add(E) will throw IllegalStateException if add is not possible");
            System.out.println("Before " + Arrays.toString(integerLinkedList.toArray()));
            integerLinkedList.offer(2);
            System.out.println("After " + Arrays.toString(integerLinkedList.toArray()));
            System.out.println("__________________________________________________________________________");

        } else if(mode.equals("delete")) {
            System.out.println("Linked List -> Delete Operations");
            System.out.println("__________________________________________________________________________");
            System.out.println("Popping first element from linked list -> can be used to maintain queue");
            System.out.println(Arrays.toString(integerLinkedList.toArray()));
            System.out.println("integerLinkedList.pop() -> " + integerLinkedList.pop());
            System.out.println(Arrays.toString(integerLinkedList.toArray()));
            System.out.println("--------------------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        ExploreList exploreList = new ExploreList();
//        exploreList.exploreList("misc");
//        exploreList.exploreArrayList("read");
        exploreList.exploreLinkedList("update");
    }
}