package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @authoer: zlase
 * @createDate: 2022/6/12
 * @description:
 */
public class LeetCode_497 {
    private List<Integer> pointNum;
    private int[][] rectCopy;
    private Random random;

    public LeetCode_497(int[][] rects) {
        this.rectCopy = rects;
        this.pointNum = new ArrayList<>();
        this.random = new Random();
        int point = 0;
        for (int[] location : rects) {
            point += (location[2] - location[0] + 1) * (location[3] - location[1] + 1);
            pointNum.add(point);
        }
    }

    public int[] pick() {
        // 根据点的数量找到在哪个矩形中
        int area = (int) (Math.random() * pointNum.get(pointNum.size() - 1));
        int num = 0;
        for (int i = 0; i < pointNum.size(); i++) {
            if (area < pointNum.get(i)) {
                num = i;
                break;
            }
        }
        int x = (int) (Math.random() * (rectCopy[num][2] - rectCopy[num][0] + 1)) + rectCopy[num][0];
        int y = (int) (Math.random() * (rectCopy[num][3] - rectCopy[num][1] + 1)) + rectCopy[num][1];
        return new int[]{x, y};
    }
}
