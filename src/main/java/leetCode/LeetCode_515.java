package leetCode;

import beans.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: zlase
 * @createDate: 2022/6/25
 * @description:
 */
public class LeetCode_515 {
    // BFS
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // 判空
        if (root == null) {
            return result;
        }

        int maxNum = Integer.MIN_VALUE;
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            // 每一层进行一次处理
            while (!queue1.isEmpty()) {
                TreeNode treeNode = queue1.poll();
                if (treeNode.val > maxNum) {
                    maxNum = treeNode.val;
                }
                if (treeNode.left != null) {
                    queue2.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue2.add(treeNode.right);
                }
            }
            result.add(maxNum);
            maxNum = Integer.MIN_VALUE;
            queue1.addAll(queue2);
            queue2.clear();
        }
        return result;
    }
}
