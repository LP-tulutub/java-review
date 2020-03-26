package com.java.review2.datastructure;

import java.util.Arrays;

public class MathMe {
    public static void main(String[] args) {
        MathMe mathMe = new MathMe();
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
        boolean[] notPrimes = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrimes[i]) {
                continue;
            }
            count++;
            // 从 i * i 开始，因为如果 k < i，那么 k * i 在之前就已经被去除过了
            for (long j = (long) (i) * i; j < n; j += i) {
                notPrimes[(int) j] = true;
            }
        }
        return count;
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
        return b == 0 ? a : gcd(b, a % b);
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
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean isNegative = num < 0;
        if (isNegative) {
            num = -num;
        }
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        String ret = sb.reverse().toString();
        return isNegative ? "-" + ret : ret;
    }

    /**
     * Input:
     *      num = 26
     *      map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'}
     * Output: 1a
     * Explanation:
     *      16进制
     * condition: 进制转换，换位运算16进制
     */
    public String toHex(int num, char[] map) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0b1111]);
            num >>>= 4; // 因为考虑的是补码形式，因此符号位就不能有特殊的意义，需要使用无符号右移，左边填 0
        }
        return sb.reverse().toString();
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
        if (n == 0) {
            return "";
        }
        n--;
        return convertToTitle(n / 26) + (char) (n % 26 + 'A');
    }

    /**
     * Input:
     *      num = 100
     * Output: 24
     * Explanation:
     *      尾部的 0 由 2 * 5 得来，2 的数量明显多于 5 的数量，因此只要统计有多少个 5 即可
     *      对于一个数 N，它所包含 5 的个数为：N/5 + N/5^2 + N/5^3 + ...
     *      其中 N/5 表示不大于 N 的数中 5 的倍数贡献一个 5，N/52 表示不大于 N 的数中 52 的倍数再贡献一个 5 ...
     * condition: 阶乘，统计阶乘尾部有多少个 0
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    /**
     * Input:
     *      a = "11"
     *      b = "1"
     * Output: 24
     * Explanation:
     *      二进制加法
     * condition: 字符串加法减法，二进制加法
     */
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder str = new StringBuilder();
        while (carry == 1 || i >= 0 || j >= 0) {
            if (i >= 0 && a.charAt(i--) == '1') {
                carry++;
            }
            if (j >= 0 && b.charAt(j--) == '1') {
                carry++;
            }
            str.append(carry % 2);
            carry /= 2;
        }
        return str.reverse().toString();
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
    public String addStrings(String num1, String num2) {
        StringBuilder str = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (carry == 1 || i >= 0 || j >= 0) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            str.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return str.reverse().toString();
    }

    /**
     * Input:
     *      nums = {1,2,3}
     * Output: 2
     * Explanation:
     *      [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
     * condition: 相遇问题，改变数组元素使所有的数组元素都相等，O(NLogN)
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int move = 0;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            move += nums[h] - nums[l];
            l++;
            h--;
        }
        return move;
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
        int subNum = 1;
        while (num > 0) {
            num -= subNum;
            subNum += 2;
        }
        return num == 0;
    }

    /**
     * Input:
     *      nums = {1,2,3,4}
     * Output: 24 12 8 6
     * Explanation:
     *      1126 1234
     *      给定一个数组，创建一个新数组，新数组的每个元素为原始数组中除了该位置上的元素之外所有元素的乘积
     * condition: 其它，乘积数组，O(n)，不能使用除法
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];
        Arrays.fill(products, 1);
        int left = 1;
        for (int i = 1; i < n; i++) {
            left *= nums[i - 1];
            products[i] *= left;
        }
        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            products[i] *= right;
        }
        return products;
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
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }


}
