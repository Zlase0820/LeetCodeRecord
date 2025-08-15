package leetCode;

public class LeetCode_322 {

    // 零钱兑换I
    public static void main(String[] args) {
        LeetCode_322 leetCode = new LeetCode_322();
        int[] coins = {2, 5};
        int amount = 1;
        int num = leetCode.coinChange(coins,amount);
        System.out.print(num);
    }

    // dp[x] 表示达到x这个值，最少需要的硬币的数量
    // dp[x] = min{dp(x-coins[i])+1,dp[x]}
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] minNum = new int[amount + 1];   // 用来存储达到这个值用的最少硬币的数量
        minNum[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            minNum[i] = 99999;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    minNum[i] = Math.min(minNum[i], minNum[i - coin] + 1);
                }
            }
        }
        if (minNum[amount] == 99999) {
            return -1;
        } else {
            return minNum[amount];
        }
    }
}
