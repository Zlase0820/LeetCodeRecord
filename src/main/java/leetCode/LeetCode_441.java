package leetCode;

public class LeetCode_441 {
    public static void main(String[] args) {
        int num = 2;
        LeetCode_441 leetCode_441 = new LeetCode_441();
        int result = leetCode_441.arrangeCoins(num);
        System.out.println(result);
    }

    /**
     * 一层一层往下减
     *
     * @param n 数量
     * @return 最多形成多少层
     */
    public int arrangeCoins(int n) {
        int temp = 1;
        while (n > 0) {
            n -= temp;
            if (n == 0) {
                return temp;
            }
            if (n < 0) {
                return temp - 1;
            }
            temp++;
        }
        return 0;
    }
}
