package com.improve.programming.array.easy;
/*
You are given an integer array nums of length n.

A partition is defined as an index i where 0 <= i < n - 1, splitting the array into two non-empty subarrays such that:

Left subarray contains indices [0, i].
Right subarray contains indices [i + 1, n - 1].
Return the number of partitions where the difference between the sum of the left and right subarrays is even.

Constraints:

2 <= n == nums.length <= 100
1 <= nums[i] <= 100

Example 1:
Input: nums = [10,10,3,7,6]

Output: 4

Explanation:

The 4 partitions are:

[10], [10, 3, 7, 6] with a sum difference of 10 - 26 = -16, which is even.
[10, 10], [3, 7, 6] with a sum difference of 20 - 16 = 4, which is even.
[10, 10, 3], [7, 6] with a sum difference of 23 - 13 = 10, which is even.
[10, 10, 3, 7], [6] with a sum difference of 30 - 6 = 24, which is even.
 */
public class CountPartitionWithEvenSum {
    public int countPartitions(int[] nums) {
        int sum = 0;
        int out = 0;
        for (int i=1; i<nums.length; i++) {
            sum += nums[i];
        }
        int leftSum = nums[0];
        for (int i=1; i<nums.length; i++) {
            if ((leftSum - sum) % 2 == 0) {
                out++;
            }
            leftSum += nums[i];
            sum = sum - nums[i];
        }
        return out;
    }

    public static void main(String[] args) {
        CountPartitionWithEvenSum c = new CountPartitionWithEvenSum();
        int[] example1 = new int[]{10,10,3,7,6};
        c.countPartitions(example1);
    }
}
