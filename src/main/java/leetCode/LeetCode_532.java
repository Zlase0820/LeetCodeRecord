package leetCode;

import java.util.*;

/**
 * @author: zlase
 * @createDate: 2022/6/16
 * @description:
 */
public class LeetCode_532 {
    /**
     * 1.set去重(还真不能去重，因为有k=0的情况)
     * 2.list排序
     * 3.双指针遍历一次
     * 时间复杂度n
     * 空间复杂度n
     */
    public int findPairs(int[] nums, int k) {
        Set<String> set = new HashSet<>();  // 结果去重
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort(Comparator.comparingInt(integer -> integer));

        if (list.size() <= 1) {
            return 0;
        }

        int p1 = 0;
        int p2 = 0;
        while (p2 < list.size()) {
            if (p1 == p2) {
                p2++;
                continue;
            }
            if (list.get(p2) - list.get(p1) == k) {
                set.add(list.get(p2) + "-" + list.get(p1));
                p2++;
            } else if (list.get(p2) - list.get(p1) > k) {
                p1++;
            } else {
                p2++;
            }
        }
        return set.size();
    }
}
