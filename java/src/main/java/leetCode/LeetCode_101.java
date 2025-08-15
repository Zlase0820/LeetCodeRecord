package leetCode;

import beans.TreeNode;

public class LeetCode_101 {

    public static void main(String[] args) {
        LeetCode_101 leetCode = new LeetCode_101();
        TreeNode root = leetCode.getSymmetricTree();
        boolean isSymmetric = leetCode.isSymmetric(root);
        System.out.print(isSymmetric);
    }

    /**
     * 是不是镜像二叉树，先将右侧的子树，所有的孩子节点的左右都转换一遍
     * 然后左子树和右子树作为两个独立的树，判断是否一模一样即可
     *
     * @param root 根节点
     * @return 是否为镜像树
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        // 左右子树节点都是空，直接是镜像的
        if(root.left==null && root.right==null){
            return true;
        }

        // 如果左侧和右侧有一个是空的，那么绝对不是镜像的
        if(root.left==null || root.right==null){
            return false;
        }

        changeTree(root.left);
        return isSameTree(root.left,root.right);
    }

    // 翻转一个子树的所有左右节点
    private void changeTree(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode nodeTemp;
        if(root.left !=null || root.right!=null){
            nodeTemp= root.right;
            root.right = root.left;
            root.left = nodeTemp;

            changeTree(root.left);
            changeTree(root.right);
        }
    }



    /**
     * 左右两侧分别判断是不是空，是不是相等就可以了
     *
     * @param p 子树1的根节点
     * @param q 子树2的根节点
     * @return 是否相等
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return determineIsSame(p, q);
    }

    private boolean determineIsSame(TreeNode p, TreeNode q) {
        boolean leftSame = false;
        boolean rightSame = false;
        if (p.val == q.val) {
            if (p.left == null && q.left == null) {
                leftSame = true;
            } else if (p.left != null && q.left != null) {
                leftSame = determineIsSame(p.left, q.left);
            } else {
                return false;
            }
            if (p.right == null && q.right == null) {
                rightSame = true;
            } else if (p.right != null && q.right != null) {
                rightSame = determineIsSame(p.right, q.right);
            } else {
                return false;
            }
        }
        return leftSame & rightSame;
    }



    private TreeNode getSymmetricTree() {
        TreeNode root = new TreeNode(40);

        TreeNode node1 = new TreeNode(30);
        root.right = node1;

        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(30);
        root.left = node4;

        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(1);
        node4.left = node5;
        node4.right = node6;

        return root;
    }

}
