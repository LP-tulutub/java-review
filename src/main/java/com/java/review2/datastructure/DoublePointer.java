package com.java.review2.datastructure;

import com.java.review2.rely.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DoublePointer {
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
     *      target = 9
     * Output: 0,1
     * Explanation:
     *      指针i、j
     * condition: 有序数组的 Two Sum
     */
    private static int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
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
        if (target < 0) return false;
        int i = 0, j = (int) Math.sqrt(target);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == target) {
                return true;
            } else if (powSum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * Input:
     *      s = "leetcode"
     * Output: "leotcede"
     * Explanation:
     *      1 * 1 + 2 * 2 = 5
     * condition: 反转字符串中的元音字符
     */
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    private static String reverseVowels(String s) {
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

    /**
     * Input:
     *      s = "abca"
     * Output: true
     * Explanation:
     *      左右对称特点的字符串，例如 "abcba" 就是一个回文字符串
     * condition: 回文字符串
     */
    private static boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }
    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
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
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
        return nums1;
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
        if (head == null) {
            return false;
        }
        ListNode l1 = head, l2 = head.next;
        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2) {
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
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
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }
    private static boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }






}
