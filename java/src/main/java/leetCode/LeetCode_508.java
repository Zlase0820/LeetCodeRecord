package leetCode;

import beans.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author: zlase
 * @createDate: 2022/6/19
 * @description:
 */
public class LeetCode_508 {

    public static Map<Integer, Integer> integerMap = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        Integer count = 0;
        for (Integer integer : integerMap.values()) {
            if (integer > count) {
                count = integer;
            }
        }
        Integer finalCount = count;
        List<Integer> list = new ArrayList<>();
        integerMap.forEach((key, value) -> {
            if (value.equals(finalCount)) {
                list.add(key);
            }
        });
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            dfs(root.left);
        }

        if (root.right != null) {
            dfs(root.right);
        }

        int left;
        int right;
        if (root.left == null) {
            left = 0;
        } else {
            left = root.left.val;
        }
        if (root.right == null) {
            right = 0;
        } else {
            right = root.right.val;
        }
        root.val = left + right + root.val;
        integerMap.put(root.val, integerMap.getOrDefault(root.val, 0) + 1);
    }


    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(-3);
        node1.left = node2;
        node1.right = node3;
        LeetCode_508 leetCode_508 = new LeetCode_508();
        int[] result = leetCode_508.findFrequentTreeSum(node1);
        System.out.println(123);
    }

    @Test
    public void test2() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(-5);
        node1.left = node2;
        node1.right = node3;
        LeetCode_508 leetCode_508 = new LeetCode_508();
        int[] result = leetCode_508.findFrequentTreeSum(node1);
        System.out.println(123);
    }

    @Test
    public void test3() {
        TreeNode node1 = new TreeNode(1);
        LeetCode_508 leetCode_508 = new LeetCode_508();
        int[] result = leetCode_508.findFrequentTreeSum(node1);
        System.out.println(123);
    }
}


































