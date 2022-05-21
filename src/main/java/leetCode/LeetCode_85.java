package leetCode;

public class LeetCode_85 {

    public static void main(String[] args) {
        LeetCode_85 leetCode = new LeetCode_85();
        char[][] grid = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        int num = leetCode.maximalRectangle(grid);
        System.out.print(num);
    }

    // 相比于221题目，变成了两个边的边长
    // 面积 = 高度 * 宽度
    // 找到左上角的点为1的，然后向下延伸高度，每延伸一次高度，计算一下再次场景下的最大面积，最后的结果就是最终的总面积
    public int maximalRectangle(char[][] matrix) {
        int maxSize = 0;
        int tempSize;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    tempSize = getSize(matrix, i, j);
                    if (tempSize > maxSize) {
                        maxSize = tempSize;
                    }
                }
            }
        }
        return maxSize;
    }

    // 获取对应节点的最大面积
    private int getSize(char[][] matrix, int i, int j) {
        int maxSize = 0;
        int tempSize;
        for (int high = 1; i + high - 1 < matrix.length; high++) {
            if (matrix[i + high - 1][j] != '1') {
                break;
            }
            tempSize = getWidthSize(matrix, i, high, j);
            if (tempSize > maxSize) {
                maxSize = tempSize;
            }
        }
        return maxSize;
    }

    // 获取对应节点，且高度确定情况下的，最大宽度的面积
    private int getWidthSize(char[][] matrix, int i, int high, int j) {
        int width = 1;
        int size = 0;
        while (true) {
            if (j + width - 1 >= matrix[0].length) {
                size = high * (width - 1);
                break;
            }
            boolean isStop = false;
            for (int m = i; m < i + high; m++) {
                if (matrix[m][j + width - 1] != '1') {
                    isStop = true;
                }
            }
            if (isStop == true) {
                size = high * (width - 1);
                break;
            } else {
                width++;
            }
        }
        return size;
    }
}
