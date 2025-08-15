package leetCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zlase
 * @createDate: 2022/8/4
 * @description:
 */
public class LeetCode_1403 {
    // 先求和，降序排列，前n个值比后半段大的进行返回
    // 用流式写法还是挺方便的
    public List<Integer> minSubsequence(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int tempResult = 0;
        List<Integer> sortArray = Arrays.stream(nums).boxed().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
        for (int i = 0; i < sortArray.size(); i++) {
            tempResult += sortArray.get(i);
            sum -= sortArray.get(i);
            if (tempResult > sum) {
                return sortArray.subList(0, i + 1);
            }
        }
        return sortArray;
    }
}
