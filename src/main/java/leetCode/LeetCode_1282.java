package leetCode;

import java.util.*;

/**
 * @author: zlase
 * @createDate: 2022/8/12
 * @description:
 */
public class LeetCode_1282 {
    // 仿真
    // 首先进行聚合，将groupSizes存储到一个Map中，key为组号，value为groupSizes当下编号
    // 遍历Map，将结果放置到List<List<Integer>>中
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            Stack<Integer> stack = map.getOrDefault(groupSizes[i], new Stack<>());
            stack.add(i);
            map.put(groupSizes[i], stack);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Stack<Integer>> entry : map.entrySet()) {
            Stack<Integer> stack = entry.getValue();
            while (!stack.isEmpty()) {
                List<Integer> resultTemp = new ArrayList<>();
                for (int i = 0; i < entry.getKey(); i++) {
                    resultTemp.add(stack.pop());
                }
                result.add(resultTemp);
            }
        }
        return result;
    }
}
