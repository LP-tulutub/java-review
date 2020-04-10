package com.java.review2.practice;

import com.java.review2.rely.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 复习情况：3/5 ③ 3/8 ⑦ 3/15 ⑩⑤ 3/30 ③⑩
 */
public class DoublePointerPractice {
    public static void main(String[] args) {
        // twoSum
        int[] numbers = {2, 7, 11, 15};
        int target = 18;
        System.out.println("twoSum: " + twoSum(numbers, target)[0] + "," + twoSum(numbers, target)[1]);
        // judgeSquareSum
        System.out.println("judgeSquareSum: " + judgeSquareSum(5));
        // reverseVowels
        System.out.println("reverseVowels: " + reverseVowels("leetcode"));
        // validPalindrome
        System.out.println("validPalindrome: " + validPalindrome("acbca"));
        // merge
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int[] merge = merge(nums1, 3, nums2, 3);
        System.out.print("merge: ");
        if (merge != null){
            for (int num : merge){
                System.out.print(" " + num);
            }
        }
        System.out.println();
        // hasCycle
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println("hasCycle: " + hasCycle(node1));
        // findLongestWord
        System.out.println("findLongestWord: " + findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));

    }

    /**
     * Input:
     *      numbers = {2, 7, 11, 15}
     *      target = 18
     * Output: 1,2
     * Explanation:
     *      指针i、j
     * condition: 有序数组的 Two Sum
     */
    private static int[] twoSum(int[] numbers, int target) {
        //答题

        return numbers;//numbers
    }

    /**
     * Input:
     *      target = 5
     * Output: true
     * Explanation:
     *      1 * 1 + 2 * 2 = 5
     * condition: 两数平方和
     */
    private static boolean judgeSquareSum(int target) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      s = "leetcode"
     * Output: "leotcede"
     * Explanation:
     * condition: 反转字符串中的元音字符
     */
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    private static String reverseVowels(String s) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      s = "acbca"
     * Output: true
     * Explanation:
     *      左右对称特点的字符串，例如 "abcba" 就是一个回文字符串
     * condition: 回文字符串
     */
    private static boolean validPalindrome(String s) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      nums1 = {1,2,3,0,0,0}
     *      m = 3
     *      nums2 = {2,5,6}
     *      n = 3
     * Output: [1,2,2,3,5,6]
     * Explanation:
     *      有序合并数组
     * condition: 归并两个有序数组
     */
    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      ListNode node1 = new ListNode();
     *      ListNode node2 = new ListNode();
     *      ListNode node3 = new ListNode();
     *      node1.next = node2;
     *      node2.next = node3;
     *      node3.next = node1;
     * Output: true
     * Explanation:
     *      一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇
     * condition: 判断链表是否存在环
     */
    private static boolean hasCycle(ListNode head) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      s = "abpcplea"
     *      d = ["ale","apple","monkey","plea"]
     * Output: "apple"
     * Explanation:
     *      删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串
     * condition: 最长子序列
     */
    private static String findLongestWord(String s, List<String> d) {
        //答题

        return null;//null
    }
    private static boolean isSubstr(String s, String target) {
        //答题

        return false;//false
    }







}
