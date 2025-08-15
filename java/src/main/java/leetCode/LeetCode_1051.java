package leetCode;

import java.util.Arrays;

/**
 * @author: zlase
 * @createDate: 2022/6/14
 * @description:
 */
public class LeetCode_1051 {
    public int heightChecker(int[] heights) {
        int[] sortHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sortHeights);
        int num = 0;
        for (int i = 0; i < heights.length; i++) {
            if (sortHeights[i] != heights[i]) {
                num++;
            }
        }
        return num;
    }
}
