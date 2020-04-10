package com.java.review2.practice;

import com.java.review2.rely.PrintArray;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 复习情况：3/10 ③ 3/13 ⑦ 3/20 ⑦ 3/27 ⑩⑤
 */
public class ArrayAndMatrixMePractice {
    public static void main(String[] args) {
        ArrayAndMatrixMePractice aAMa = new ArrayAndMatrixMePractice();
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
        //答题

        return null;//null
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
        //答题

        return null;//null
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
        //答题

        return false;//false
    }

    /**
     * Input:
     *      matrix = {{1,5,9}, {10,11,13}, {12,13,15}}
     *      k = 8
     * Output: 13
     * Explanation:
     *      有k个值比我小，则这个值是13
     * condition: 有序矩阵的 Kth Element，O(n2)
     */
    public int kthSmallest(int[][] matrix, int k) {
        //答题

        return -1;//-1
    }

    /**break
     * Input:
     *      nums = {1,2,2,4}
     * Output: [2,3]
     * Explanation:
     *      一个数组元素在 [1, n] 之间，其中一个数被替换为另一个数，找出重复的数和丢失的数
     * condition: 找出重复的数和丢失的数，O(NLogN)
     */
    public int[] findErrorNums(int[] nums) {
        //答题

        return null;//null
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
        //答题

        return -1;//-1
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
        //答题

        return null;//null
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
        //答题

        return -1;//-1
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
        //答题

        return false;//false
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

        return -1;//-1
    }

    /**break
     * Input:
     *      arr = {1,0,2,3,4}
     * Output: 4
     * Explanation:
     *      分割成[1, 0], [2], [3], [4]
     * condition: 分隔数组，O(n)
     */
    public int maxChunksToSorted(int[] arr) {
        // 答题

        return -1;//-1
    }




}
