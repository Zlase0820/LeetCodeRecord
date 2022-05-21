package leetCode;

import beans.TreeNode;

public class LeetCode_1038 {

    public static void main(String[] args) {
        LeetCode_1038 leetCode = new LeetCode_1038();
        TreeNode treeNode = leetCode.buildTree();
        TreeNode treeNode1 = leetCode.bstToGst(treeNode);
        System.out.println(treeNode1);
    }

    /**
     * 题解：
     * 每个节点 node 的新值 等于 原树中大于或等于 node.val 的值之和
     * <p>
     * 两种方案：
     * 1. 先中序遍历（左根右），0,1,2,3,4
     * 从后往前加和遍历：10,10,9,7,4
     * 做一个Map把二者结合，在从头遍历一次，把val改成对应的值
     * 相当于两次遍历，一次n的加和，一次Map遍历，整体还是比较耗时的
     * <p>
     * 2.直接反向中序遍历  右根左
     * 每次遍历的值直接改，叠加即可，相当于一次遍历
     *
     * @param root 二叉树的根节点
     * @return 新树的根节点
     */
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return root;
        }
        bstTree(root, 0);
        return root;
    }

    // 逆向中序遍历  右根左
    private int bstTree(TreeNode node, int sum) {
        if (node.right != null) {
            sum = bstTree(node.right, sum);
        }
        node.val = node.val + sum;
        sum = node.val;
        if (node.left != null) {
            sum = bstTree(node.left, sum);
        }
        return sum;
    }


    private TreeNode buildTree() {
        TreeNode node1 = new TreeNode(3);

        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(6);
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        return node1;
    }


}
