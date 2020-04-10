package com.java.review2.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

/**
 * 复习情况：3/3 ③ 3/6 ⑦ 3/13 ⑩⑤ 3/28 ⑩⑤
 */
public class DynamicProgrammingPractice {
    public static void main(String[] args) {
        // climbStairs
        System.out.println("climbStairs: " + climbStairs(10));
        // rob
        int[] nums2 = {10, 5, 6, 7, 9, 10};
        System.out.println("rob: " + rob(nums2));
        // rob3
        System.out.println("rob3: " + rob3(nums2));
        // minPathSum
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println("minPathSum: " + minPathSum(grid));
        // uniquePaths
        System.out.println("uniquePaths: " + uniquePaths(3, 8));
        // sumRange
        int[] nums6 = {-2, 0, 3, -5, 2, -1};
        System.out.println("sumRange: " + sumRange(nums6, 0, 2));
        // numberOfArithmeticSlices
        int[] A = {0, 1, 2, 3, 4, 9, 10, 11};
        System.out.println("numberOfArithmeticSlices: " + numberOfArithmeticSlices(A));
        // integerBreak
        System.out.println("integerBreak: " + integerBreak(10));
        // numSquares
        System.out.println("numSquares: " + numSquares(12));
        // lengthOfLIS
        int[] nums10 = {2, 7, 4, 3, 6, 5};
        System.out.println("lengthOfLIS: " + lengthOfLIS(nums10));
        // findLongestChain
        int[][] pairs = {{1,2}, {2,3}, {3,4}, {7,8}};
        System.out.println("findLongestChain: " + findLongestChain(pairs));
        // wiggleMaxLength
        int[] nums12 = {1,17,5,10,13,15,10,5,16,8};
        System.out.println("wiggleMaxLength:" + wiggleMaxLength(nums12));
    }

    /**
     * Input:
     *      n = 10
     * Output: 89
     * Explanation:
     *      dp[i] = dp[i-1] + dp[i-2]
     * condition: 斐波那契数列，爬楼梯，返回第n个数的值
     */
    private static int climbStairs(int n) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      nums = {10, 5, 6, 7, 9, 10}
     * Output: 27
     * Explanation:
     *      dp[i] = max(dp[i-2] + nums[i], dp[i-1])
     * condition: 斐波那契数列，强盗抢劫，返回第nums.length结果
     */
    private static int rob(int[] nums) {
        //答题

        return -1;//-1
    }

    /**break
     * Input:
     *      nums = {10, 5, 6, 7, 9, 10}
     * Output: 25
     * Explanation:
     *      dp[i] = max(dp[i-2] + nums[i], dp[i-1])
     * condition: 斐波那契数列，强盗在环形街区抢劫
     */
    private static int rob3(int[] nums) {
        //答题

        return -1;//-1
    }
    private static int robb(int[] nums, int first, int last) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      grid = {{1,3,1},
     *              {1,5,1},
     *              {4,2,1}}
     * Output: 7
     * Explanation:
     *      [[1,3,1],
     *       [1,5,1],
     *       [4,2,1]]
     * condition: 矩阵路径，矩阵的最小路径和
     */
    private static int minPathSum(int[][] grid) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      m = 3
     *      n = 8
     * Output: 36
     * Explanation:
     * condition: 矩阵路径，矩阵的总路径数
     */
    private static int uniquePaths(int m, int n) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      nums = {-2, 0, 3, -5, 2, -1}
     *      m = 0
     *      n = 2
     * Output: 1
     * Explanation:
     *      sumRange(0, 2) -> 1
     *      sumRange(2, 5) -> -1
     *      sumRange(0, 5) -> -3
     * condition: 数组区间，数组区间和
     */
    private static int sumRange(int[] nums, int m, int n) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      A = {0, 1, 2, 3, 4, 9, 10, 11}
     * Output: 7
     * Explanation:
     *      [0, 1, 2],
     *      [1, 2, 3],
     *      [0, 1, 2, 3],
     *      [0, 1, 2, 3, 4],
     *      [1, 2, 3, 4],
     *      [2, 3, 4],
     *      [9, 10, 11]
     * condition: 数组区间，数组中等差递增子区间的个数
     */
    private static int numberOfArithmeticSlices(int[] A) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      n = 10
     * Output: 36
     * Explanation:
     *      2 → (2=1+1) → 1
     *      10 → (10=3+3+4) → 36
     * condition: 分割整数，分割整数的最大乘积
     */
    private static int integerBreak(int n) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      n = 12
     * Output: 3
     * Explanation:
     *      12 → 3 → 12=4+4+4
     *      13 → 2 → 13=4+9
     * condition: 分割整数，按平方数来分割整数最小个数
     */
    private static int numSquares(int n) {
        //答题

        return -1;//-1
    }
    private static List<Integer> generateSquareList(int n) {
        //答题
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=100; i++){
            if (i*i > n){
                return list;
            }
            list.add(i*i);
        }
        return null;//null
    }

    /**
     * Input:
     *      nums = {2, 7, 4, 3, 6, 5}
     * Output: 3
     * Input:
     *      nums = {4, 3, 6, 5}
     * Output: 2
     * Explanation:
     *      tails      len      num
     *      []         0        4
     *      [4]        1        3
     *      [3]        1        6
     *      [3,6]      2        5
     *      [3,5]      2        null
     * condition: 最长递增子序列，最长递增子序列
     */
    private static int lengthOfLIS(int[] nums) {
        //答题


        return -1;//-1
    }
    private static int binarySearch(int[] tails, int len, int key) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      pairs = {{1,2}, {2,3}, {3,4}, {7,8}}
     * Output: 3
     * Explanation:
     *      [1,2] -> [3,4] -> [7,8]
     * condition: 最长递增子序列，一组整数对能够构成的最长链
     */
    private static int findLongestChain(int[][] pairs) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      nums = {1,2,3,4,5,6,7,8,9}
     * Output: 2
     * Input:
     *      nums = {1,17,5,10,13,15,10,5,16,8}
     * Output: 7
     * Explanation:
     * condition: 最长递增子序列，最长摆动子序列
     */
    private static int wiggleMaxLength(int[] nums) {
        //答题

        return -1;//-1
    }



}
