package com.java.review2.practice;

/**
 * 复习情况：2/29 ③ 3/3 ⑦ 3/10 ⑩⑤ 3/25 ⑩⑤ 4/10 ③⑩
 */
public class DichotomyPractice {
    public static void main(String[] args) {
        // binarySearch
        int[] num = {1,2,3,4,5};
        System.out.println("binarySearch: " + binarySearch(num, 3));
        // mySqrt
        System.out.println("mySqrt: " + mySqrt(8));
        // nextGreatestLetter
        char[] letters = {'c', 'f', 'j', 'z'};
        char target = 'd';
        System.out.println("nextGreatestLetter: " + nextGreatestLetter(letters, target));
        // singleNonDuplicate
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("singleNonDuplicate: " + singleNonDuplicate(nums));
        // findMin
        int[] nums2 = {3,4,5,1,2};
        System.out.println("findMin: " + findMin(nums2));
        // searchRange
        int[] nums3 = {5,7,7,8,8,10};
        int[] ints3 = searchRange(nums3, 8);
        System.out.println("searchRange: " + ints3[0] + "," + ints3[ints3.length-1]);
    }

    /**
     * Input:
     *      nums = {1,2,3,4,5}
     *      key = 3
     * Output: 2
     * condition: 二分法实现查找索引
     */
    private static int binarySearch(int[] nums, int key) {
        //答题

        return -1;
    }

    /**
     * Input:
     *      x = 8
     * Output: 2.8284
     * condition: 二分法实现求开方，保留4位小数
     */
    private static double mySqrt(int x) {
        //答题

        return -1.0;
    }

    /**
     * Input:
     *      letters = {'c', 'f', 'j', 'z'}
     *      target = 'd'
     * Output: f
     * condition: 找出大于target的最小字符
     */
    private static char nextGreatestLetter(char[] letters, char target) {
        //答题

        return '-';//'-'
    }

    /**
     * Input:
     *      nums = {1, 1, 2, 3, 3, 4, 4, 8, 8}
     * Output: 2
     * condition: 一个有序数组只有一个数不出现两次，找出这个数，O(logN)时间复杂度
     */
    private static int singleNonDuplicate(int[] nums) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      nums = {3,4,5,1,2}
     * Output: 1
     * condition: 找出最小的数，O(logN)时间复杂度
     */
    private static int findMin(int[] nums) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      nums = {5,7,7,8,8,10}
     *      target = 8
     * Output: [3,4]
     * Input:
     *      nums = {5,7,7,8,8,10}
     *      target = 6
     * Output: [-1,-1]
     * condition: 查找区间，O(logN)时间复杂度
     */
    private static int[] searchRange(int[] nums, int target) {
        //答题

        return nums;//nums
    }
    private static int findFirst(int[] nums, int target) {
        //答题

        return -1;//-1
    }





}

