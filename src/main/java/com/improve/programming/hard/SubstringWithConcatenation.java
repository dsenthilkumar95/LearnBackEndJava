package com.improve.programming.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenation{
    TrieNode root = new TrieNode();
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> out = new ArrayList<>();
        int len = words[0].length();
        int refCount = words.length;
        for (String w : words) {
            insert(w);
        }
        int count = 0;
        int pointer = 0;
        int i = 0;
        boolean alive = false;
        while(i<=s.length()-len) {
            System.out.println("Start - count -> " + count+" pointer -> " + pointer+" i -> " + i);
            String e = s.substring(i,i+len);
            int found = searchAndMark(s,i,i+len);
            System.out.println("Search And Mark -> " + e + " result -> " + found);
            if(found == 1) {
                alive = true;
                count++;
                if(count==refCount) {
                    out.add(pointer);
                    count--;
                    int a = moveAndUnmark(s,pointer,pointer+len,pointer);
                    System.out.println("moveAndUnmark in matchFound -> " + s.substring(pointer,pointer+len) + " result -> " + a);
                    pointer = pointer + len;
                }
                i += len;
            } else if(found == 0) {
                alive = true;
                while(pointer<i) {
                    int o = moveAndUnmark(s, pointer, pointer + len, i);
                    System.out.println("moveAndUnmark in duplicate -> " + s.substring(pointer,pointer+len) + " result -> " + o);
                    count--;
                    if (o == 1) {
                        int f = searchAndMark(s,i,i+len);
                        System.out.println("Search And Mark after removing duplicate -> " + e + " result -> " + f);
                        count++;
                        pointer += len;
                        break;
                    }
                    pointer += len;
                }
                i += len;
            } else {
                if(alive) {
                    int removalCount = unmarkAll(words);
                    System.out.println("unmarkAll removal count -> "+removalCount);
                }
                count=0;
                pointer = i + 1;
                i += 1;
                alive = false;
            }
            System.out.println("End - count -> " + count+" pointer -> " + pointer+" i -> " + i);
        }
        return out;
    }
    public void insert(String w) {
        TrieNode current = root;
        int len = w.length();
        for(int i=0; i<len; i++) {
            Character c = w.charAt(i);
            current = current.children.computeIfAbsent(c,k->new TrieNode());
        }
        current.refCount += 1;
    }
    public int searchAndMark(String w, int start, int end) {
        TrieNode current = root;
        for(int i=start; i<end; i++) {
            Character c = w.charAt(i);
            current = current.children.get(c);
            if(current == null) {
                return -1;
            }
        }
        if(current.refCount>0) {
            if (current.currCount < current.refCount) {
                current.currCount += 1;
                return 1;
            }
            return 0;
        }
        return -1;
    }
    public int moveAndUnmark(String w, int start, int end, int currI) {
        TrieNode current = root;
        boolean equal = true;
        for(int i=start; i<end; i++) {
            Character c = w.charAt(i);
            equal = equal && c==w.charAt(currI);
            current = current.children.get(c);
            if(current == null) {
                return -1;
            }
            currI++;
        }
        if(current.refCount>0 && current.currCount>0) {
            current.currCount -= 1;
            if(equal) {
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }
    public int unmarkAll(String[] words) {
        int count = 0;
        for(int i=0; i<words.length; i++) {
            TrieNode current = root;
            String word = words[i];
            for(int j=0; j<word.length(); j++) {
                current = current.children.get(word.charAt(j));
                if(current == null) {
                    break;
                }
            }
            if(current != null && current.refCount>0) {
                count += current.currCount;
                current.currCount = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubstringWithConcatenation substring = new SubstringWithConcatenation();
        String input = "foofoobarbarfoofooman";
        String[] inList = {"foo","foo","bar"};
        String in2 = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] inList2 = {"fooo","barr","wing","ding","wing"};
        List<Integer> integerList = substring.findSubstring(in2, inList2);
        System.out.println(Arrays.toString(integerList.toArray()));
    }
}
class TrieNode {
    HashMap<Character,TrieNode> children = new HashMap<>();
    int refCount = 0;
    int currCount = 0;
}