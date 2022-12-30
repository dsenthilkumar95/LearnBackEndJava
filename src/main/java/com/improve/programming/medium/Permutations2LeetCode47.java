package com.improve.programming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations2LeetCode47 {
    public static List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> full = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        recur(new ArrayList<>(), full, out);
        return out;
    }

    public void recur(List<Integer> path, List<Integer> rem, List<List<Integer>> out) {
        if(rem.isEmpty()){
            out.add(path);
        }
        for(int i=0; i<rem.size(); i++) {
            if(i>0 && rem.get(i)==rem.get(i-1)) {
                continue;
            }
            List<Integer> pathflow = new ArrayList<>(path);
            List<Integer> remflow = new ArrayList<>(rem);
            pathflow.add(rem.get(i));
            remflow.remove(rem.get(i));
            recur(pathflow, remflow, out);
        }
    }

    public List<List<Integer>> permuteUniqueNewTry(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> resultlist = new ArrayList<>();
        recurNew(resultlist, new ArrayList<>(), nums, used, 1);
        return resultlist;
    }

    public void recurNew(List<List<Integer>> resultlist,ArrayList<Integer> templist,int[] nums,boolean[] used, int depth) {
        if(templist.size() == nums.length) {
            resultlist.add(new ArrayList<>(templist));
            return;
        }
        int lastUsed = -1;
        for(int i=0; i<nums.length; i++) {
            if(used[i]) {
                continue;
            }
            if(lastUsed != -1 && nums[lastUsed] == nums[i]) {
                continue;
            }
            templist.add(nums[i]);
            used[i] = true;
            recurNew(resultlist, templist, nums, used, depth+1);
            templist.remove(templist.size()-1);
            used[i] = false;
            lastUsed = i;
        }
    }

    public static void main(String[] args) {
        Permutations2LeetCode47 permutations2LeetCode47 = new Permutations2LeetCode47();
        int[] nums = {2,2,1,1};
        List<List<Integer>> lists = permutations2LeetCode47.permuteUniqueNewTry(nums);
        for(List<Integer> list: lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
