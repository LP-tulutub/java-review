package com.java.review2.datastructure;

import com.java.review2.rely.PrintArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GreedyAlgorithmMe {
    public static void main(String[] args) {
        GreedyAlgorithmMe greedy = new GreedyAlgorithmMe();
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
        if (grid == null || size == null) return 0;
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
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
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
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
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
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
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
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
        int n = prices.length;
        if (n == 0) return 0;
        int soFarMin = prices[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (soFarMin > prices[i]) soFarMin = prices[i];
            else max = Math.max(max, prices[i] - soFarMin);
        }
        return max;
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
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
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
        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < len && cnt < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
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
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
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
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            cnt++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
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
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1; i < nums.length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }

    /**
     * Input:
     *      s = "ababcbacadefegdehijhklij"
     * Output: [9,7,8]
     * Explanation:
     *      分隔字符串使同种字符出现在一起，"ababcbaca", "defegde", "hijhklij"
     * condition: 分隔字符串使同种字符出现在一起，O(n2)
     */
    public List<Integer> partitionLabels(String S) {
        int[] lastIndexsOfChar = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndexsOfChar[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < S.length()) {
            int lastIndex = firstIndex;
            for (int i = firstIndex; i < S.length() && i <= lastIndex; i++) {
                int index = lastIndexsOfChar[S.charAt(i) - 'a'];
                if (index > lastIndex) {
                    lastIndex = index;
                }
            }
            partitions.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return partitions;
    }



}
