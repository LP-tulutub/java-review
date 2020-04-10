package com.java.review2.practice;

import com.java.review2.rely.TreeNode;

import java.util.*;

/**
 * 复习情况：3/14 ③ 3/17 ④ 3/21 ⑦ 3/28 ⑦ 4/4 ⑩⑤
 */
public class TreeMePractice2 {
    public static void main(String[] args) {
        TreeMePractice2 treeMe2 = new TreeMePractice2();
        // averageOfLevels
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(12);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(4);
        System.out.println("averageOfLevels: " + treeMe2.averageOfLevels(root));
        // findBottomLeftValue
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(6);
        root2.right.left.left = new TreeNode(7);
        System.out.println("findBottomLeftValue: " + treeMe2.findBottomLeftValue(root2));
        // preorderTraversal
        root2.right.left.left = null;
        System.out.println("preorderTraversal: " + treeMe2.preorderTraversal(root2));
        // postorderTraversal
        System.out.println("postorderTraversal: " + treeMe2.postorderTraversal(root2));
        // inorderTraversal
        System.out.println("inorderTraversal: " + treeMe2.inorderTraversal(root2));

    }

    /**
     * Input:
     *      TreeNode root = new TreeNode(1);
     *      root.left = new TreeNode(2);
     *      root.left.left = new TreeNode(3);
     *      root.right = new TreeNode(12);
     *      root.left.right = new TreeNode(5);
     *      root.left.left.left = new TreeNode(4);
     * Output: [1.0, 7.0, 4.0, 4.0]
     * Explanation:
     *          1
     *         / \
     *        2  12
     *       / \
     *      3   5
     *     /
     *    4
     * condition: 层次遍历，一棵树每层节点的平均数
     */
    public List<Double> averageOfLevels(TreeNode root) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      TreeNode root2 = new TreeNode(1);
     *      root2.left = new TreeNode(2);
     *      root2.right = new TreeNode(3);
     *      root2.left.left = new TreeNode(4);
     *      root2.right.left = new TreeNode(5);
     *      root2.right.right = new TreeNode(6);
     *      root2.right.left.left = new TreeNode(7);
     * Output: 7
     * Explanation:
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   5   6
     *        /
     *       7
     * condition: 层次遍历，得到左下角的节点
     */
    public int findBottomLeftValue(TreeNode root) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      TreeNode root2 = new TreeNode(1);
     *      root2.left = new TreeNode(2);
     *      root2.right = new TreeNode(3);
     *      root2.left.left = new TreeNode(4);
     *      root2.right.left = new TreeNode(5);
     *      root2.right.right = new TreeNode(6);
     * Output: [1, 2, 4, 3, 5, 6]
     * Explanation:
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   5   6
     * condition: 层次遍历，前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      TreeNode root2 = new TreeNode(1);
     *      root2.left = new TreeNode(2);
     *      root2.right = new TreeNode(3);
     *      root2.left.left = new TreeNode(4);
     *      root2.right.left = new TreeNode(5);
     *      root2.right.right = new TreeNode(6);
     * Output: [4, 2, 5, 6, 3, 1]
     * Explanation:
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   5   6
     * condition: 层次遍历，后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      TreeNode root2 = new TreeNode(1);
     *      root2.left = new TreeNode(2);
     *      root2.right = new TreeNode(3);
     *      root2.left.left = new TreeNode(4);
     *      root2.right.left = new TreeNode(5);
     *      root2.right.right = new TreeNode(6);
     * Output: [4, 2, 1, 5, 3, 6]
     * Explanation:
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   5   6
     * condition: 层次遍历，中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        //答题

        return null;//null
    }

}
