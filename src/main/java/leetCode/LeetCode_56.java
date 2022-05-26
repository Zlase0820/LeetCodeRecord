package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class LeetCode_56 {
    // 可以直接在数组里边进行排序
    public int[][] merge(int[][] intervals) {
        // 边界
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }

        // 重新排序
        List<Unit> nums = new ArrayList<>();
        for (int[] interval : intervals) {
            nums.add(new Unit(interval[0], interval[1]));
        }
        nums.sort((o1, o2) -> {
            if (o1.left == o2.left) {
                return o1.right - o2.right;
            }
            return o1.left - o2.left;
        });

        // 开始合并
        Stack<Unit> stack = new Stack<>();
        stack.add(nums.get(0));
        for (int i = 1; i < nums.size(); i++) {
            Unit mergeUnit1 = stack.pop();
            Unit mergeUnit2 = nums.get(i);
            if (mergeUnit2.left <= mergeUnit1.right) {
                stack.add(new Unit(mergeUnit1.left, Math.max(mergeUnit1.right, mergeUnit2.right)));
            } else {
                stack.add(mergeUnit1);
                stack.add(mergeUnit2);
            }
        }

        // stack转数组
        int[][] result = new int[stack.size()][2];
        for (int i = stack.size() - 1; i >= 0; i--) {
            Unit unit = stack.pop();
            result[i][0] = unit.left;
            result[i][1] = unit.right;
        }
        return result;
    }


    public static class Unit {
        public int left;
        public int right;

        public Unit(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void test1() {
        LeetCode_56 leetCode_56 = new LeetCode_56();
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = {{1, 6}, {8, 10}, {15, 18}};
        Assert.assertEquals("error", result, leetCode_56.merge(nums));
    }

    @Test
    public void test2() {
        LeetCode_56 leetCode_56 = new LeetCode_56();
        int[][] nums = {{1, 4}, {4, 5}};
        int[][] result = {{1, 5}};
        Assert.assertEquals("error", result, leetCode_56.merge(nums));
    }

    @Test
    public void test3() {
        LeetCode_56 leetCode_56 = new LeetCode_56();
        int[][] nums = {{1, 4}, {2, 3}};
        int[][] result = {{1, 4}};
        Assert.assertEquals("error", result, leetCode_56.merge(nums));
    }

}
