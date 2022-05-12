package com.improve.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public void allPermutations(String previous, String word, List<String> allPerms) {
        if(word.isEmpty()) {
            return;
        }
        for(char c : word.toCharArray()) {
            String inter = previous + String.valueOf(c);
            allPerms.add(inter);
            allPermutations(inter,word.replace(String.valueOf(c),""),allPerms);
        }
    }

    public void permutationsUptoLevel(String previous, int level, String word, List<String> allPerms) {
        if(word.isEmpty() || level <= 0) {
            return;
        }
        for(char c : word.toCharArray()) {
            String inter = previous + String.valueOf(c);
            allPerms.add(inter);
            permutationsUptoLevel(inter,level-1,word.replace(String.valueOf(c),""),allPerms);
        }
    }

    public void permutationsOnLevel(String previous, int level, String word, List<String> allPerms) {
        if(word.isEmpty() || level <= 0) {
            return;
        }
        for(char c : word.toCharArray()) {
            String inter = previous + String.valueOf(c);
            if(level == 1){
                allPerms.add(inter);
            }
            permutationsOnLevel(inter,level-1,word.replace(String.valueOf(c),""),allPerms);
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        String word = "doge";
        List<String> out = new ArrayList<>();
        permutations.allPermutations("",word,out);
        System.out.println(String.join(",",out));
        System.out.println("All permutation size for word of size " + word.length() + " is " + out.size());
        System.out.println("------------------------------------------------------------------------------");
        List<String> out1 = new ArrayList<>();
        permutations.permutationsUptoLevel("",2,word,out1);
        System.out.println(String.join(",",out1));
        System.out.println("-------------------------------------------------------------------------------");
        List<String> out2 = new ArrayList<>();
        permutations.permutationsOnLevel("",2,word,out2);
        System.out.println(String.join(",",out2));
    }
}
