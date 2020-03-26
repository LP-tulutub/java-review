package com.java.review2.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgramming {
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
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
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
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    /**
     * Input:
     *      nums = {10, 5, 6, 7, 9, 10}
     * Output: 25
     * Explanation:
     *      dp[i] = max(dp[i-2] + nums[i], dp[i-1])
     * condition: 斐波那契数列，强盗在环形街区抢劫
     */
    private static int rob3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robb(nums, 0, n - 2), robb(nums, 1, n - 1));
    }
    private static int robb(int[] nums, int first, int last) {
        int pre2 = 0, pre1 = 0;
        for (int i = first; i <= last; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
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
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = dp[j];        // 只能从上侧走到该位置
                } else if (i == 0) {
                    dp[j] = dp[j - 1];    // 只能从左侧走到该位置
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[n - 1];
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
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
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
        int end = 0;
        for (int i=m; i <= n; i++){
            end += nums[i];
        }
        return end;
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
     *      [2, 3, 4]
     *      [9, 10, 11]
     * condition: 数组区间，数组中等差递增子区间的个数
     */
    private static int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int total = 0;
        for (int cnt : dp) {
            total += cnt;
        }
        return total;
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
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }

    /**
     * Input:
     *      n = 12
     * Output: 3
     * Explanation:
     *      12 → 3 → 12=4+4+4
     *      13 → 2 → 13=4+9
     * condition: 分割整数，按平方数来分割整数
     */
    private static int numSquares(int n) {
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int square : squareList) {
                if (square > i) {
                    break;
                }
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
    private static List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while (square <= n) {
            squareList.add(square);
            square += diff;
            diff += 2;
        }
        return squareList;
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
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;
        for (int num : nums) {
            int index = binarySearch(tails, len, num);
            tails[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }
    private static int binarySearch(int[] tails, int len, int key) {
        int l = 0, h = len;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (tails[m] == key) {
                return m;
            } else if (tails[m] > key) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
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
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
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
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

}
