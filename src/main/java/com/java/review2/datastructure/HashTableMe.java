package com.java.review2.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableMe {
    public static void main(String[] args) {
        HashTableMe hashTableMe = new HashTableMe();
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
        HashMap<Integer, Integer> indexForNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexForNum.containsKey(target - nums[i])) {
                return new int[]{indexForNum.get(target - nums[i]), i};
            } else {
                indexForNum.put(nums[i], i);
            }
        }
        return null;
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
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
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
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        for (int num : countForNum.keySet()) {
            if (countForNum.containsKey(num + 1)) {
                longest = Math.max(longest, countForNum.get(num + 1) + countForNum.get(num));
            }
        }
        return longest;
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
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums){
            hashMap.put(num, 1);
        }
        for (int num : hashMap.keySet()){
            int numA = num + 1;
            while (hashMap.containsKey(numA)){
                hashMap.put(num, hashMap.get(num) + 1);
                numA++;
            }
        }
        int max = 0;
        for (int num : hashMap.keySet()) {
            max = Math.max(max, hashMap.get(num));
        }
        return max;
    }






}
