package leetCode;

import beans.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import utils.TreeUtil;

import java.util.Stack;

public class LeetCode_965 {

    // DFS
    public boolean isUnivalTree(TreeNode root) {
        int num = root.val;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null && node.val != num) {
                return false;
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return true;
    }

    @Test
    public void test1() {
        Integer[] nums = {1, 2, 3, 4, 5, null, 6};
        TreeNode root = TreeUtil.createTree(nums);
        Assert.assertFalse("error", isUnivalTree(root));
    }

    @Test
    public void test2() {
        Integer[] nums = {1, 1, 1, 1, 1, null, 1};
        TreeNode root = TreeUtil.createTree(nums);
        Assert.assertTrue("error", isUnivalTree(root));
    }
}
