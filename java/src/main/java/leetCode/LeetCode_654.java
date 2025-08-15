package leetCode;

import beans.TreeNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: zlase
 * @createDate: 2022/8/20
 * @description:
 */
public class LeetCode_654 {

    /**
     * 递归即可，没啥难度
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int location = findMax(nums);
        TreeNode node = new TreeNode(nums[location]);
        int[] numsLeft = Arrays.copyOf(nums, location);
        int[] numsRight = Arrays.copyOfRange(nums, location + 1, nums.length);
        node.left = constructMaximumBinaryTree(numsLeft);
        node.right = constructMaximumBinaryTree(numsRight);
        return node;
    }

    // 返回数组最大值的下标
    private int findMax(int[] nums) {
        int maxLocation = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= nums[maxLocation]) {
                maxLocation = i;
            }
        }
        return maxLocation;
    }

    @Test
    public void test1() {
        LeetCode_654 leetCode_654 = new LeetCode_654();
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = leetCode_654.constructMaximumBinaryTree(nums);
        System.out.println(root);
    }


}
