package com.improve.programming.array.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MergeSortedArrayInplace {

    /*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
    and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
    To accommodate this, nums1 has a length of m + n,
    where the first m elements denote the elements that should be merged,
    and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
    */

    /*
    Example 1:

    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]
    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
    Example 2:

    Input: nums1 = [1], m = 1, nums2 = [], n = 0
    Output: [1]
    Explanation: The arrays we are merging are [1] and [].
    The result of the merge is [1].
    Example 3:

    Input: nums1 = [0], m = 0, nums2 = [1], n = 1
    Output: [1]
    Explanation: The arrays we are merging are [] and [1].
    The result of the merge is [1].
    Note that because m = 0, there are no elements in nums1.
    The 0 is only there to ensure the merge result can fit in nums1.

    Constraints:

    nums1.length == m + n
    nums2.length == n
    0 <= m, n <= 200
    1 <= m + n <= 200
    -109 <= nums1[i], nums2[j] <= 109

    Follow up: Can you come up with an algorithm that runs in O(m + n) time?
    */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int j=0;
        for (int i=0; i<m+n; i++) {
            if (j<n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() < nums2[j]) {
                        if (i < m) {
                            if (queue.peek() < nums1[i]) {
                                queue.offer(nums1[i]);
                                nums1[i]=queue.poll();
                            }
                        } else {
                            nums1[i] = queue.poll();
                        }
                    } else {
                        if (i < m) {
                            if (nums1[i] > nums2[j]) {
                                queue.offer(nums1[i]);
                                nums1[i] = nums2[j];
                                j++;
                            }
                        } else {
                            nums1[i] = nums2[j];
                            j++;
                        }
                    }
                } else if (i < m) {
                    if (nums1[i] > nums2[j]) {
                        queue.offer(nums1[i]);
                        nums1[i] = nums2[j];
                        j++;
                    }
                } else {
                    nums1[i]=nums2[j];
                    j++;
                }
            } else if (!queue.isEmpty()) {
                if (i < m) {
                    if (queue.peek() < nums1[i]) {
                        queue.offer(nums1[i]);
                        nums1[i] = queue.poll();
                    }
                } else {
                    nums1[i] = queue.poll();
                }
            }
        }
    }

    public void efficientSolutionMerge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArrayInplace m = new MergeSortedArrayInplace();
        int[] nums1 = {-50,-49,-49,-48,-47,-45,-43,-41,-41,-41,-40,-40,-39,-39,-38,-37,-37,-36,-36,-35,-35,-33,-33,-32,-31,-31,-30,-30,-29,-28,-25,-24,-21,-19,-18,-18,-14,-13,-10,-10,-9,-9,-9,-6,-6,-5,-1,1,7,10,10,11,13,14,14,15,20,21,21,22,23,25,26,27,30,30,31,32,33,35,36,38,40,40,41,41,42,44,46,46,46,46,46,47,48,0};
        int[] nums2 = {33};
        m.merge(nums1, 85, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    /*I have used extra space of queue for sorting, but I didn't recognize we have extra space in num1
    * array itself, and we could have sorted from the behind using that space.
    * SEE THE AVAILABLE SPACE*/
}
