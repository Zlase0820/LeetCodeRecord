package leetCode;

import beans.TreeNode;

public class LeetCode_105 {

    public static void main(String[] args) {
        LeetCode_105 leetCode = new LeetCode_105();
        int[] preorder = {3, 9, 20, 15, 7, 3, 2};
        int[] inorder = {9, 3, 15, 20, 3, 7, 2};
        TreeNode treeRoot = leetCode.buildTree(preorder, inorder);
        System.out.print(treeRoot);
    }

    /**
     * 前序遍历  {根}{左子树}{右子树}
     * 中序遍历  {左子树}{根}{右子树}
     * 每次把根返还，左子树和右子树分别继续递归即可
     * 需要注意的是，没有办法找到传入子树的左右坐标，所以直接用二者的左侧坐标和数组长度即可
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 返还值
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 传入判空
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int location = findLocation(preorder[0], inorder);
        root.left = buildChildTree(preorder, inorder, 1, 0, location - 0);
        root.right = buildChildTree(preorder, inorder, 1 + location - 0, location + 1, inorder.length - 1 - location);
        return root;
    }

    /**
     * 构建子树
     *
     * @param preorder     先序遍历数组
     * @param inorder      中序遍历数组
     * @param preorderLeft 先序遍历中子树的最左侧节点编号
     * @param inorderLeft  中序遍历中子树最左侧节点编号
     * @param length       子树的长度
     * @return 子树的根节点
     */
    private TreeNode buildChildTree(int[] preorder, int[] inorder, int preorderLeft, int inorderLeft, int length) {
        // 说明没有该子树
        if (length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        if (length == 1) {
            return root;
        } else {
            int location = findLocation(preorder[preorderLeft], inorder);
            root.left = buildChildTree(preorder, inorder, preorderLeft + 1, inorderLeft, location - inorderLeft);
            root.right = buildChildTree(preorder, inorder, preorderLeft + 1 + location - inorderLeft, location + 1, length - (location + 1 - inorderLeft));
        }
        return root;
    }

    //可以使用二分遍历，现在简单使用O(n)循环
    private int findLocation(int num, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (num == inorder[i]) {
                return i;
            }
        }
        return 0;
    }

}











