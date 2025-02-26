package com.improve.programming.array.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElements {
    /*
    Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than ⌊n / 2⌋ times.
    You may assume that the majority element always exists in the array.

    Example 1:

    Input: nums = [3,2,3]
    Output: 3
    Example 2:

    Input: nums = [2,2,1,1,1,2,2]
    Output: 2

    Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109

    Follow-up: Could you solve the problem in linear time and in O(1) space?
    */

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = nums[0];
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            if (entry.getValue() > nums.length/2) {
                max = entry.getKey();
            }
        }
        return max;
    }

    public int mooreVotingMajorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        MajorityElements major = new MajorityElements();
        System.out.println(major.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
