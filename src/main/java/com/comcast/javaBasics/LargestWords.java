package com.comcast.javaBasics;

import java.util.*;
import java.util.stream.Collectors;

public class LargestWords {
    // input 1 -> largest
    public static List<String> largestString(String input, int largest){
        String[] inputArray = input.split(" ");
        Map<Integer,List<String>> outputMap = new HashMap<>();
        for(String in : inputArray){
            String cleanIn = in.replaceAll("\\.","").replaceAll("'","").replaceAll(",","");
            if(outputMap.get(cleanIn.length()) == null){
                List<String> innerList = new ArrayList<>();
                innerList.add(cleanIn);
                outputMap.put(cleanIn.length(), innerList);
            } else {
                List<String> presentList = outputMap.get(cleanIn.length());
                presentList.add(cleanIn);
                outputMap.put(cleanIn.length(), presentList);
            }
        }
        List<Integer> sortedKeys = new ArrayList<>();
        outputMap.keySet().stream().sorted().forEach(key -> {
            sortedKeys.add(key);
        });
        Integer keyRequired = sortedKeys.get(sortedKeys.size() - largest);
        if(keyRequired != null){
            return outputMap.get(keyRequired);
        }
        return new ArrayList<>();

//        Collections.sort(inputList, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length()-o1.length();
//            }
//        });
    }

    public static void main(String[] args){
        String input = "Hi. I am Senthil Kumar.";
        List<String> output = LargestWords.largestString(input, 1);
        output.forEach(out -> {
            System.out.println(out);
        });
    }
}