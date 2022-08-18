package leetCode;

import beans.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: zlase
 * @createDate: 2022/8/18
 * @description:
 */
public class LeetCode_1302 {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> tempQueue = new ArrayDeque<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            result = 0;
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                result += poll.val;
                if (poll.left != null) {
                    tempQueue.add(poll.left);
                }
                if (poll.right != null) {
                    tempQueue.add(poll.right);
                }
            }
            queue.addAll(tempQueue);
            tempQueue.clear();
        }
        return result;
    }
}
