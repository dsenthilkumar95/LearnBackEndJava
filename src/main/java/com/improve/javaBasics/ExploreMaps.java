package com.improve.javaBasics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ExploreMaps {
    public static void main(String[] args) {
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("Senthil","Saro");
        System.out.println(Arrays.toString(stringMap.entrySet().toArray()));
    }
}
