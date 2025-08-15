package leetCode;

public class LeetCode_256 {


    public static void main(String[] args) {
        LeetCode_256 leetCode = new LeetCode_256();
        int[][] grid = {
                {20, 18, 4},
                {9, 9, 10},
                {1, 2, 3}};
        int minCostNum = leetCode.minCost(grid);
        System.out.print(minCostNum);
    }

    /**
     * 这坑逼的答案解析，净整这些没有用的解题方案
     * 用DP的方法最简单，定义一个数组和costs一样大
     * 把最后一个房子（也就是n）需要的三个颜色填到costs的第n行中
     * 对于n-1行，三个颜色ABC，的后一个颜色，肯定选n行中两个最小的一个相加，为第n-1行最小成本
     * 如  {20, 18, 4},{9, 9, 10},{1, 2, 3}
     * 先定义第2行的结果{}，{}，{1,2,3}
     * 定义第1行需要的成本{}，{11,10,11}，{1,2,3}
     * 定义第0行需要的成本{30,29,14}，{11,10,11}，{1,2,3}
     * 最后取第0行，最小的成本即可
     *
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int[][] costNum = new int[costs.length][3];
        //最后一行进行赋值
        for (int i = 0; i < 3; i++) {
            costNum[costs.length - 1][i] = costs[costs.length - 1][i];
        }
        if (costs.length > 1) {
            for (int row = costs.length - 2; row >= 0; row--) {
                for (int col = 0; col < 3; col++) {
                    getMin(costs, costNum, row, col);
                }
            }
        }
        return Math.min(costNum[0][0], Math.min(costNum[0][1], costNum[0][2]));
    }

    private void getMin(int[][] costs, int[][] costNum, int row, int col) {
        int col1 = 0;
        int col2 = 0;
        switch (col) {
            case 0:
                col1 = 1;
                col2 = 2;
                break;
            case 1:
                col1 = 0;
                col2 = 2;
                break;
            case 2:
                col1 = 0;
                col2 = 1;
                break;
        }
        costNum[row][col] = costs[row][col] + Math.min(costNum[row + 1][col1], costNum[row + 1][col2]);
    }


//    /**
//     * 本来以为是动态规划，弄了半天还是弄成了DFS
//     * 把第一排房子想象成树的第一组节点，之后每次向后遍历两个节点，走到子节点，进行比较即可
//     * 注意：永远不要忘了做判空，输入可能为空
//     * 注意2：会超时，所以一定要剪枝  https://leetcode-cn.com/problems/paint-house/solution/fen-shua-fang-zi-by-leetcode/
//     *
//     * @param costs 房子花费
//     * @return 一共需要多少钱
//     */
//    public int minCostDp(int[][] costs) {
//        int houseNum = costs.length;
//        if (houseNum == 0) {
//            return 0;
//        }
//        int MINVALUE = Integer.MAX_VALUE;
//        for (int i = 0; i < 3; i++) {
//            int minNum = getMinCost(costs, 1, i, houseNum, costs[0][i], MINVALUE);
//            if (minNum < MINVALUE) {
//                MINVALUE = minNum;
//            }
//        }
//        return MINVALUE;
//    }
//
//    private int getMinCost(int[][] costs, int row, int col, int houseNum, int minNum, int MINVALUE) {
//        // 做一个简单的剪枝
//        if (minNum > MINVALUE) {
//            return minNum;
//        }
//        // 超范围就返回
//        if (row >= houseNum) {
//            return minNum;
//        }
//        int newCol1 = 0;
//        int newCol2 = 0;
//        switch (col) {
//            case 0:
//                newCol1 = 1;
//                newCol2 = 2;
//                break;
//            case 1:
//                newCol1 = 0;
//                newCol2 = 2;
//                break;
//            case 2:
//                newCol1 = 0;
//                newCol2 = 1;
//                break;
//        }
//        int temp1 = getMinCost(costs, row + 1, newCol1, houseNum, minNum + costs[row][newCol1], MINVALUE);
//        int temp2 = getMinCost(costs, row + 1, newCol2, houseNum, minNum + costs[row][newCol2], MINVALUE);
//        return Math.min(temp1, temp2);
//    }


}
