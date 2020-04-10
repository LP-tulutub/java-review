package com.java.review2.practice;

/**
 * 复习情况：3/9 ③ 3/12 ⑦ 3/19 ⑩⑤ 4/3 ③⑩
 */

import java.util.*;

public class SoredMePractice {
    public static void main(String[] args) {
        SoredMePractice soredMe = new SoredMePractice();
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
        //答题

        return -1;//-1
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
        //答题

        return null;//null
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
        //答题

        return null;//null
    }

    /**break
     * Input:
     *      nums = {2,0,2,1,1,0}
     * Output: 001122
     * Explanation:
     *      只有 0/1/2 三种颜色
     * condition: 荷兰国旗，按颜色进行排序，O(n)
     */
    public int[] sortColors(int[] nums) {
        //答题

        return null;//null
    }


}
