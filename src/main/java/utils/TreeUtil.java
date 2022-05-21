package utils;

import beans.NaryTreeNode;

import java.util.ArrayDeque;

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
        for(int i=1;i<nums.length;i++){
            NaryTreeNode node = queue.pop();
            if(nums[i]==null){
                for(int j=i+1;j<nums.length && nums[j]!=null;j++,i++){
                    NaryTreeNode nodeTemp = new NaryTreeNode(nums[j]);
                    node.child.add(nodeTemp);
                    queue.add(nodeTemp);
                }
            }
        }
        return root;
    }

    /**
     *               1
     *             3 2 4
     *         5  6
     *     7 8 9
     *
     * @param args 树状结构
     */
    public static void main(String[] args) {
        Integer[] nums = {1, null, 3, 2, 4, null, 5, 6, null, null, null, 7, 8, 9};
        NaryTreeNode root = TreeUtil.createNaryTreeNode(nums);
        System.out.println(root);
    }
}
