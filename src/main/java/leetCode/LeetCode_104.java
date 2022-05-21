package leetCode;

import beans.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode_104 {

    // 子树的最大深度
    public static void main(String[] args) {
        LeetCode_104 leetCode = new LeetCode_104();

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        int num = leetCode.maxDepth(node1);

        System.out.print(num);
    }

    // 使用BFS，然后每有一层，增加一个1
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            maxDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
        return maxDepth - 1;
    }
}
