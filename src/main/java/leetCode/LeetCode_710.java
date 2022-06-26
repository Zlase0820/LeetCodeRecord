package leetCode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: zlase
 * @createDate: 2022/6/26
 * @description:
 */
public class LeetCode_710 {

    Map<Integer, Integer> map = new HashMap<>();
    int max;

    // 需要比较精巧的思路
    public LeetCode_710(int n, int[] blacklist) {
        Arrays.sort(blacklist);
        max = n - blacklist.length;
        if (blacklist.length == 0) {
            return;
        }
        Set<Integer> blackSet = new HashSet<>(Arrays.stream(blacklist).boxed().collect(Collectors.toList()));
        for (int i = 0, j = n - blacklist.length; i < blacklist.length && blacklist[i] < max; i++) {
            while (blackSet.contains(j)) {
                j++;
            }
            map.put(blacklist[i], j);
            j++;
        }
    }

    public int pick() {
        int num = (int) (Math.random() * max);
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return num;
    }


    @Test
    public static void main(String[] args) {
        int n = 3;
        int[] blacklist = {2,1};
        LeetCode_710 leetCode = new LeetCode_710(n, blacklist);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int num = leetCode.pick();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }


}
