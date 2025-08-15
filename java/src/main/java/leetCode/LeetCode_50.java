package leetCode;

public class LeetCode_50 {
    public static void main(String[] args) {
        LeetCode_50 leetCode_50 = new LeetCode_50();
        double num = leetCode_50.myPow(2.0, -3);
        System.out.println(num);
    }

    /**
     * 折半计算，尽可能减少乘法的次数
     *
     * @param x 原数字
     * @param n 多少次幂
     * @return pow函数
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double last = 1.0;
        double unit = x;
        int num = n;
        while (num != 1 && num != -1) {
            // 不能用&，因为可能有负数
            if (num % 2 != 0) {
                last = last * unit;
            }
            num = num / 2;
            unit = unit * unit;
        }
        if (n < 0) {
            return 1 / (unit * last);
        } else {
            return unit * last;
        }
    }
}
