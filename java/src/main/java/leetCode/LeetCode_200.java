package leetCode;

public class LeetCode_200 {

    // 假设int值都是升序排列
    public static void main(String[] args) {
        LeetCode_200 leetCode = new LeetCode_200();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '0', '0', '0'}};
        int num = leetCode.numIslands(grid);
        System.out.print(num);
    }

    // 用递归和感染函数的方式，时间复杂度为不到n^2
    // 正常遍历二维数组，如果走到了岛1，就将其送进infect感染函数中，将其临近的所有岛设置为海0，递归至所有的岛
    // 每次进入infect感染函数，给岛的数量+1
    public int numIslands(char[][] grid) {
        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    infect(grid, i, j);
                }

            }
        }
        return island;
    }

    // 感染函数
    public void infect(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length-1 || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        infect(grid,i,j-1);  // 上
        infect(grid,i,j+1);  // 下
        infect(grid,i-1,j);  // 左
        infect(grid,i+1,j);  // 右
    }

}
