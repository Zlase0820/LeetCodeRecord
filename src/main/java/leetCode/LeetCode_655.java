package leetCode;

import beans.TreeNode;

import java.util.*;

/**
 * @author: zlase
 * @createDate: 2022/8/22
 * @description:
 */
public class LeetCode_655 {

    // 先找深度，构造一个二维数组
    // 每次递归数组，将深度，左右节点传入，即可找到子节点中的根节点
    // 将二维数组转换为List-List返还
    public List<List<String>> printTree(TreeNode root) {
        int height = findHeight(root);
        String[][] matrix = new String[height][(int) Math.pow(2, height) - 1];
        addNode(matrix, root, 0, (int) Math.pow(2, height) - 1, 0);

        // 二维数组转List<List>
        List<List<String>> result = new ArrayList<>();
        for (String[] strings : matrix) {
            List<String> list = new ArrayList<>();
            for (String string : strings) {
                list.add(Objects.requireNonNullElse(string, ""));
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 递归给matrix添加节点
     *
     * @param matrix matrix节点
     * @param node node节点
     * @param left 这个节点应该属于的左侧节点
     * @param right 这个节点应该属于的右侧节点
     * @param row 当前应该在的row层
     */
    private void addNode(String[][] matrix, TreeNode node, int left, int right, int row) {
        if (node == null || left > right) {
            return;
        }
        int mid = (left + right) / 2;
        matrix[row][mid] = node.val + "";
        addNode(matrix, node.left, left, mid - 1, row + 1);
        addNode(matrix, node.right, mid + 1, right, row + 1);
    }

    // 层序遍历找到二叉树的深度
    private int findHeight(TreeNode root) {
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        int height = 0;
        if (root == null) {
            return height;
        }
        queue1.add(root);
        while (!queue1.isEmpty()) {
            height++;
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                if (node.left != null) {
                    queue2.add(node.left);
                }
                if (node.right != null) {
                    queue2.add(node.right);
                }
            }
            queue1.addAll(queue2);
            queue2.clear();
        }
        return height;
    }



}
