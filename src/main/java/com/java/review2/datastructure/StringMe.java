package com.java.review2.datastructure;

import java.util.HashMap;

public class StringMe {
    public static void main(String[] args) {
        StringMe stringMe = new StringMe();
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
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (char c : s2.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)-1);
            if (map.get(c) < 0){
                return false;
            }
        }
        return true;
    }

    /**
     * Input:
     *      s = "abcd123"
     *      k = 3
     * Output: "123abcd"
     * Explanation:
     *      将字符串向右循环移动 k 位
     * condition: 字符串循环移位，O(1)
     */
    private String loopRight(String s, int k){

        return s.substring(s.length()-k) + s.substring(0, s.length()-k);
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
        String[] strList = s.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i=strList.length-1; i>=0; i--){
            if (i != 0){
                str.append(strList[i]);
                str.append(" ");
            }else {
                str.append(strList[i]);
            }
        }
        return str;
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
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnts[c - 'a']--;
        }
        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
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
        int[] cnts = new int[256];
        for (char c : s.toCharArray()) {
            cnts[c]++;
        }
        int palindrome = 0;
        for (int cnt : cnts) {
            palindrome += (cnt / 2) * 2;
        }
        if (palindrome < s.length()) {
            palindrome++;   // 这个条件下 s 中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
        }
        return palindrome;
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
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
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
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt = extendSubstrings(s, i, i, cnt);     // 奇数长度
            cnt = extendSubstrings(s, i, i + 1, cnt); // 偶数长度
        }
        return cnt;
    }
    private int extendSubstrings(String s, int start, int end, int cnt) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
        return cnt;
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
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        return x == right || x == right / 10;
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
        int preLen = 0, curLen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }

            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }




}
