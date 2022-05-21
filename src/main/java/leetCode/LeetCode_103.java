package leetCode;

import beans.TreeNode;

import java.util.*;

public class LeetCode_103 {

    public static void main(String[] args) {
        LeetCode_103 leetCode = new LeetCode_103();
        TreeNode root = leetCode.getTree103();
        List<List<Integer>> zigzagOrder = leetCode.zigzagLevelOrder(root);
        System.out.print(zigzagOrder);
    }

    /**
     * 传入一个二叉树，进行锯齿化排列，即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行
     * 本质就是二叉树的层序遍历，只不过需要改一下顺序，可以都排列好之后，最后使用Collection.reverse转变偶数行
     *
     * @param root 二叉树
     * @return 锯齿排列的结果
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //基础判空
        if (root == null) {
            return new ArrayList<>();
        }

        // 层序遍历
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean isReverse = false;
        while (!queue.isEmpty()) {
            List<Integer> listTemp = new ArrayList<>();
            int count = queue.size();
            for (int i = count; i > 0; i--) {
                TreeNode nodeTemp = queue.remove();
                listTemp.add(nodeTemp.val);
                if (nodeTemp.left != null) {
                    queue.add(nodeTemp.left);
                }
                if (nodeTemp.right != null) {
                    queue.add(nodeTemp.right);
                }
            }
            if (isReverse) {
                Collections.reverse(listTemp);
            }
            isReverse = !isReverse;
            list.add(listTemp);
        }
        return list;
    }


    private TreeNode getTree103() {
        TreeNode root = new TreeNode(3);

        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);

        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;

        node2.left = node3;
        node2.right = node4;

        return root;
    }

}
