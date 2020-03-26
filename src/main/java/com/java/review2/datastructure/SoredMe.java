package com.java.review2.datastructure;

import java.util.*;

public class SoredMe {
    public static void main(String[] args) {
        SoredMe soredMe = new SoredMe();
        // findKthLargest
        int[] nums = {3,2,1,5,6,4};
        System.out.println("findKthLargest: " + soredMe.findKthLargest(nums, 2));
        // topKFrequent
        int[] nums2 = {1,1,1,2,2,3};
        System.out.println("topKFrequent: " + soredMe.topKFrequent(nums2, 2));
        // frequencySort
        System.out.println("frequencySort: " + soredMe.frequencySort("tree"));
        // sortColors
        int[] nums4 = {2,0,2,1,1,0};
        int[] ints = soredMe.sortColors(nums4);
        if (ints == null){
            System.out.println("sortColors: null");
        }else {
            System.out.print("sortColors: ");
            for (int num : ints)
                System.out.print(num);
            System.out.println();
        }

    }

    /**
     * Input:
     *      nums = {3,2,1,5,6,4}
     *      k = 2
     * Output: 5
     * Explanation:
     *      找到倒数第 k 个的元素
     * condition: Kth Element，O(NLogN)
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * Input:
     *      nums = {1,1,1,2,2,3}
     *      k = 2
     * Output: [1,2]
     * Explanation:
     *      设置若干个桶，每个桶存储出现频率相同的数。桶的下标表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i
     * condition: 桶排序，出现频率最多的 k 个元素
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }

    /**
     * Input:
     *      s = "tree"
     * Output: "eert"
     * Explanation:
     *      频数多的在前面
     * condition: 桶排序，按照字符出现次数对字符串排序
     */
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for (char c : s.toCharArray())
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);

        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        for (char c : frequencyForNum.keySet()) {
            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            frequencyBucket[f].add(c);
        }
        StringBuilder str = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    str.append(c);
                }
            }
        }
        return str.toString();
    }

    /**
     * Input:
     *      nums = {2,0,2,1,1,0}
     * Output: 001122
     * Explanation:
     *      只有 0/1/2 三种颜色
     * condition: 荷兰国旗，按颜色进行排序，O(n)
     */
    public int[] sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, --two, one);
            } else {
                ++one;
            }
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }









}
