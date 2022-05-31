package leetCode;

import org.junit.Assert;
import org.junit.Test;

public class LeetCode_59 {

    // 螺旋仿真，没有办法通过计算来顺序排列
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int count = 1;
        // 确定开始的点，一次走一圈
        int startRow = 0;
        int startCol = 0;
        int clc = n;
        while (count <= n * n) {
            // 初始化第一个点
            nums[startRow][startCol] = count;

            // 横向一行
            for (int i = 0; i < clc - 1; i++) {
                startCol += 1;
                count += 1;
                nums[startRow][startCol] = count;
            }

            //向下一列
            for (int i = 0; i < clc - 1; i++) {
                startRow += 1;
                count += 1;
                nums[startRow][startCol] = count;
            }

            //向左一行
            for (int i = 0; i < clc - 1; i++) {
                startCol = startCol - 1;
                count += 1;
                nums[startRow][startCol] = count;
            }

            //向上一行
            for (int i = 0; i < clc - 2; i++) {
                startRow = startRow - 1;
                count += 1;
                nums[startRow][startCol] = count;
            }

            startCol = startCol + 1;
            clc = clc - 2;
            count = count + 1;
        }
        return nums;
    }


    @Test
    public void test1() {
        int n = 3;
        int[][] ints = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        LeetCode_59 leetCode_59 = new LeetCode_59();
        int[][] result = leetCode_59.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Assert.assertEquals("error", result[i][j], ints[i][j]);
            }
        }
    }

    @Test
    public void test2() {
        int n = 1;
        int[][] ints = {{1}};
        LeetCode_59 leetCode_59 = new LeetCode_59();
        int[][] result = leetCode_59.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Assert.assertEquals("error", result[i][j], ints[i][j]);
            }
        }
    }

    @Test
    public void test3() {
        int n = 4;
        int[][] ints = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        LeetCode_59 leetCode_59 = new LeetCode_59();
        int[][] result = leetCode_59.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Assert.assertEquals("error", result[i][j], ints[i][j]);
            }
        }
    }


}
