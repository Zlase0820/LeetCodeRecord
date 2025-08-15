package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: zlase
 * @createDate: 2022/8/3
 * @description:
 */
public class LeetCode_899 {
    // 这题难度达不到困难
    // 有两种情况
    // 如果k>=2，在不限制循环的情况下，使用 (次小)（最小）defgvc 这种循环的方式，可以获得全局字典最小，排序即可；时间复杂度nlogn
    // 如果k==1，相当于找到s中以字典最小开头的所有枚举string，并进行比较即可.时间复杂度 n+nlogn
    public String orderlyQueue(String s, int k) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        char[] arrays = s.toCharArray();
        if (k != 1) {
            Arrays.sort(arrays);
            return String.valueOf(arrays);
        }
        // 从头开始进行构筑
        List<String> lists = new ArrayList<>();
        char minChar = s.charAt(0);  // 找到最小的开头
        for (char tempChar : arrays) {
            if (minChar > tempChar) {
                minChar = tempChar;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == minChar) {
                lists.add(s.substring(i) + s.substring(0, i));
            }
        }
        lists.sort(Comparator.naturalOrder());
        return lists.get(0);
    }
}
