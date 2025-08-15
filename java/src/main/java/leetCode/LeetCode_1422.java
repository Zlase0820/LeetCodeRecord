package leetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: zlase
 * @createDate: 2022/8/14
 * @description:
 */
public class LeetCode_1422 {

    // 辅助数组，每一个单位存放前n个数字的加和(1数量)，之后在遍历一次，即可获得左侧0和右侧1的数量
    public int maxScore(String s) {
        int[] nums = new int[s.length()];
        if (s.charAt(0) == '1') {
            nums[0] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1];
            if (s.charAt(i) == '1') {
                nums[i]++;
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = i + 1 - nums[i] + nums[nums.length - 1] - nums[i];
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }

    @Test
    public void test1() {
        LeetCode_1422 leetCode_1422 = new LeetCode_1422();
        String s = "011101";
        int rightAnswer = 5;
        Assert.assertEquals("err", leetCode_1422.maxScore(s), rightAnswer);
    }

    @Test
    public void test2() {
        LeetCode_1422 leetCode_1422 = new LeetCode_1422();
        String s = "00111";
        int rightAnswer = 5;
        Assert.assertEquals("err", leetCode_1422.maxScore(s), rightAnswer);
    }

    @Test
    public void test3() {
        LeetCode_1422 leetCode_1422 = new LeetCode_1422();
        String s = "1111";
        int rightAnswer = 3;
        Assert.assertEquals("err", leetCode_1422.maxScore(s), rightAnswer);
    }
}



















