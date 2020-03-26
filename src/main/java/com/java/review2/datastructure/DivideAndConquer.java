package com.java.review2.datastructure;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DivideAndConquer {
    public static void main(String[] args) {
        // diffWaysToCompute
        System.out.println("diffWaysToCompute: " + diffWaysToCompute("2-1-1"));
        
        
    }

    /**
     * Input:
     *      input = "2-1-1"
     * Output: [2, 0]
     * Explanation:
     *      ((2-1)-1) = 0
     *      (2-(1-1)) = 2
     * condition: 给表达式加括号
     */
    private static List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }

    /**
     * Input:
     *      n = 3
     * Output:
     *      [[1,null,3,2],
     *       [3,2,null,1],
     *       [3,1,null,null,2],
     *       [2,1,3],
     *       [1,null,2,null,3]]
     * Explanation:
     *         1         3     3      2      1
     *          \       /     /      / \      \
     *           3     2     1      1   3      2
     *          /     /       \                 \
     *          2     1         2                 3
     * condition: 不同的二叉搜索树
     */



}
