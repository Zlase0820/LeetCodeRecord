package leetCode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_575 {

    public static void main(String[] args) {
        LeetCode_575 leetCode_575 = new LeetCode_575();
        int[] candy = {1, 1, 1, 1,4,5};
        int num = leetCode_575.distributeCandies(candy);
        System.out.println(num);
    }

    /**
     * 本质是将数组分成两组，取其中最多的一半的数量
     * 用set做一个分类，如果set大于一半数组，返回一半数组，否则返回set的数量
     *
     * @param candyType 糖果数组
     * @return 最大的一半的数量
     */
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : candyType) {
            set.add(num);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}
