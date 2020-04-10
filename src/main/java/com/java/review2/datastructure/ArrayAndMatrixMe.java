package com.java.review2.datastructure;

import com.java.review2.rely.PrintArray;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayAndMatrixMe {
    public static void main(String[] args) {
        ArrayAndMatrixMe aAMa = new ArrayAndMatrixMe();
        // moveZeroes
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("moveZeroes: " + aAMa.moveZeroes(nums1));
        // matrixReshape
        int[][] nums2 = {{1,2}, {3,4}};
        int[][] ints2 = aAMa.matrixReshape(nums2, 1, 4);
        if (ints2 == null){
            System.out.println("matrixReshape: null");
        }else {
            System.out.print("matrixReshape: [");
            for (int[] in : ints2){
                System.out.print(Arrays.stream(in).boxed().collect(Collectors.toList()));
            }
            System.out.println("]");
        }
        // searchMatrix
        int[][] matrix = {{1,5,9}, {10,11,13}, {12,13,15}};
        System.out.println("searchMatrix: " + aAMa.searchMatrix(matrix, 13));
        // kthSmallest
        System.out.println("kthSmallest: " + aAMa.kthSmallest(matrix, 8));
        // findErrorNums
        int[] nums5 = {1,2,2,4};
        int[] ints5 = aAMa.findErrorNums(nums5);
        PrintArray.printInt(ints5, "findErrorNums");
        // findDuplicate
        System.out.println("findDuplicate: " + aAMa.findDuplicate(nums5));
        // constructArray
        int[] ints7 = aAMa.constructArray(5, 3);
        PrintArray.printInt(ints7, "constructArray");
        // findShortestSubArray
        int[] nums8 = {1,2,2,3,1,4,2};
        System.out.println("findShortestSubArray: " + aAMa.findShortestSubArray(nums8));
        // isToeplitzMatrix
        int[][] matrix9 = {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}};
        System.out.println("isToeplitzMatrix: " + aAMa.isToeplitzMatrix(matrix9));
        // arrayNesting
        int[] nums10 = {5,4,0,3,1,6,2};
        System.out.println("arrayNesting: " + aAMa.arrayNesting(nums10));
        // maxChunksToSorted
        int[] arr11 = {1,0,2,3,4};
        System.out.println("maxChunksToSorted: " + aAMa.maxChunksToSorted(arr11));

    }

    /**
     * Input:
     *      nums = {0, 1, 0, 3, 12}
     * Output: [1, 3, 12, 0, 0]
     * Explanation:
     *      数组变列表 Arrays.stream(nums).boxed().collect(Collectors.toList())
     * condition: 把数组中的 0 移到末尾，O(n)
     */
    public List<Integer> moveZeroes(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    /**
     * Input:
     *      nums = {{1,2}, {3,4}}
     *      r = 1
     *      c = 4
     * Output: {{1,2,3,4}}
     * Explanation:
     *      数组变换
     * condition: 改变矩阵维度，O(n2)
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] reshapedNums = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshapedNums[i][j] = nums[index / n][index % n];
                index++;
            }
        }
        return reshapedNums;
    }

    /**
     * Input:
     *      matrix = {{1,5,9}, {10,11,13}, {12,13,15}}
     *      target = 13
     * Output: true
     * Explanation:
     *      查找矩阵是否有某个数
     * condition: 有序矩阵查找，O(n)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (target == matrix[row][col]) return true;
            else if (target < matrix[row][col]) col--;
            else row++;
        }
        return false;
    }

    /**
     * Input:
     *      matrix = {{1,5,9}, {10,11,13}, {12,13,15}}
     *      k = 8
     * Output: 13
     * Explanation:
     *      有k个值比我小，则这个值是13
     * condition: 有序矩阵的 Kth Element，O(N2LogN)
     */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
    public int kthSmallest2(int[][] matrix, int k) {
        //答题
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<matrix.length; i++)
            list.addAll(Arrays.stream(matrix[i]).boxed().collect(Collectors.toList()));
        Collections.sort(list);

        return list.get(k-1);
    }

    /**
     * Input:
     *      nums = {1,2,2,4}
     * Output: [2,3]
     * Explanation:
     *      一个数组元素在 [1, n] 之间，其中一个数被替换为另一个数，找出重复的数和丢失的数
     * condition: 找出重复的数和丢失的数，O(NLogN)
     */
    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * Input:
     *      nums = {1,2,2,4}
     * Output: 2
     * Explanation:
     *      找出数组中重复的数，数组值在 [1, n] 之间
     * condition: 找出数组中重复的数，数组值在 [1, n] 之间，O(NLogN)
     */
    public int findDuplicate(int[] nums) {
        int l = 1, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) cnt++;
            }
            if (cnt > mid) h = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    /**
     * Input:
     *      n = 5
     *      k = 3
     * Output: [1,4,2,3,5]
     * Explanation:
     *      数组元素为 1~n 的整数，要求构建数组，使得相邻元素的差值不相同的个数为 k
     * condition: 数组相邻差值的个数，O(n)
     */
    public int[] constructArray(int n, int k) {
        int[] ret = new int[n];
        ret[0] = 1;
        for (int i = 1, interval = k; i <= k; i++, interval--) {
            ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
        }
        for (int i = k + 1; i < n; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }

    /**
     * Input:
     *      nums = {1,2,2,3,1,4,2}
     * Output: 6
     * Explanation:
     *      数组的度定义为元素出现的最高频率，例如上面的数组度为 3。要求找到一个最小的子数组，这个子数组的度和原数组一样
     *      6(2最后索引) - 1(2第一个索引) + 1
     * condition: 数组的度，O(n)
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> numsCnt = new HashMap<>();
        Map<Integer, Integer> numsLastIndex = new HashMap<>();
        Map<Integer, Integer> numsFirstIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numsCnt.put(num, numsCnt.getOrDefault(num, 0) + 1);
            numsLastIndex.put(num, i);
            if (!numsFirstIndex.containsKey(num)) {
                numsFirstIndex.put(num, i);
            }
        }
        int maxCnt = 0;
        for (int num : nums) {
            maxCnt = Math.max(maxCnt, numsCnt.get(num));
        }
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int cnt = numsCnt.get(num);
            if (cnt != maxCnt) continue;
            ret = Math.min(ret, numsLastIndex.get(num) - numsFirstIndex.get(num) + 1);
        }
        return ret;
    }

    /**
     * Input:
     *      matrix = {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}}
     * Output: true
     * Explanation:
     *      "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"
     * condition: 对角元素相等的矩阵，O(n2)
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (!check(matrix, matrix[0][i], 0, i)) {
                return false;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (!check(matrix, matrix[i][0], i, 0)) {
                return false;
            }
        }
        return true;
    }
    private boolean check(int[][] matrix, int expectValue, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length) {
            return true;
        }
        if (matrix[row][col] != expectValue) {
            return false;
        }
        return check(matrix, expectValue, row + 1, col + 1);
    }
    public boolean isToeplitzMatrix2(int[][] matrix) {
        //答题
        int end = 0;
        for (int i=0; i<matrix[0].length; i++){
            int val = matrix[0][i];
            for (int j=0; j< Math.min(matrix.length, matrix[0].length-i); j++){
                if (val == matrix[j][j+i]){
                    end++;
                }
            }
        }
        for (int i=0; i<matrix.length; i++){
            int val = matrix[i][0];
            for (int j=0; j< matrix.length-i; j++){
                if (val == matrix[j+i][j]){
                    end++;
                }
            }
        }

        return end == (matrix.length)*(matrix[0].length+1);
    }

    /**
     * Input:
     *      nums = {5,4,0,3,1,6,2}
     * Output: 4
     * Explanation:
     *      S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
     * condition: 嵌套数组，O(n2)
     */
    public int arrayNesting(int[] nums) {
        //答题
        int max = Integer.MIN_VALUE;
        for (int num : nums){
            int gd = 0;
            int wn = -1;
            while (wn != num){
                wn = wn == -1 ? nums[num] : nums[wn];
                gd++;
            }
            max = Math.max(max, gd);
        }
        return max;
    }

    /**
     * Input:
     *      arr = {1,0,2,3,4}
     * Output: 4
     * Explanation:
     *      分割成[1, 0], [2], [3], [4]
     * condition: 分隔数组，O(n)
     */
    public int maxChunksToSorted(int[] arr) {
        if (arr == null) return 0;
        int ret = 0;
        int right = arr[0];
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
            if (right == i) ret++;
        }
        return ret;
    }



}
