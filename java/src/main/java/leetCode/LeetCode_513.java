package leetCode;

import beans.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: zlase
 * @createDate: 2022/6/22
 * @description:
 */
public class LeetCode_513 {

    // 非常经典的BFS
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        queue1.add(root);

        while (!queue1.isEmpty()) {
            result = queue1.peek().val;
            while (!queue1.isEmpty()) {
                TreeNode treeNode = queue1.poll();
                if (treeNode.left != null) {
                    queue2.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue2.add(treeNode.right);
                }
            }
            queue1.addAll(queue2);
            queue2.clear();
        }
        return result;
    }

}
