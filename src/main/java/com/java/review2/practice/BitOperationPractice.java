package com.java.review2.practice;

/**
 * 复习情况：2/29 ③ 3/3 ⑦ 3/10 ⑩⑤ 3/25 ⑩⑤ 4/10 ⑩⑤
 */
public class BitOperationPractice {
    public static void main(String[] args) {
        // hammingDistance
        System.out.println("hammingDistance: " + hammingDistance(1, 4));
        // singleNumber
        int[] nums2 = {4,1,2,1,2};
        System.out.println("singleNumber: " + singleNumber(nums2));
        // missingNumber
        int[] nums3 = {3,0,1};
        System.out.println("missingNumber: " + missingNumber(nums3));
        // exchange
        int[] exchange = exchange(new int[]{1, 10});
        System.out.println("exchange: " + exchange[0] + "," + exchange[1]);
        // isPowerOfTwo
        System.out.println("isPowerOfTwo: " + isPowerOfTwo(8));
        // isPowerOfFour
        System.out.println("isPowerOfFour: " + isPowerOfFour(16));
    }

    /**
     * Input:
     *      x = 1
     *      y = 4
     * Output: 2
     * Explanation:
     *      1   (0 0 0 1)
     *      4   (0 1 0 0)
     *             ↑   ↑
     * condition: 统计两个数的二进制表示有多少位不同，使用位运算
     */
    private static int hammingDistance(int x, int y) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      nums = {4,1,2,1,2}
     * Output: 4
     * condition: 数组中唯一一个不重复的元素，使用位运算
     */
    private static int singleNumber(int[] nums) {
        //答题

        return -1;//-1
    }

    /**break
     * Input:
     *      nums = {3,0,1}
     * Output: 2
     * condition: 找出数组中缺失的那个数，使用位运算
     */
    private static int missingNumber(int[] nums) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      num = {1,10}
     * Output: {10,1}
     * condition: 不用额外变量交换两个整数，使用位运算
     */
    private static int[] exchange(int[] num){
        //答题

        return num;//num
    }

    /**
     * Input:
     *      n = 8
     * Output: true
     * condition: 判断一个数是不是2的n次方，使用位运算
     */
    private static boolean isPowerOfTwo(int n) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      n = 16
     * Output: true
     * condition: 判断一个数是不是4的n次方，使用位运算
     */
    private static boolean isPowerOfFour(int n) {
        //答题

        return false;//false
    }




}
