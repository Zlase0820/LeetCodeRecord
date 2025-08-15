package leetCode;

public class LeetCode_518 {

    // 零钱兑换II
    // 只是万万没想到零钱兑换1和2的差别还是很大的
    public static void main(String[] args) {
        LeetCode_518 leetCode = new LeetCode_518();
        int[] coins = {1};
        int amount = 3;
        int num = leetCode.change(amount, coins);
        System.out.print(num);
    }

    // 使用每一个硬币做一次循环
    // 每一次根据该硬币能达到的最大数值计算该数值可以达到的最大组合方式
    // dp[x] = dp[x] + dp[x-coin]  所以第一枚硬币遍历就变得很重要
    public int change(int amount, int[] coins) {
        int[] num = new int[amount+1];   // 记录每一个面值的最大组合数量
        num[0] = 1;                       // 需要认为任何一个coin拼装出0都只需要0个，只有一种情况即可
        for(int coin:coins){
            for(int i=0;i+coin<=amount;i++){
                num[i+coin] += num[i];
            }
        }
        return num[amount];
    }

}
