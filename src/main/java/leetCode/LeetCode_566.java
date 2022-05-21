package leetCode;

public class LeetCode_566 {

    public static void main(String[] args) {
        LeetCode_566 leetCode_566 = new LeetCode_566();
        int[][] nums = {{1, 2}, {3, 4}};
        int[][] reshapeMatrix = leetCode_566.matrixReshape(nums, 1, 4);
        System.out.println(reshapeMatrix);
    }

    /**
     * 重新构建一个矩阵（行便利）
     * 如果不能满足刚刚好填充，则返回之前的矩阵
     * 使用一个二维矩阵转一维矩阵的小知识，对于一个二维矩阵中的一个值(i,j)对应到一维矩阵的x位置上
     * i * col + j = x
     * 同理，一个一维矩阵中的第x个值，在二维矩阵中的位置为：
     * m = x / col
     * n = x % col
     *
     * @param nums 原始矩阵
     * @param r    重构后的行数
     * @param c    重构后的列数
     * @return 重构后的矩阵
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int col = nums[0].length;
        int row = nums.length;
        int allNum = r * c;
        if (col * row != allNum) {
            return nums;
        }
        int[][] matrix = new int[r][c];
        // 遍历两个数组，使用四层循环遍历; 外层两个是reshape后的矩阵，内层两个是原始矩阵
        int num = 0;
        while (num < allNum) {
            matrix[num / c][num % c] = nums[num / col][num % col];
            num++;
        }
        return matrix;
    }
}
