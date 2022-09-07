package com.improve.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<String> combinationsRecur(List<String> previous, int level, String word) {
        List<String> out = new ArrayList<>();
        if(level <= 0) {
            return previous;
        }
        level--;
        for(String p : previous) {
            char lastChar = p.charAt(p.length()-1);
            int index = word.indexOf(lastChar);
            for (int i=index+1; i<word.length(); i++) {
                String inter = p + String.valueOf(word.charAt(i));
                out.add(inter);
            }
        }
        return combinationsRecur(out,level,word);
    }

    public List<String> allCombinationsRecur(List<String> previous, int level, String word, List<String> allCombinations) {
        List<String> out = new ArrayList<>();
        if(level <= 0) {
            return allCombinations;
        }
        level--;
        for(String p : previous) {
            char lastChar = p.charAt(p.length()-1);
            int index = word.indexOf(lastChar);
            for (int i=index+1; i<word.length(); i++) {
                String inter = p + String.valueOf(word.charAt(i));
                out.add(inter);
            }
        }
        allCombinations.addAll(out);
        return allCombinationsRecur(out,level,word,allCombinations);
    }

    public List<String> combinationsOnLevel(String word, int level) {
        if(level <= 0) {
            return null;
        }
        level--;
        List<String> start = new ArrayList<>();
        for (char c : word.toCharArray()) {
            start.add(String.valueOf(c));
        }
        return combinationsRecur(start,level,word);
    }

    public List<String> allCombinations(String word) {
        int level = word.length();
        if(level <= 0) {
            return null;
        }
        List<String> start = new ArrayList<>();
        for (char c : word.toCharArray()) {
            start.add(String.valueOf(c));
        }
        level--;
        return allCombinationsRecur(start,level,word,start);
    }

    public List<String> allCombinationsUptoLevel(String word, int level) {
        if(level <= 0) {
            return null;
        }
        List<String> start = new ArrayList<>();
        for (char c : word.toCharArray()) {
            start.add(String.valueOf(c));
        }
        level--;
        return allCombinationsRecur(start,level,word,start);
    }

    public static void main(String[] args) {
        // Simple comment
        Combinations combinations = new Combinations();
        String word = "doge";
        List<String> out = combinations.combinationsOnLevel(word,2);
        System.out.println(String.join(",",out));
        System.out.println("-----------------------------------------------------------------");
        List<String> out1 = combinations.allCombinations(word);
        System.out.println(String.join(",",out1));
        System.out.println("-----------------------------------------------------------------");
        List<String> out2 = combinations.allCombinationsUptoLevel(word,2);
        System.out.println(String.join(",",out2));
    }
}