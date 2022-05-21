package leetCode;

public class LeetCode_221 {

    public static void main(String[] args) {
        LeetCode_221 leetCode = new LeetCode_221();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '1'}};
        int num = leetCode.maximalSquare(grid);
        System.out.print(num);
    }

    // 获取最大的正方形的面积，暴力法进行循环
    public int maximalSquare(char[][] matrix) {
        int maxSize = 0;
        int tempSize;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    tempSize = getMaxSize(matrix, i, j);
                    if (tempSize > maxSize) {
                        maxSize = tempSize;
                    }
                }
            }
        }
        return maxSize;
    }

    private int getMaxSize(char[][] matrix, int i, int j) {
        int length = 1;
        while (i + length - 1 < matrix.length && j + length - 1 < matrix[0].length) {
            boolean isSize = true;
            for (int m = 0; m < length; m++) {
                if (matrix[i + m][j+length-1] != '1') {
                    isSize = false;
                }
            }
            for (int n = 0; n < length; n++) {
                if (matrix[i+length-1][j + n] != '1') {
                    isSize = false;
                }
            }
            if (isSize == false) {
                break;
            }
            length++;
        }
        return (length - 1) * (length - 1);
    }

}
