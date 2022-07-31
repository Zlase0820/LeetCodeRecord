package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zlase
 * @createDate: 2022/7/31
 * @description:
 */
public class LeetCode_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergeList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[0] && interval[1] >= newInterval[1]) {
                // 如果interval可以包住newInterval
                mergeList.add(interval);
                newInterval = new int[]{-1, -1}; // 从此不再受到影响
            } else if ((interval[0] <= newInterval[0] && interval[1] >= newInterval[0])
                    || (interval[0] <= newInterval[1] && interval[1] >= newInterval[1])
                    || (newInterval[0] <= interval[0] && newInterval[1] >= interval[1])) {
                // 单纯的相交，扩大newInterval的范围
                // 如果newInterval可以包住interval
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // 无相交部分
                mergeList.add(interval);
            }
        }
        if (newInterval[0] != -1) {
            mergeList.add(newInterval);
        }
        mergeList.sort((o1, o2) -> o1[0] - o2[0]);
        int[][] result = new int[mergeList.size()][];
        for (int i = 0; i < mergeList.size(); i++) {
            result[i] = mergeList.get(i);
        }
        return result;
    }
}
