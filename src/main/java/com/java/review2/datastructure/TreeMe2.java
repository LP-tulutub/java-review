package com.java.review2.datastructure;

import com.java.review2.rely.TreeNode;

import java.util.*;

public class TreeMe2 {
    public static void main(String[] args) {
        TreeMe2 treeMe2 = new TreeMe2();
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
        List<Double> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            double sum = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ret.add(sum / cnt);
        }
        return ret;
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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
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
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            ret.add(node.val);
            stack.push(node.right);  // 先右后左，保证左子树先遍历
            stack.push(node.left);
        }
        return ret;
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        //答题
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
            list.add(pop.val);
        }

        return list;//null
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
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            ret.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(ret);
        return ret;
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
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ret.add(node.val);
            cur = node.right;
        }
        return ret;
    }
    
    
    
    
}
