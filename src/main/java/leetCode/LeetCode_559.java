package leetCode;

import beans.NaryTreeNode;

import java.util.List;

public class LeetCode_559 {
    public static void main(String[] args) {
        LeetCode_559 leetCode_559 = new LeetCode_559();
//        Integer[] nums = {1, null, 3, 2, 4, null, 5, 6};
        Integer[] nums = {1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14};
        NaryTreeNode node = utils.TreeUtil.createNaryTreeNode(nums);
        int depth = leetCode_559.maxDepth(node);
        System.out.println(depth);
    }

    int maxDepth = 1;

    /**
     * dfs  不断向下递归，直到找到最深层的节点深度
     *
     * @param root 根节点
     * @return 一共有多深
     */
    public int maxDepth(NaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 1;
        dfs(root.child, count);
        return maxDepth;
    }

    private void dfs(List<NaryTreeNode> list, int count) {
        if (count > maxDepth) {
            maxDepth = count;
        }

        if (list == null) {
            return;
        }

        for (NaryTreeNode node : list) {
            dfs(node.child, count + 1);
        }
    }
}
