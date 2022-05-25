package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_467 {

    @Test
    public void test1() {
        LeetCode_467 leetCode_467 = new LeetCode_467();
        String testString = "zab";
        Assert.assertEquals("error",
                6, leetCode_467.findSubstringInWraproundString(testString));
    }

    @Test
    public void test2() {
        LeetCode_467 leetCode_467 = new LeetCode_467();
        String testString = "z";
        Assert.assertEquals("error",
                1, leetCode_467.findSubstringInWraproundString(testString));
    }

    @Test
    public void test3() {
        LeetCode_467 leetCode_467 = new LeetCode_467();
        String testString = "cac";
        Assert.assertEquals("error",
                2, leetCode_467.findSubstringInWraproundString(testString));
    }

    @Test
    public void test4() {
        LeetCode_467 leetCode_467 = new LeetCode_467();
        String testString = "aabb";
        Assert.assertEquals("error",
                3, leetCode_467.findSubstringInWraproundString(testString));
    }

    @Test
    public void test5() {
        LeetCode_467 leetCode_467 = new LeetCode_467();
        String testString = "bcdabcd";
        Assert.assertEquals("error",
                10, leetCode_467.findSubstringInWraproundString(testString));
    }

    public int findSubstringInWraproundString(String p) {
        // 只有一个字符
        if (p.length() == 1) {
            return 1;
        }

        // 超过一个字符
        int[] dp = new int[p.length()];
        dp[0] = 1;
        for (int i = 1; i < p.length(); i++) {
            Character charBefore = p.charAt(i - 1);
            Character charNow = p.charAt(i);
            // 跟前一个连接起来了
            if ((charBefore.equals('z') && charNow.equals('a')) || charBefore + 1 == charNow) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        // 去除掉 bcd abcd被重复统计的情况
        int[] counts = new int[26];
        for (int i = 0; i < dp.length; i++) {
            // 判断是否超出了范围
            int location = p.charAt(i) - 'a';
            counts[location] = Math.max(counts[location], dp[i]);
        }

        for (int i = 0; i < dp.length; i++) {
            // 判断是否超出了范围
            int location = p.charAt(i) - 'a';
            counts[location] = Math.max(counts[location], dp[i]);
        }

        // 计算有多少结果
        int count = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 1; j <= counts[i]; j++) {
                count += j;
            }
        }
        return count;
    }

}
