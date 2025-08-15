package utils;

import beans.NaryTreeNode;
import beans.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.List;

public class TreeUtil {
    public static NaryTreeNode createNaryTreeNode(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }

        if (nums.length == 1) {
            return new NaryTreeNode(nums[0]);
        }

        NaryTreeNode root = new NaryTreeNode(nums[0]);
        ArrayDeque<NaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        for (int i = 1; i < nums.length; i++) {
            NaryTreeNode node = queue.pop();
            if (nums[i] == null) {
                for (int j = i + 1; j < nums.length && nums[j] != null; j++, i++) {
                    NaryTreeNode nodeTemp = new NaryTreeNode(nums[j]);
                    node.child.add(nodeTemp);
                    queue.add(nodeTemp);
                }
            }
        }
        return root;
    }

    /**
     * 1
     * 3 2 4
     * 5  6
     * 7 8 9
     *
     * @param args 树状结构
     */
    public static void main(String[] args) {
        Integer[] nums = {1, null, 3, 2, 4, null, 5, 6, null, null, null, 7, 8, 9};
        NaryTreeNode root = TreeUtil.createNaryTreeNode(nums);
        System.out.println(root);
    }

    // 构建一个二叉树
    public static TreeNode createTree(Integer[] array) {
        return createBinaryTreeByArray(array, 0);
    }

    public static TreeNode createTree(List<Integer> array) {
        Integer[] nums = new Integer[array.size()];
        for (int i = 0; i < array.size(); i++) {
            nums[i] = array.get(i);
        }
        return createTree(nums);
    }

    // 构建一个二叉树，层序遍历构建二叉树
    private static TreeNode createBinaryTreeByArray(Integer[] array, int index) {
        TreeNode tn = null;
        if (index < array.length && array[index] != null) {
            Integer value = array[index];
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }
}
