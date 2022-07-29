package leetCode;

import java.util.Arrays;

/**
 * @author: zlase
 * @createDate: 2022/7/29
 * @description:
 */
public class LeetCode_593 {
    // 确认一个正方形的方法，每一个点到其他三个点，都有两个相等的短边，有一个长边，并且短边都相等，长边都相等
    // 注意，必须是两短一长，一长两短可以变成等边三角形加一个中心点
    // 测试用例太恶心了，竟然还有点的重叠....
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] nums = getSize(p1, p2, p3, p4);
        long shortSize = nums[0];
        long longSize = nums[2];

        // 判空，判断重叠
        if (shortSize == 0 || longSize == 0) {
            return false;
        }
        return isSquare(shortSize, longSize, p1, p2, p3, p4) && isSquare(shortSize, longSize, p2, p1, p3, p4) && isSquare(shortSize, longSize, p3, p1, p2, p4) && isSquare(shortSize, longSize, p4, p1, p2, p3);
    }


    private boolean isSquare(long shortSize, long longSize, int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] sizes = getSize(p1, p2, p3, p4);
        return sizes[0] == sizes[1] && sizes[0] == shortSize && longSize == sizes[2];
    }

    private long[] getSize(int[] p1, int[] p2, int[] p3, int[] p4) {
        long tempSize1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        long tempSize2 = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
        long tempSize3 = (p1[0] - p4[0]) * (p1[0] - p4[0]) + (p1[1] - p4[1]) * (p1[1] - p4[1]);
        long[] nums = {tempSize1, tempSize2, tempSize3};
        Arrays.sort(nums);
        return nums;
    }
}
