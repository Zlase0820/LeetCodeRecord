package leetCode;

import org.junit.Assert;
import org.junit.Test;

public class LeetCode_829 {


    public int consecutiveNumbersSum(int n) {
        int count = 0;
        int result;
        int remainder;
        for (int i = 1; i <= n; i++) {
            result = n / i;
            remainder = n % i;

            // 先判断是否超过边界，计算最左侧的位置
            // 除数是偶数
            if ((i & 1) == 0) {
                if (result - (i / 2 - 1) <= 0) {
                    break;
                }
            } else {  //除数是奇数
                if (result - i / 2 <= 0) {
                    break;
                }
            }

            // 除数的值是奇数
            if ((i & 1) == 1 && remainder == 0) {
                count++;
            } else if (remainder * 2 == i) {
                // 除数是偶数
                count++;
            }
        }
        return count;
    }

    @Test
    public void test1() {
        int n = 1;
        int result = 1;
        LeetCode_829 leetCode_829 = new LeetCode_829();
        Assert.assertEquals("error", leetCode_829.consecutiveNumbersSum(n), result);
    }

    @Test
    public void test2() {
        int n = 5;
        int result = 2;
        LeetCode_829 leetCode_829 = new LeetCode_829();
        Assert.assertEquals("error", leetCode_829.consecutiveNumbersSum(n), result);
    }

    @Test
    public void test3() {
        int n = 9;
        int result = 3;
        LeetCode_829 leetCode_829 = new LeetCode_829();
        Assert.assertEquals("error", leetCode_829.consecutiveNumbersSum(n), result);
    }

    @Test
    public void test4() {
        int n = 15;
        int result = 4;
        LeetCode_829 leetCode_829 = new LeetCode_829();
        Assert.assertEquals("error", leetCode_829.consecutiveNumbersSum(n), result);
    }

    @Test
    public void test5() {
        int n = 3;
        int result = 2;
        LeetCode_829 leetCode_829 = new LeetCode_829();
        Assert.assertEquals("error", leetCode_829.consecutiveNumbersSum(n), result);
    }

}
