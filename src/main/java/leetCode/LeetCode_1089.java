package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zlase
 * @createDate: 2022/6/17
 * @description:
 */
public class LeetCode_1089 {

    public void duplicateZeros(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length && list.size() <= arr.length; i++) {
            if (arr[i] != 0) {
                list.add(arr[i]);
            } else {
                list.add(0);
                list.add(0);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }

    @Test
    public void test1() {
        int[] nums = {1, 0, 2, 3, 0, 4, 5, 0};
        int[] result = {1, 0, 0, 2, 3, 0, 0, 4};
        LeetCode_1089 leetCode_1089 = new LeetCode_1089();
        leetCode_1089.duplicateZeros(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != result[i]) {
                System.out.println("error");
            }
        }
    }


}
