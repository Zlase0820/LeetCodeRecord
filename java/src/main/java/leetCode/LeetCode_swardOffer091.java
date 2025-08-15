package leetCode;

/**
 * @author: zlase
 * @createDate: 2022/6/25
 * @description:
 */
public class LeetCode_swardOffer091 {


    // 使用动态规划，每次计算出本行选择这个对应颜色之前最小的取值即可
    public int minCost(int[][] costs) {
        if (costs.length == 1) {
            return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
        }
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] = Math.min(costs[i - 1][1], costs[i - 1][2]) + costs[i][0];
            costs[i][1] = Math.min(costs[i - 1][0], costs[i - 1][2]) + costs[i][1];
            costs[i][2] = Math.min(costs[i - 1][0], costs[i - 1][1]) + costs[i][2];
        }
        return Math.min(Math.min(costs[costs.length - 1][0], costs[costs.length - 1][1]), costs[costs.length - 1][2]);
    }
}
