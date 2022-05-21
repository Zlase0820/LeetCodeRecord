package leetCode;

import beans.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class LeetCode_95 {

    public static void main(String[] args) {
        LeetCode_95 leetCode = new LeetCode_95();
        int num = 3;
        List<TreeNode> list = leetCode.generateTrees(num);
        System.out.print(list);
    }

    /**
     * 用递归的方式完成，左侧，右侧，然后拼接
     *
     * @param n 最大长度
     * @return 可以拼接成的最大二叉查找树的数量
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> listResult = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<TreeNode> leftList = generateList(1, i - 1);
            List<TreeNode> rightList = generateList(i + 1, n);
            List<TreeNode> temp = assembleList(i, leftList, rightList);
            listResult.addAll(temp);
        }
        return listResult;
    }

    private List<TreeNode> generateList(int min, int max) {
        List<TreeNode> list = new ArrayList<>();
        if (min > max) {
            return list;
        }
        if (min == max) {
            list.add(new TreeNode(min));
            return list;
        }
        for (int i = min; i <= max; i++) {
            List<TreeNode> leftList = generateList(min, i - 1);
            List<TreeNode> rightList = generateList(i + 1, max);
            list.addAll(assembleList(i, leftList, rightList));
        }
        return list;
    }

    // 拼接好左右节点，并存入到中心节点中
    private List<TreeNode> assembleList(int value, List<TreeNode> leftList, List<TreeNode> rightList) {
        List<TreeNode> listResult = new ArrayList<>();
        if (leftList.isEmpty() && rightList.isEmpty()) {
            TreeNode root = new TreeNode(value);
            listResult.add(root);
            return listResult;
        }
        if (leftList.isEmpty()) {
            for (int i = 0; i < rightList.size(); i++) {
                TreeNode root = new TreeNode(value);
                root.right = rightList.get(i);
                listResult.add(root);
            }
        } else if (rightList.isEmpty()) {
            for (int i = 0; i < leftList.size(); i++) {
                TreeNode root = new TreeNode(value);
                root.left = leftList.get(i);
                listResult.add(root);
            }
        } else {
            for (int i = 0; i < leftList.size(); i++) {
                for (int j = 0; j < rightList.size(); j++) {
                    TreeNode root = new TreeNode(value);
                    root.left = leftList.get(i);
                    root.right = rightList.get(j);
                    listResult.add(root);
                }
            }
        }
        return listResult;
    }


}
