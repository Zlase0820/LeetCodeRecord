package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zlase
 * @createDate: 2022/8/24
 * @description:
 */
public class LeetCode_1460 {
    // 看似是比较麻烦，实际就是看两个数组中的数字是不是一样的
    // 可以用排序在遍历，时间复杂度较高，用map可以用n的时间复杂度搞定
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        Map<Integer, Integer> targetMap = new HashMap<>();
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            targetMap.put(target[i], targetMap.getOrDefault(target[i], 0) + 1);
            arrMap.put(arr[i], arrMap.getOrDefault(arr[i], 0) + 1);
        }
        for (int key : arrMap.keySet()) {
            if (!targetMap.containsKey(key) || !targetMap.get(key).equals(arrMap.get(key))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        LeetCode_1460 leetCode_1460 = new LeetCode_1460();
        int[] arr = {2, 4, 1, 3};
        int[] target = {1, 2, 3, 4};
        Assert.assertTrue(leetCode_1460.canBeEqual(target, arr));
    }

    @Test
    public void test2() {
        LeetCode_1460 leetCode_1460 = new LeetCode_1460();
        int[] arr = {7};
        int[] target = {7};
        Assert.assertTrue(leetCode_1460.canBeEqual(target, arr));
    }

    @Test
    public void test3() {
        LeetCode_1460 leetCode_1460 = new LeetCode_1460();
        int[] arr = {3, 7, 9};
        int[] target = {3, 7, 11};
        Assert.assertFalse(leetCode_1460.canBeEqual(target, arr));
    }
}
