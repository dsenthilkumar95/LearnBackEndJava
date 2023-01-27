package com.improve.programming.medium;

import java.util.*;

public class GroupAnagramsLeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return new ArrayList<>();
        Map<String,List<String>> similarMap = new HashMap<>();
        for(String str : strs) {
            char[] count = new char[26];
            for(int i=0; i<str.length();i++) {
                count[str.charAt(i)-'a']++;
            }
            String key = new String(count);
            List<String> list = similarMap.get(key);
            if(list == null){
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                similarMap.put(key, stringList);
            } else {
                list.add(str);
            }
        }
        return new ArrayList<>(similarMap.values());
    }

    public static void main(String[] args) {
        GroupAnagramsLeetCode49 groupAnagramsLeetCode49 = new GroupAnagramsLeetCode49();
        String[] in = {"bdddddddddd","bbbbbbbbbbc"};
        List<List<String>> listList = groupAnagramsLeetCode49.groupAnagrams(in);
        for (List<String> list : listList) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
