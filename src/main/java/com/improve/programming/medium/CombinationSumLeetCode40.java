package com.improve.programming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumLeetCode40 {
    public static int count = 1;
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs_com(cand, 0, target, path, res);
        return res;
    }
    void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        System.out.println(count + " -> " + Arrays.toString(path.toArray()));
        count++;
        if (target == 0) {
            res.add(new ArrayList(path));
            return ;
        }
        if (target < 0) {
            return;
        }
        for (int i = cur; i < cand.length; i++){
            if (i > cur && cand[i] == cand[i-1]) {
                System.out.println("reached");
                continue;
            }
            path.add(path.size(), cand[i]);
            dfs_com(cand, i+1, target - cand[i], path, res);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSumLeetCode40 combinationSumLeetCode40 = new CombinationSumLeetCode40();
        int[] input = {1,1,1,4,5};
        List<List<Integer>> lists = combinationSumLeetCode40.combinationSum2(input, 1000);
        System.out.println("------------------out--------------------");
        lists.stream().forEach(arr -> System.out.println(Arrays.toString(arr.toArray())));
    }
}
