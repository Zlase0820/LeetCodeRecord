package leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_66 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        LeetCode_66 leetCode_66 = new LeetCode_66();
        int[] results = leetCode_66.plusOne(nums);
        System.out.println(results);
    }

    /**
     * 一年前做过这个题目，一年后的我再试试
     *
     * @param digits 数组
     * @return 返还值
     */
    public int[] plusOne(int[] digits) {
        List<Integer> lists = new ArrayList<>();
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + carry > 9) {
                lists.add(0, 0);
                carry = 1;
            } else {
                lists.add(0, digits[i] + carry);
                carry = 0;
            }
        }
        // 补最前边的1，用于99转100
        if (carry == 1) {
            lists.add(0, 1);
        }
        return lists.stream().mapToInt(Integer::intValue).toArray();
    }
}
