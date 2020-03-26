package com.java.review2.practice;


/**
 * 复习情况：3/9 ③ 3/12 ⑦ 3/19 ⑩⑤
 */
public class MathMePractice {
    public static void main(String[] args) {
        MathMePractice mathMe = new MathMePractice();
        // countPrimes
        System.out.println("MathMe: " + mathMe.countPrimes(10));
        // gcd
        System.out.println("gcd: " + mathMe.gcd(10, 15));
        // convertToBase7
        System.out.println("convertToBase7: " + mathMe.convertToBase7(10));
        // toHex
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.println("toHex: " + mathMe.toHex(26, map));
        // convertToTitle
        System.out.println("convertToTitle: " + mathMe.convertToTitle(46));
        // trailingZeroes
        /*System.out.println("trailingZeroes: " + mathMe.trailingZeroes(100));*/
        // addBinary
        System.out.println("addBinary: " + mathMe.addBinary("11", "1"));
        // addStrings
        System.out.println("addStrings: " + mathMe.addStrings("11a", "222"));
        // minMoves2
        int[] nums8 = {1,2,3};
        System.out.println("minMoves2: " + mathMe.minMoves2(nums8));
        // isPerfectSquare
        System.out.println("isPerfectSquare: " + mathMe.isPerfectSquare(16));
        // productExceptSelf
        int[] nums10 = {1,2,3,4};
        int[] ints = mathMe.productExceptSelf(nums10);
        if (ints == null){
            System.out.println("productExceptSelf: null");
        }else {
            System.out.print("productExceptSelf: ");
            for (int num : ints)
                System.out.print(num + " ");
            System.out.println();
        }
        // maximumProduct
        System.out.println("maximumProduct: " + mathMe.maximumProduct(nums10));

    }

    /**
     * Input:
     *      n = 10
     * Output: 4
     * Explanation:
     *      如果 x 整除 y（y mod x == 0），则对于所有 i，mi <= ni
     * condition: 最大公约数最小公倍数，生成素数序列，O(n2)
     */
    public int countPrimes(int n) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      a = 10
     *      b = 15
     * Output: 5
     * Explanation:
     *      最大公约数
     * condition: 最大公约数最小公倍数，最大公约数
     */
    public int gcd(int a, int b) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      num = 10
     * Output: 13
     * Explanation:
     *      7进制
     * condition: 进制转换，7进制
     */
    public String convertToBase7(int num) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      num = 26
     *      map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'}
     * Output: 1a
     * Explanation:
     *      16进制
     * condition: 进制转换，16进制
     */
    public String toHex(int num, char[] map) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      num = 46
     * Output: AT
     * Explanation:
     *      26进制
     * condition: 进制转换，换位运算26进制
     */
    public String convertToTitle(int n) {
        //答题

        return null;//null
    }

    /**break
     * Input:
     *      num = 100
     * Output: 24
     * Explanation:
     *      尾部的 0 由 2 * 5 得来，2 的数量明显多于 5 的数量，因此只要统计有多少个 5 即可
     *      对于一个数 N，它所包含 5 的个数为：N/5 + N/52 + N/53 + ...
     *      其中 N/5 表示不大于 N 的数中 5 的倍数贡献一个 5，N/52 表示不大于 N 的数中 52 的倍数再贡献一个 5 ...
     * condition: 阶乘，统计阶乘尾部有多少个 0
     */
    public int trailingZeroes(int n) {
        return -1;//-1
    }

    /**
     * Input:
     *      a = "11"
     *      b = "1"
     * Output: 100
     * Explanation:
     *      二进制加法
     * condition: 字符串加法减法，二进制加法
     */
    public String addBinary(String a, String b) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      s1 = "11a"
     *      s2 = "222"
     * Output: "381"
     * Explanation:
     *      字符串加法
     * condition: 字符串加法减法，字符串加法
     */
    public String addStrings(String s1, String s2) {
        //答题

        return null;//null
    }

    /**break
     * Input:
     *      nums = {1,2,3}
     * Output: 2
     * Explanation:
     *      [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
     * condition: 相遇问题，改变数组元素使所有的数组元素都相等，O(NLogN)
     */
    public int minMoves2(int[] nums) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      num = 16
     * Output: true
     * Explanation:
     *      平方序列：1,4,9,16,..
     * condition: 其它，平方数
     */
    public boolean isPerfectSquare(int num) {
        //答题

        return false;//false
    }

    /**break
     * Input:
     *      nums = {1,2,3,4}
     * Output: 24 12 8 6
     * Explanation:
     *      1126 1234
     *      给定一个数组，创建一个新数组，新数组的每个元素为原始数组中除了该位置上的元素之外所有元素的乘积
     * condition: 其它，乘积数组，O(n)，不能使用除法
     */
    public int[] productExceptSelf(int[] nums) {
        return null;//null
    }

    /**
     * Input:
     *      nums = {1,2,3,4}
     * Output: 24
     * Explanation:
     *      O(n)
     * condition: 其它，找出数组中的乘积最大的三个数，O(n)
     */
    public int maximumProduct(int[] nums) {
        //答题

        return -1;//-1
    }


}
