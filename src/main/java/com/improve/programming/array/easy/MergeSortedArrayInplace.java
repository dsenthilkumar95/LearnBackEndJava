package com.improve.programming.array.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MergeSortedArrayInplace {
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
