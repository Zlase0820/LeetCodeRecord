package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeetCode_594 {
    public static void main(String[] args) {
        LeetCode_594 leetCode_594 = new LeetCode_594();
//        int[] numbers = {1, 3, 2, 2, 5, 2, 3, 7};
//        int[] numbers = {1, 2, 3, 4};
        int[] numbers = {1, 1, 1, 1};
        int length = leetCode_594.findLHS(numbers);
        System.out.println(length);
    }

    /**
     * 先使用Map，统计所有数字出现的频率
     * 之后将每一个数字都认为是小的数字，遍历一遍map，找到对应最大的长度即可，时间O(n)
     *
     * @param nums 数字
     * @return 最大频率
     */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            if (map.containsKey(key + 1)) {
                length = Math.max(length, map.get(key) + map.get(key + 1));
            }
        }
        return length;
    }
}




















