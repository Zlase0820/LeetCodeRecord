package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_127 {
    public static void main(String[] args) {
        LeetCode_127 leetCode = new LeetCode_127();
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        int[] result = leetCode.relativeSortArray(arr1, arr2);
        System.out.print(result);
    }


    /**
     * 将数组1分成两段，第一段是根据arr2中的进行赋值，
     * 第二段直接swap排序好即可
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 返回值
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 处理第一段，返回arr2中每个字符在arr1中出现了多少次
        int[] arr2Num = new int[arr2.length];


        return null;
    }


    private Map<Integer,Integer> getArr2Num(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            } else {
                map.put(arr1[i], 0);
            }
        }
        return map;
    }

}
