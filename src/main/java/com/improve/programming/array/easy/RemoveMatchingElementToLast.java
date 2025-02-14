package com.improve.programming.array.easy;

public class RemoveMatchingElementToLast {

    /* Question
    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
    The order of the elements may be changed.
    Then return the number of elements in nums which are not equal to val.

    Consider the number of elements in nums which are not equal to val be k,
    to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
    The remaining elements of nums are not important as well as the size of nums.

    Return k.
    */

    /*
    Example 1:

    Input: nums = [3,2,2,3], val = 3
    Output: 2, nums = [2,2,_,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 2.
    It does not matter what you leave beyond the returned k (hence they are underscores).
    Example 2:

    Input: nums = [0,1,2,2,3,0,4,2], val = 2
    Output: 5, nums = [0,1,4,0,3,_,_,_]
    Explanation: Your function should return k = 5,
    with the first five elements of nums containing 0, 0, 1, 3, and 4.
    Note that the five elements can be returned in any order.
    It does not matter what you leave beyond the returned k (hence they are underscores).


    Constraints:

    0 <= nums.length <= 100
    0 <= nums[i] <= 50
    0 <= val <= 100
    */
    public int removeElement(int[] nums, int val) {
        int i=0;
        int j=nums.length-1;
        while (i<nums.length && j>-1 && i<=j) {
            while(i<nums.length && nums[i] != val){
                i++;
            }
            while(j>-1 && nums[j] == val) {
                j--;
            }
            if (i<j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return i;
    }

    public int givenRemoveElementNotEffectiveThanMe(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        RemoveMatchingElementToLast r = new RemoveMatchingElementToLast();
        int[] nums = {3,2,2,3};
        int val = 3;
        int[] nums1 = {2};
        int val1 = 3;
        System.out.println(r.removeElement(nums1, val1));
    }

    /*I found the most effective solution using two pointers and while loops takings as much less time
    * as possible compared to O(n) Solution given.*/
}
