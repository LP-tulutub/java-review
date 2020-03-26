package com.java.review2.practice;

import com.java.review2.rely.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 复习情况：3/13 ③ 3/16 ⑤ 3/21 ⑧
 */
public class TreeMePractice {
    public static void main(String[] args) {
        TreeMePractice treeMe = new TreeMePractice();
        // maxDepth
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println("maxDepth: " + treeMe.maxDepth(root));
        // isBalanced
        root.right = new TreeNode(12);
        System.out.println("isBalanced: " + treeMe.isBalanced(root));
        // diameterOfBinaryTree
        root.left.right = new TreeNode(5);
        System.out.println("diameterOfBinaryTree: " + treeMe.diameterOfBinaryTree(root));
        // invertTree
        root.left.left.left = new TreeNode(4);
        TreeNode tree4 = treeMe.invertTree(root);
        if (tree4 !=null){
            System.out.println("invertTree: " + tree4 + tree4.left + tree4.right + tree4.right.left);
        }else {
            System.out.println("invertTree: null");
        }
        // mergeTrees
        TreeNode root2 = new TreeNode(100);
        if (treeMe.mergeTrees(root, root2) != null){
            System.out.println("mergeTrees: " + treeMe.mergeTrees(root, root2).val);
        }else {
            System.out.println("mergeTrees: null");
        }
        // hasPathSum
        System.out.println("hasPathSum: " + treeMe.hasPathSum(root, 8));
        // pathSum
        System.out.println("pathSum: " + treeMe.pathSum(root, 8));
        // isSubtree
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.right = new TreeNode(3);
        s.right.left = new TreeNode(4);
        s.right.right = new TreeNode(5);
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(4);
        t.right = new TreeNode(5);
        System.out.println("isSubtree: " + treeMe.isSubtree(s, t));
        // isSymmetric
        TreeNode root9 = new TreeNode(1);
        root9.left = new TreeNode(2);
        root9.right = new TreeNode(2);
        root9.left.left = new TreeNode(3);
        root9.left.right = new TreeNode(4);
        root9.right.left = new TreeNode(4);
        root9.right.right = new TreeNode(3);
        System.out.println("isSymmetric: " + treeMe.isSymmetric(root9));
        // minDepth
        System.out.println("minDepth: " + treeMe.minDepth(root));
        // sumOfLeftLeaves
        System.out.println("sumOfLeftLeaves: " + treeMe.sumOfLeftLeaves(root));
        // longestUnivaluePath
        TreeNode root12 = new TreeNode(1);
        root12.left = new TreeNode(4);
        root12.right = new TreeNode(5);
        root12.left.left = new TreeNode(4);
        root12.left.right = new TreeNode(4);
        root12.right.right = new TreeNode(5);
        System.out.println("longestUnivaluePath: " + treeMe.longestUnivaluePath(root12));
        // rob
        TreeNode root13 = new TreeNode(3);
        root13.left = new TreeNode(2);
        root13.right = new TreeNode(3);
        root13.left.right = new TreeNode(3);
        root13.right.right = new TreeNode(1);
        System.out.println("rob: " + treeMe.rob(root13));
        // findSecondMinimumValue
        TreeNode root14 = new TreeNode(2);
        root14.left = new TreeNode(2);
        root14.right = new TreeNode(5);
        root14.right.left = new TreeNode(5);
        root14.right.right = new TreeNode(7);
        treeMe.findSecondMinimumValue(root14);
        if (treeMe.listFindSecondMinimumValue.toString().equals("[]")){
            System.out.println("findSecondMinimumValue: null");
        }else {
            System.out.println("findSecondMinimumValue: " + treeMe.listFindSecondMinimumValue.get(1));
        }


    }

    /**
     * Input:
     *      TreeNode root = new TreeNode(1);
     *      root.left = new TreeNode(2);
     *      root.left.left = new TreeNode(3);
     * Output: 3
     * Explanation:
     *      递归找树的最高深度
     * condition: 递归，树的高度
     */
    public int maxDepth(TreeNode root) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      TreeNode root = new TreeNode(1);
     *      root.left = new TreeNode(2);
     *      root.left.left = new TreeNode(3);
     *      root.right = new TreeNode(12);
     * Output: true
     * Explanation:
     *          1
     *         / \
     *        2  12
     *       /
     *      3
     * condition: 递归，平衡树
     */
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        //答题

