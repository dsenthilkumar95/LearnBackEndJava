package com.improve.javaBasics.collections;

import java.util.LinkedHashSet;

public class ExploreSet {
    public void exploreLinkedHashSet() {
        LinkedHashSet<Integer> integerLinkedHashSet = new LinkedHashSet<>();
        integerLinkedHashSet.add(2);
        integerLinkedHashSet.add(1);
        for (Integer i : integerLinkedHashSet) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ExploreSet exploreSet = new ExploreSet();
        exploreSet.exploreLinkedHashSet();
    }
}
