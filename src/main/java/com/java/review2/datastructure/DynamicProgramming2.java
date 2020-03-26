package com.java.review2.datastructure;

public class DynamicProgramming2 {
    public static void main(String[] args) {
        // longestCommonSubsequence
        System.out.println("longestCommonSubsequence: " + longestCommonSubsequence("AbcDe", "cDeFgAbcDA"));
        // canPartition
        int[] nums2 = {3, 5, 11, 5, 2};
        System.out.println("canPartition: " + canPartition(nums2));
        // findTargetSumWays
        int[] nums3 = {1, 1, 1, 2, 1};
        System.out.println("findTargetSumWays: " + findTargetSumWays(nums3, 4));
        // findMaxForm
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println("findMaxForm: " + findMaxForm(strs, 5, 3));

    }

    /**
     * Input:
     *      text1 = "AbcDe"
     *      text2 = "cDeFgAbcDA"
     * Output: 4
     * Input:
     *      text1 = "AbcDe"
     *      text2 = "AbcDAcDeFg"
     * Output: 5
     * Explanation:
     *      重复cDe长度为3，AbcD长度为4
     * condition: 最长公共子序列，最长公共子序列
     */
    private static int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    /**
     * Input:
     *      nums = {3, 5, 11, 5, 2}
     * Output: true
     * Explanation:
     *      [3, 5, 5] and [2, 11]
     * condition: 最长公共子序列，划分数组为和相等的两部分
     */
    private static boolean canPartition(int[] nums) {
        int sum = computeArraySum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        for (int num : nums) {                 // 0-1 背包一个物品只能用一次
            for (int i = W; i >= num; i--) {   // 从后往前，先计算 dp[i] 再计算 dp[i-num]
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[W];
    }
    private static int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    /**
     * Input:
     *      nums = {1, 1, 1, 2, 1}
     *      S = 3
     * Output: 4
     * Explanation:
     *      -1+1+1+1+2 = 4
     *      +1-1+1+1+2 = 4
     *      +1+1-1+1+2 = 4
     *      +1+1+1-1+2 = 4
     * condition: 最长公共子序列，改变一组数的正负号使得它们的和为一给定数
     */
    private static int findTargetSumWays(int[] nums, int S) {
        int sum = computeArraySum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        //多个索引→→每个索引值：子集有多少个；每个索引值=子集相加的结果
        return dp[W];
    }

    /**
     * Input:
     *      strs = {"10", "0001", "111001", "1", "0"}
     *      m = 5
     *      n = 3
     * Output: 4
     * Explanation:
     *      "10","0001","1","0"
     * condition: 最长公共子序列，01字符构成最多的字符串
     */
    private static int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {    // 每个字符串只能用一次
            int ones = 0, zeros = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }






}
