package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LeetCode_961 {

    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int left = nums.length / 2 - 1;
        int right = left + 1;
        if (nums[left] == nums[right]) {
            return nums[left];
        }
        return nums[0] == nums[left] ? nums[left] : nums[right];
    }

    @Test
    public void test1() {
        LeetCode_961 leetCode_961 = new LeetCode_961();
        int[] nums = {5, 1, 5, 2, 5, 3, 5, 4};
        int num = leetCode_961.repeatedNTimes(nums);
        Assert.assertEquals("发现错误", num, 5);
    }

    @Test
    public void test2() {
        LeetCode_961 leetCode_961 = new LeetCode_961();
        int[] nums = {2, 1, 2, 5, 3, 2};
        int num = leetCode_961.repeatedNTimes(nums);
        Assert.assertEquals("发现错误", num, 2);
    }

    @Test
    public void test3() {
        LeetCode_961 leetCode_961 = new LeetCode_961();
        int[] nums = {1, 1, 2, 5};
        int num = leetCode_961.repeatedNTimes(nums);
        Assert.assertEquals("发现错误", num, 1);
    }
}
