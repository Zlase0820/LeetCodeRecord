package leetCode;

import java.util.*;

public class LeetCode_414 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 1};
        LeetCode_414 leetCode_414 = new LeetCode_414();
        int num = leetCode_414.thirdMax(nums);
        System.out.println(num);
    }

    /**
     * 排序，遍历即可
     *
     * @param nums num
     * @return 返回第三大的数字
     */
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        if (list.size() < 3) {
            return list.get(list.size() - 1);
        } else {
            return list.get(list.size() - 3);
        }
    }
}
