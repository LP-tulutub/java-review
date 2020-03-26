package com.java.review2.datastructure;


import com.java.review2.rely.TreeNode;

public class TreeMe {
    public static void main(String[] args) {
        TreeMe treeMe = new TreeMe();
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
        System.out.println("findSecondMinimumValue: " + treeMe.findSecondMinimumValue(root14));
        
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
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
     *        /  
     *      3   
     * condition: 递归，平衡树
     */
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root, 1);
        return result;
    }
    private int maxDepth(TreeNode root, int i) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1) result = false;
        return 1 + Math.max(l, r);
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
        depth(root);
        return max + 1;
    }
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        max = Math.max(max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * Input:
     *      TreeNode root = new TreeNode(1);
     *      root.left = new TreeNode(2);
     *      root.left.left = new TreeNode(3);
     *      root.right = new TreeNode(12);
     *      root.left.right = new TreeNode(5);
     *      root.left.left.left = new TreeNode(4);
     * Output:
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
        if (root == null) return null;
        TreeNode left = root.left;  // 后面的操作会改变 left 指针，因此先保存下来
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
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
     * Output:
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
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
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
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
        if (root == null) return 0;
        return pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) return 0;
        int ret = 0;
        if (root.val == sum) ret++;
        ret += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);
        return ret;
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
        if (s == null) return false;
        return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (t == null || s == null) return false;
        if (t.val != s.val) return false;
        return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
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
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
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
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) return left + right + 1;
        return Math.min(left, right) + 1;
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
        if (root == null) return 0;
        if (isLeaf(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    private boolean isLeaf(TreeNode node){
        if (node == null) return false;
        return node.left == null && node.right == null;
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
        dfs(root);
        return path;
    }
    private int dfs(TreeNode root){
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
        path = Math.max(path, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
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
        if (root == null) return 0;
        int val1 = root.val;
        if (root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) val1 += rob(root.right.left) + rob(root.right.right);
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return -1;
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
        if (rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
        if (leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
        if (leftVal != -1) return leftVal;
        return rightVal;
    }



}
