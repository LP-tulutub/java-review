package com.java.review2.practice;

import jdk.nashorn.internal.ir.IfNode;

import java.sql.Ref;
import java.util.HashMap;

/**
 * 复习情况：3/7 ③ 3/10 ⑦ 3/17 ⑩⑤
 */
public class StringMePractice {
    public static void main(String[] args) {
        StringMePractice stringMe = new StringMePractice();
        // loopContain
        System.out.println("loopContain: " + stringMe.loopContain("AABCD", "CDAA"));
        // loopRight
        System.out.println("loopRight: " + stringMe.loopRight("abcd123", 3));
        // reverseWords
        System.out.println("reverseWords: " + stringMe.reverseWords("I am a student"));
        // isAnagram
        System.out.println("isAnagram: " + stringMe.isAnagram("anagram", "nagaram"));
        // longestPalindrome
        System.out.println("longestPalindrome: " + stringMe.longestPalindrome("abcccccdd"));
        // isIsomorphic
        System.out.println("isIsomorphic: " + stringMe.isIsomorphic("paper", "title"));
        // countSubstrings
        System.out.println("countSubstrings: " + stringMe.countSubstrings("aaa"));
        // isPalindrome
        System.out.println("isPalindrome: " + stringMe.isPalindrome(101));
        // countBinarySubstrings
        System.out.println("countBinarySubstrings: " + stringMe.countBinarySubstrings("00110011"));

    }

    /**
     * Input:
     *      s1 = "AABCD"
     *      s2 = "CDAA"
     * Output: true
     * Explanation:
     *      给定两个字符串 s1 和 s2，要求判定 s2 是否能够被 s1 做循环移位得到的字符串包含
     * condition: 字符串循环移位包含，O(n)
     */
    private boolean loopContain(String s1, String s2){
        //答题

        return false;//false
    }

    /**
     * Input:
     *      s = "abcd123"
     *      k = 3
     * Output: "123abcd"
     * Explanation:
     *      将字符串向右循环移动 k 位
     * condition: 字符串循环移位
     */
    private String loopRight(String s, int k){
        //答题

        return null;//null
    }

    /**
     * Input:
     *      s = "I am a student"
     * Output: "student a am I"
     * Explanation:
     *      将每个单词翻转，然后将整个字符串翻转
     * condition: 字符串单词的翻转，O(n)
     */
    private StringBuilder reverseWords(String s){
        //答题

        return null;//null
    }

    /**
     * Input:
     *      s = "anagram"
     *      t = "nagaram"
     * Output: true
     * Explanation:
     *      可以使用长度为 26 的整型数组对字符串出现的字符进行统计，也可以使用HashMap
     * condition: 两个字符串包含的字符是否完全相同，O(n)
     */
    private boolean isAnagram(String s, String t) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      s = "abccccdd"
     * Output: 7
     * Explanation:
     *      最长的回文字符为"dccaccd"长度为7
     * condition: 计算一组字符集合可以组成的回文字符串的最大长度，O(n)
     */
    private int longestPalindrome(String s) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      s = "paper"
     *      t = "title"
     * Output: true
     * Explanation:
     *      记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构
     * condition: 字符串同构，O(n)
     */
    private boolean isIsomorphic(String s, String t) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      s = "aaa"
     * Output: 6
     * Explanation:
     *      "a", "a", "a", "aa", "aa", "aaa"
     * condition: 回文子字符串个数，O(n2)
     */
    private int countSubstrings(String s) {
        //答题

        return -1;//-1
    }
    private int extendSubstrings(String s, int start, int end, int cnt) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      x = 101
     * Output: true
     * Explanation:
     *      将整数分成左右两部分，右边那部分需要转置，然后判断这两部分是否相等
     * condition: 判断一个整数是否是回文数，O(n)，要求不能使用额外空间，也就不能将整数转换为字符串进行判断
     */
    private boolean isPalindrome(int x) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      s = "00110011"
     * Output: 6
     * Explanation:
     *      "0011", "01", "1100", "10", "0011", "01"共6个
     * condition: 统计二进制字符串中连续 1 和连续 0 数量相同的子字符串个数，O(n)
     */
    private int countBinarySubstrings(String s) {
        //答题

        return -1;//-1
    }


}
