package com.java.review2.datastructure;

public class BitOperation {
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
        int z = x ^ y;
        int cnt = 0;
        while(z != 0) {
            if ((z & 1) == 1) cnt++;
            z = z >> 1;
        }
        return cnt;
        //return Integer.bitCount(x ^ y);
    }

    /**
     * Input:
     *      nums = {4,1,2,1,2}
     * Output: 4
     * condition: 数组中唯一一个不重复的元素，使用位运算
     */
    private static int singleNumber(int[] nums) {
        int ret = 0;
        for (int n : nums) ret = ret ^ n;
        return ret;
    }

    /**
     * Input:
     *      nums = {3,0,1} //3,2,1
     * Output: 2
     * condition: 找出数组中缺失的那个数，使用位运算
     */
    private static int missingNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ i ^ nums[i];
        }
        return ret ^ nums.length;
    }

    /**
     * Input:
     *      num = {1,10}
     * Output: {10,1}
     * condition: 不用额外变量交换两个整数，使用位运算
     */
    private static int[] exchange(int[] num){
        //a = a ^ b;
        //b = a ^ b;
        //a = a ^ b;
        num[0] = num[0] ^ num[1];
        num[1] = num[0] ^ num[1];
        num[0] = num[0] ^ num[1];
        return num;
    }

    /**
     * Input:
     *      n = 8
     * Output: true
     * condition: 判断一个数是不是2的n次方，使用位运算
     */
    private static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
        //return n > 0 && Integer.bitCount(n) == 1;
    }

    /**
     * Input:
     *      n = 16
     * Output: true
     * condition: 判断一个数是不是4的n次方，使用位运算
     */
    private static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0b01010101010101010101010101010101) != 0;
        //return Integer.toString(num, 4).matches("10*");
    }

}
