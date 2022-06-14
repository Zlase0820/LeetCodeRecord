package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zlase
 * @createDate: 2022/6/14
 * @description:
 */
public class LeetCode_498 {

    /**
     * 方案为从左侧一直遍历到底部，再从底部遍历到右下角
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int[] result = new int[mat.length * mat[0].length];
        List<List<Integer>> lists = new ArrayList<>();

        // 找对角线，从左上找到左下
        for (int i = 0; i < mat.length; i++) {
            int row = i;
            int col = 0;
            List<Integer> listTemp = new ArrayList<>();
            while (row >= 0 && col < mat[0].length) {
                listTemp.add(mat[row][col]);
                row--;
                col++;
            }
            lists.add(listTemp);
        }

        for (int j = 1; j < mat[0].length; j++) {
            int row = mat.length - 1;
            int col = j;
            List<Integer> listTemp = new ArrayList<>();
            while (row >= 0 && col < mat[0].length) {
                listTemp.add(mat[row][col]);
                row--;
                col++;
            }
            lists.add(listTemp);
        }

        // 塞入结果中
        int location = 0;
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> listTemp = lists.get(i);
            // 偶数，正向
            if ((i & 1) == 0) {
                for (Integer integer : listTemp) {
                    result[location] = integer;
                    location++;
                }
            } else {
                for (int j = listTemp.size() - 1; j >= 0; j--) {
                    result[location] = listTemp.get(j);
                    location++;
                }
            }
        }
        return result;
    }

}