        return false;//false
    }
    private int maxDepth(TreeNode root, int i) {
        //答题(可以直接用上面的maxDepth)

        return -1;//-1
    }

    /**
     * Input:
     *      TreeNode root = new TreeNode(1);
     *      root.left = new TreeNode(2);
     *      root.left.left = new TreeNode(3);
     *      root.right = new TreeNode(12);
     *      root.left.right = new TreeNode(5);
     * Output: 4
     * Explanation:
     *          1
     *         / \
     *        2  12
     *       / \
     *      3   5
     *      [4,2,1,3] or [5,2,1,3]
     * condition: 递归，两节点的最长路径
     */
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //答题

        return -1;//-1
    }
    private int depth(TreeNode root) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      TreeNode root = new TreeNode(1);
     *      root.left = new TreeNode(2);
     *      root.left.left = new TreeNode(3);
     *      root.right = new TreeNode(12);
     *      root.left.right = new TreeNode(5);
     *      root.left.left.left = new TreeNode(4);
     * Output: 11225
     * Explanation:
     *          1
     *         / \
     *        2  12
     *       / \
     *      3   5
     *     /
     *    4
     * condition: 递归，翻转树
     */
    public TreeNode invertTree(TreeNode root) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      TreeNode root = new TreeNode(1);
     *      root.left = new TreeNode(2);
     *      root.left.left = new TreeNode(3);
     *      root.right = new TreeNode(12);
     *      root.left.right = new TreeNode(5);
     *      root.left.left.left = new TreeNode(4);
     *      TreeNode root2 = new TreeNode(100);
     * Output: 101
     * Explanation:
     *          1 → 101
     *         / \
     *        2  12
     *       / \
     *      3   5
     *     /
     *    4
     * condition: 递归，归并两棵树
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      TreeNode root = new TreeNode(1);
     *      root.left = new TreeNode(2);
     *      root.left.left = new TreeNode(3);
     *      root.right = new TreeNode(12);
     *      root.left.right = new TreeNode(5);
     *      root.left.left.left = new TreeNode(4);
     * Output: true
     * Explanation:
     *          1
     *         / \
     *        2  12
     *       / \
     *      3   5
     *     /
     *    4
     * condition: 递归，判断路径和是否等于一个数8
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      TreeNode root = new TreeNode(1);
     *      root.left = new TreeNode(2);
     *      root.left.left = new TreeNode(3);
     *      root.right = new TreeNode(12);
     *      root.left.right = new TreeNode(5);
     *      root.left.left.left = new TreeNode(4);
     * Output: 1
     * Explanation:
     *          1
     *         / \
     *        2  12
     *       / \
     *      3   5
     *     /
     *    4
     * condition: 递归，统计路径和等于一个数的路径数量8
     */
    public int pathSum(TreeNode root, int sum) {
        //答题

        return -1;//-1
    }
    private int pathSumStartWithRoot(TreeNode root, int sum) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      TreeNode s = new TreeNode(1);
     *      s.left = new TreeNode(2);
     *      s.right = new TreeNode(3);
     *      s.right.left = new TreeNode(4);
     *      s.right.right = new TreeNode(5);
     *      TreeNode t = new TreeNode(3);
     *      t.left = new TreeNode(4);
     *      t.right = new TreeNode(5);
     * Output: true
     * Explanation:
     *          1          3
     *         / \        / \
     *        2  3       4   5
     *          / \
     *         4   5
     * condition: 递归，子树
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //答题

        return false;//false
    }
    private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      TreeNode root9 = new TreeNode(1);
     *      root9.left = new TreeNode(2);
     *      root9.right = new TreeNode(2);
     *      root9.left.left = new TreeNode(3);
     *      root9.left.right = new TreeNode(4);
     *      root9.right.left = new TreeNode(4);
     *      root9.right.right = new TreeNode(3);
     * Output: true
     * Explanation:
     *          1
     *         / \
     *        2   2
     *       / \ / \
     *      3  4 4  3
     * condition: 递归，树的对称
     */
    public boolean isSymmetric(TreeNode root) {
        //答题

        return false;//false
    }
    private boolean isSymmetric(TreeNode s, TreeNode t) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      TreeNode root = new TreeNode(1);
     *      root.left = new TreeNode(2);
     *      root.left.left = new TreeNode(3);
     *      root.right = new TreeNode(12);
     *      root.left.right = new TreeNode(5);
     *      root.left.left.left = new TreeNode(4);
     * Output: 2
     * Explanation:
     *          1
     *         / \
     *        2  12
     *       / \
     *      3   5
     *     /
     *    4
     * condition: 递归，最小路径
     */
    public int minDepth(TreeNode root) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      TreeNode root = new TreeNode(1);
     *      root.left = new TreeNode(2);
     *      root.left.left = new TreeNode(3);
     *      root.right = new TreeNode(12);
     *      root.left.right = new TreeNode(5);
     *      root.left.left.left = new TreeNode(4);
     *      翻转
     * Output: 17
     * Explanation:
     *          1
     *         / \
     *        12  2
     *           / \
     *          5   3
     *              \
     *               4
     * condition: 递归，统计左叶子节点的和
     */
    public int sumOfLeftLeaves(TreeNode root) {
        //答题

        return -1;//-1
    }
    private boolean isLeaf(TreeNode node){
        //答题

        return false;//false
    }

    /**
     * Input:
     *      TreeNode root12 = new TreeNode(1);
     *      root12.left = new TreeNode(4);
     *      root12.right = new TreeNode(5);
     *      root12.left.left = new TreeNode(4);
     *      root12.left.right = new TreeNode(4);
     *      root12.right.right = new TreeNode(5);
     * Output: 2
     * Explanation:
     *          1
     *         / \
     *        4   5
     *       / \   \
     *      4   4   5
     * condition: 递归，相同节点值的最大路径长度
     */
    private int path = 0;
    public int longestUnivaluePath(TreeNode root) {
        //答题


        return -1;//-1
    }
    private int dfs(TreeNode root, int val){
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      TreeNode root13 = new TreeNode(3);
     *      root13.left = new TreeNode(2);
     *      root13.right = new TreeNode(3);
     *      root13.left.right = new TreeNode(3);
     *      root13.right.right = new TreeNode(1);
     * Output: 7
     * Explanation:
     *      3       3+3+1=7
     *     / \
     *    2   3
     *     \   \
     *      3   1
     * condition: 递归，间隔遍历
     */
    public int rob(TreeNode root) {
        //答题

        return -1;//-1
    }

    /**
     * Input:
     *      TreeNode root14 = new TreeNode(2);
     *      root14.left = new TreeNode(2);
     *      root14.right = new TreeNode(5);
     *      root14.right.left = new TreeNode(5);
     *      root14.right.right = new TreeNode(7);
     * Output: 5
     * Explanation:
     *      2
     *     / \
     *    2   5
     *       / \
     *      5  7
     * condition: 递归，找出二叉树中第二小的节点
     */
    private List<Integer> listFindSecondMinimumValue = new ArrayList<>();
    public void findSecondMinimumValue(TreeNode root) {
        //答题

    }

}
