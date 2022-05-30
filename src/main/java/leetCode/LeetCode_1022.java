package leetCode;

import beans.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import utils.TreeUtil;

import java.util.Stack;

public class LeetCode_1022 {

    public int sumRootToLeaf(TreeNode root) {
        int num = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<String> strings = new Stack<>();
        stack.add(root);
        strings.add(root.val + "");
        while (!stack.isEmpty()) {
            TreeNode popNode = stack.pop();
            String popString = strings.pop();

            if (popNode.left == null && popNode.right == null) {
                num += Integer.parseInt(popString, 2);
                continue;
            }

            if (popNode.left != null) {
                stack.add(popNode.left);
                strings.add(popString + popNode.left.val);
            }

            if (popNode.right != null) {
                stack.add(popNode.right);
                strings.add(popString + popNode.right.val);
            }
        }

        return num;
    }

    @Test
    public void test1() {
        LeetCode_1022 leetCode = new LeetCode_1022();
        Integer[] treeArray = {1, 0, 1, 0, 1, 0, 1};
        TreeNode root = TreeUtil.createTree(treeArray);
        Assert.assertEquals("error", 22, leetCode.sumRootToLeaf(root));
    }

    @Test
    public void test2() {
        LeetCode_1022 leetCode = new LeetCode_1022();
        Integer[] treeArray = {0};
        TreeNode root = TreeUtil.createTree(treeArray);
        Assert.assertEquals("error", 0, leetCode.sumRootToLeaf(root));
    }
}
