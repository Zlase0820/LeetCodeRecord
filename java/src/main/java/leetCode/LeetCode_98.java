package leetCode;

import beans.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_98 {

    public static void main(String[] args) {
        LeetCode_98 leetCode = new LeetCode_98();
        TreeNode root = leetCode.getTree();
        boolean isValidBST = leetCode.isValidBST(root);
        System.out.print(isValidBST);
    }

    /**
     * 判断是不是二叉搜索树，即：左节点值 < 根节点 < 右节点值
     * 这种非常类似于中序遍历，中序遍历如果是升序，即可认为是二叉搜索树
     *
     * @param root 根节点
     * @return 是否是二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> mediumOrder = getMidiumOrder(root, new ArrayList<>());
        for (int i = 0; i < mediumOrder.size() - 1; i++) {
            if (mediumOrder.get(i) < mediumOrder.get(i + 1)) {
                continue;
            }
            return false;
        }
        return true;
    }

    private List<Integer> getMidiumOrder(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            list = getMidiumOrder(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            list = getMidiumOrder(node.right, list);
        }
        return list;
    }

    private TreeNode getTree() {
        TreeNode root = new TreeNode(40);

        TreeNode node1 = new TreeNode(30);
        TreeNode node2 = new TreeNode(50);

        TreeNode node3 = new TreeNode(25);
        TreeNode node4 = new TreeNode(35);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        return root;
    }

}
