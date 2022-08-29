package leetCode;

/**
 * @author: zlase
 * @createDate: 2022/8/29
 * @description:
 */
public class LeetCode_1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[i + n];
        }
        return result;
    }
}
