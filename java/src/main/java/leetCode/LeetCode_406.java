package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode_406 {
    public static void main(String[] args) {
        LeetCode_406 leetCode406 = new LeetCode_406();
        int[][] nums = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] sortNums = leetCode406.reconstructQueue(nums);
        System.out.println();

    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });

        List<int[]> lists = new ArrayList<>();
        lists.add(people[0]);
        for (int i = 1; i < people.length; i++) {
            if (people[i][1] >= lists.size()) {
                lists.add(people[i]);
            } else {
                lists.add(people[i][1], people[i]);
            }
        }
        return lists.toArray(new int[people.length][]);
    }
}
