package leetCode;

public class LeetCode_94 {
    public static void main(String[] args) {
        LeetCode_94 leetCode = new LeetCode_94();
        int num = 2;
        int maxNum = leetCode.numTrees(num);
        System.out.print(maxNum);
    }

    /**
     * 95题是直接算出来有哪些，非常具体，但是94题需要直接给出数量，全部弄出来这种方式会超时
     * 这个题用动态规划就可以做
     * dp[]为有这个数字长度可以组成的种类
     * dp[0]=0  实际上不会有
     * dp[1]=1  只有一个1存在
     * dp[2]=2  1为根，2为右  2为根，1为左
     * dp[3]=dp[0]*dp[2] + dp[1]*dp[1] + dp[2]*dp[0]  1为根，右侧有两个； 2为根，左右各1个； 3为根左侧为2个
     * ...
     *
     * @param n 最大长度
     * @return 可以拼接成的最大二叉查找树的数量
     */
    public int numTrees(int n) {
        if (n < 3) {
            return n;
        }
        int[] combination = new int[n + 1];
        combination[0] = 1;
        combination[1] = 1;
        combination[2] = 2;
        for (int i = 3; i <= n; i++) {
            int otherNodeNum = i - 1;
            int num = 0;
            for (int j = 0; j <= otherNodeNum; j++) {
                num += combination[j] * combination[otherNodeNum - j];
            }
            combination[i] = num;
        }
        return combination[n];
    }


}
