package leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author: zlase
 * @createDate: 2022/7/28
 * @description:
 */
public class LeetCode_1331 {
    // 将数组的位置存储到Map中，在将数组进行排序，最后一一映射即可
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            List<Integer> temp = map.getOrDefault(arr[i], new ArrayList<>());
            temp.add(i);
            map.put(arr[i], temp);
            set.add(arr[i]);
        }
        int[] result = new int[arr.length];
        int nums = 1;
        for (Integer num : set) {
            List<Integer> temp = map.get(num);
            for (Integer location : temp) {
                result[location] = nums;
            }
            nums++;
        }
        return result;
    }
}
