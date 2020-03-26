package com.java.review2.practice;

import java.security.Key;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 复习情况：3/7 ③ 3/10 ⑦ 3/17 ⑩⑤
 */
public class HashTableMePractice {
    public static void main(String[] args) {
        HashTableMePractice hashTableMe = new HashTableMePractice();
        // twoSum
        int[] nums = {1,3,6,9,15};
        int[] twoSum = hashTableMe.twoSum(nums, 10);
        if (twoSum != null){
            System.out.println("twoSum: " + twoSum[0] + "," + twoSum[1]);
        }else {
            System.out.println("twoSum: null");
        }
        // containsDuplicate
        int[] nums2 = {1,3,6,9,15,9};
        System.out.println("containsDuplicate: " + hashTableMe.containsDuplicate(nums2));
        // findLHS
        int[] nums3 = {1,3,2,2,5,2,3,7};
        System.out.println("findLHS: " + hashTableMe.findLHS(nums3));
        // longestConsecutive
        int[] nums4 = {100, 4, 200, 1, 3, 2};
        System.out.println("longestConsecutive: " + hashTableMe.longestConsecutive(nums4));

    }

    /**
     * Input:
     *      nums = {1,3,6,9,15}
     *      target = 10
     * Output: 0,3
     * Explanation:
     *      可以先对数组进行排序，然后使用双指针方法或者二分查找方法，这样做的时间复杂度为 O(NLogN)，空间复杂度为 O(1)
     * condition: 数组中两个数的和为给定值
     */
    private int[] twoSum(int[] nums, int target) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      nums = {1,3,6,9,15,9}
     * Output: true
     * Explanation:
     *      O(n)
     * condition: 判断数组是否含有重复元素
     */
    private boolean containsDuplicate(int[] nums) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      nums = {1,3,2,2,5,2,3,7}
     * Output: 5
     * Explanation:
     *      和谐序列中最大数和最小数之差正好为 1，应该注意的是序列的元素不一定是数组的连续元素
     * condition: 最长和谐序列
     */
    private int findLHS(int[] nums) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      nums = {100, 4, 200, 1, 3, 2}
     * Output: 4
     * Explanation:
     *      [1, 2, 3, 4]长度为4
     * condition: 最长连续序列，O(NLogN)
     */
    private int longestConsecutive(int[] nums) {
        //答题

        return -1;//-1
    }





}
