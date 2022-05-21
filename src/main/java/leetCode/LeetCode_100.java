package leetCode;

import beans.TreeNode;

public class LeetCode_100 {
    public static void main(String[] args) {
        LeetCode_100 leetCode = new LeetCode_100();
        TreeNode root1 = leetCode.getTree1();
        TreeNode root2 = leetCode.getTree2();
        boolean isSame = leetCode.isSameTree(root1, root2);
        System.out.print(isSame);
    }

    /**
     * 左右两侧分别判断是不是空，是不是相等就可以了
     *
     * @param p 子树1的根节点
     * @param q 子树2的根节点
     * @return 是否相等
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return determineIsSame(p, q);
    }

    private boolean determineIsSame(TreeNode p, TreeNode q) {
        boolean leftSame = false;
        boolean rightSame = false;
        if (p.val == q.val) {
            if (p.left == null && q.left == null) {
                leftSame = true;
            } else if (p.left != null && q.left != null) {
                leftSame = determineIsSame(p.left, q.left);
            } else {
                return false;
            }
            if (p.right == null && q.right == null) {
                rightSame = true;
            } else if (p.right != null && q.right != null) {
                rightSame = determineIsSame(p.right, q.right);
            } else {
                return false;
            }
        }
        return leftSame & rightSame;
    }

    private TreeNode getTree1() {
        TreeNode root = new TreeNode(40);

        TreeNode right = new TreeNode(-8);

        root.right = right;

        return root;
    }

    private TreeNode getTree2() {
        TreeNode root = new TreeNode(40);

        TreeNode right = new TreeNode(-5);

        root.right = right;

        return root;
    }
}