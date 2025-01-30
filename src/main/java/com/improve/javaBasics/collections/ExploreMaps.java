package com.improve.javaBasics.collections;

import java.util.*;

public class ExploreMaps {

    public void printingMap() {
        Map<String,String> stringMap = new HashMap<>(5);
        stringMap.put("Senthil","Saro");
        System.out.println(stringMap.get("Senthil"));
        System.out.println(Arrays.toString(stringMap.entrySet().toArray()));
    }

    public void comparingMapsWithEqualsMethod() {
        Map<String, List<String>> friendMap = new HashMap<>();
        friendMap.put("Senthil",Arrays.asList("Senthil","Saro"));

        Map<String, List<String>> friendMap1 = new HashMap<>();
        friendMap1.put("Senthil",Arrays.asList("Saro","Senthil"));

        System.out.println("Map equals with list value -> " + friendMap.equals(friendMap1));
    }

    public void alteringCustomKeyObjectWithReference() {
        Map<Node,Integer> nodeIntegerMap = new HashMap<>();
        Node node = new Node();
        node.setId(1);
        Node node2 = new Node();
        node2.setId(2);
        nodeIntegerMap.put(node,1);
        nodeIntegerMap.put(node2,2);
        Node node3 = new Node();
        node3.setId(3);
        node.setId(3);
        System.out.println(nodeIntegerMap.get(node3));
        System.out.println(nodeIntegerMap.get(node));
        System.out.println(Arrays.toString(nodeIntegerMap.entrySet().toArray()));
    }

    public static void main(String[] args) {
        ExploreMaps exploreMaps = new ExploreMaps();
        exploreMaps.alteringCustomKeyObjectWithReference();
//        exploreMaps.printingMap();
    }
}

