package com.java.review2.practice;

import com.java.review2.datastructure.MathMe;
import com.java.review2.rely.PrintArray;

import java.util.*;

/**
 * 复习情况：3/16 ③ 3/19 ⑦ 3/26 ⑩⑤
 */
public class GreedyAlgorithmMePractice {
    public static void main(String[] args) {
        GreedyAlgorithmMePractice greedy = new GreedyAlgorithmMePractice();
        // findContentChildren
        int[] grid = {1, 3, 2};
        int[] size = {1, 2, 1};
        System.out.println("findContentChildren: " + greedy.findContentChildren(grid, size));
        // eraseOverlapIntervals
        int[][] intervals = {{5,6}, {1,2}, {1,2}, {1,2}, {5,6}};
        System.out.println("eraseOverlapIntervals: " + greedy.eraseOverlapIntervals(intervals));
        // findMinArrowShots
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println("findMinArrowShots: " + greedy.findMinArrowShots(points));
        // reconstructQueue
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] ints4 = greedy.reconstructQueue(people);
        PrintArray.print2Int(ints4, "reconstructQueue");
        // maxProfit
        int[] prices = {1, 2, 3, 7, 6, 3, 9, 5, 6};
        System.out.println("maxProfit: " + greedy.maxProfit(prices));
        // maxProfit2
        System.out.println("maxProfit2: " + greedy.maxProfit2(prices));
        // canPlaceFlowers
        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        System.out.println("canPlaceFlowers: " + greedy.canPlaceFlowers(flowerbed, 1));
        // isSubsequence
        System.out.println("isSubsequence: " + greedy.isSubsequence("abc", "ahbgdc"));
        // checkPossibility
        int[] nums9 = {4, 2, 3};
        System.out.println("checkPossibility: " + greedy.checkPossibility(nums9));
        // maxSubArray
        int[] nums10 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("maxSubArray: " + greedy.maxSubArray(nums10));
        // partitionLabels
        System.out.println("partitionLabels: " + greedy.partitionLabels("ababcbacadefegdehijhklij"));

    }

    /**
     * Input:
     *      grid = {1, 3, 2}
     *      size = {1, 2, 1}
     * Output: 2
     * Explanation:
     *      每个孩子都有一个满足度 grid，每个饼干都有一个大小 size
     *      只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。求解最多可以获得满足的孩子数量
     * condition: 分配饼干，O(NLogN)
     */
    public int findContentChildren(int[] grid, int[] size) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      intervals = {{5,6}, {1,2}, {1,2}, {1,2}, {5,6}}
     * Output: 3
     * Explanation:
     *      计算让一组区间不重叠所需要移除的区间个数
     * condition: 不重叠的区间个数，O(NLogN)
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      points = {{10,16}, {2,8}, {1,6}, {7,12}}
     * Output: 2
     * Explanation:
     *      气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都被刺破
     *      求解最小的投飞镖次数使所有气球都被刺破
     * condition: 投飞镖刺破气球，O(NLogN)
     */
    public int findMinArrowShots(int[][] points) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}
     * Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     * Explanation:
     *      一个学生用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高
     * condition: 根据身高和序号重组队列，O(NLogN)
     */
    public int[][] reconstructQueue(int[][] people) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      prices = {1, 2, 3, 7, 6, 3, 9, 5, 6}
     * Output: 8
     * Explanation:
     *      一次股票交易包含买入和卖出，只进行一次交易，求最大收益
     * condition: 买卖股票最大的收益，O(n)
     */
    public int maxProfit(int[] prices) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      prices = {1, 2, 3, 7, 6, 3, 9, 5, 6}
     * Output: 13
     * Explanation:
     *      可以进行多次交易，多次交易之间不能交叉进行，可以进行多次交易
     * condition: 买卖股票最大的收益II，O(n)
     */
    public int maxProfit2(int[] prices) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      flowerbed = {1, 0, 0, 0, 0, 1}
     *      n = 1
     * Output: true
     * Explanation:
     *      flowerbed 数组中 1 表示已经种下了花朵。花朵之间至少需要一个单位的间隔，求解是否能种下 n 朵花
     * condition: 种植花朵，O(n)
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      s = "abc"
     *      t = "anbgdc"
     * Output: true
     * Explanation:
     *      判断是否为子序列，同样的顺序
     * condition: 判断是否为子序列，O(n)
     */
    public boolean isSubsequence(String s, String t) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      nums = {4, 2, 3}
     * Output: true
     * Explanation:
     *      判断一个数组是否能只修改一个数就成为非递减数组
     * condition: 修改一个数成为非递减数组，O(n)
     */
    public boolean checkPossibility(int[] nums) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
     * Output: 6
     * Explanation:
     *      子数组最大的和，必须是连续的
     * condition: 子数组最大的和，O(n)
     */
    public int maxSubArray(int[] nums) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      s = "ababcbacadefegdehijhklij"
     * Output: [9,7,8]
     * Explanation:
     *      分隔字符串使同种字符出现在一起，"ababcbaca", "defegde", "hijhklij"
     * condition: 分隔字符串使同种字符出现在一起，O(n2)
     */
    public List<Integer> partitionLabels(String s) {
        //答题

        return null;//null
    }


}
