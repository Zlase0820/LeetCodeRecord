package leetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_149 {

    public static void main(String[] args) {
        LeetCode_149 leetCode = new LeetCode_149();
        int[][] nums = {{0, 0}, {0, 0}, {0, 0}};
        int length = leetCode.maxPoints(nums);
        System.out.print(length);
    }

    // 先二次遍历，找到所有斜率相同的，但是除法float中，可能还是会出现不同
    // 所以找数组的最大公约数，将所有的斜率压缩到最小
    // 之后在斜率最小的基础上，用Map进行计数
    public int maxPoints(int[][] points) {

        if (points.length == 0) {
            return 0;
        }

        if (points.length == 1 || points.length == 2) {
            return points.length;
        }

        int max = 0;
        for (int i = 0; i < points.length; i++) {
            int zeroNum = 0;
            Map<List<Integer>, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                int y = points[i][1] - points[j][1];
                int x = points[i][0] - points[j][0];
                if (x == 0 && y == 0) {
                    zeroNum++;
                    continue;
                } else if (x == 0 && y != 0) {
                    y = 1;
                } else if (y == 0 && x != 0) {
                    x = 1;
                } else {
                    int[] temp = getGreatestCommonDivisor(x, y);
                    x = temp[0];
                    y = temp[1];
                }
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(y);
                if (map.keySet().contains(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
            int maxValue = getMaxValue(map.values());
            if (maxValue + zeroNum > max) {
                max = maxValue + zeroNum;
            }
        }
        return max;
    }

    private int getMaxValue(Collection<Integer> values) {
        int max = 0;
        for (Integer tempNum : values) {
            if (tempNum > max) {
                max = tempNum;
            }
        }
        return max;
    }

    // 求最大公约数，辗转相除法
    // 返还相除后的最小值
    private int[] getGreatestCommonDivisor(int x, int y) {
        int originX = x, originY = y;
        if (originX < 0 && originY < 0) {
            originX = -x;
            originY = -y;
        }
        if (x < 0) {
            x = x * -1;
        }
        if (y < 0) {
            y = y * -1;
        }
        int a, b;
        int greatestCommonDivisor = 0;
        while (true) {
            if (x > y) {
                a = x;
                b = y;
            } else {
                a = y;
                b = x;
            }
            int temp = a % b;
            if (temp == 0) {
                greatestCommonDivisor = b;
                break;
            } else {
                x = temp;
                y = b;
            }
        }
        return new int[]{originX / greatestCommonDivisor, originY / greatestCommonDivisor};
    }
}
