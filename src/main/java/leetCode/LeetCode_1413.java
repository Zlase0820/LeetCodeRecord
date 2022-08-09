package leetCode;

/**
 * @author: zlase
 * @createDate: 2022/8/9
 * @description:
 */
public class LeetCode_1413 {
    // 从左到右依次加和，找到最小的值(负数)min，return 1-min即可
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int temp = 0;
        for (int num : nums) {
            temp += num;
            if (temp < min) {
                min = temp;
            }
        }
        if (min > 0) {
            return 1;
        } else {
            return 1 - min;
        }
    }
}
