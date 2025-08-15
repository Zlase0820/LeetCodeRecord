package leetCode;

import beans.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: zlase
 * @createDate: 2022/8/7
 * @description:
 */
public class LeetCode_623 {
    // 区分根节点和其他路径的节点，BFS即可
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // 根节点
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        // DFS，要获取到对应层的上一层
        Queue<TreeNode> list = new ArrayDeque<>();
        Queue<TreeNode> list2 = new ArrayDeque<>();
        list.add(root);
        int dep = 1;
        while (dep != depth - 1) {
            while (!list.isEmpty()) {
                TreeNode poll = list.poll();
                if (poll.left != null) {
                    list2.add(poll.left);
                }
                if (poll.right != null) {
                    list2.add(poll.right);
                }
            }
            dep++;
            list.addAll(list2);
            list2.clear();
        }
        while (!list.isEmpty()) {
            TreeNode poll = list.poll();
            TreeNode tempLeft = new TreeNode(val);
            tempLeft.left = poll.left;
            poll.left = tempLeft;
            TreeNode tempRight = new TreeNode(val);
            tempRight.right = poll.right;
            poll.right = tempRight;
        }
        return root;
    }
}
