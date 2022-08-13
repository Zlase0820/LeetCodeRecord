package leetCode;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: zlase
 * @createDate: 2022/8/13
 * @description:
 */
public class LeetCode_768 {

    // arr和sortArr比较，如果前部分的数字内容一致了，就可以将其切成一段
    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        int[] sortArr = arr.clone();
        Arrays.sort(sortArr);

        int location = 0;
        while (location < arr.length) {
            List<Integer> listSort = new ArrayList<>();
            List<Integer> listArr = new ArrayList<>();
            while (location < arr.length) {
                listArr.add(arr[location]);
                listSort.add(sortArr[location]);
                location++;
                if (isEqual(listSort, listArr)) {
                    break;
                }
            }
            result++;
        }
        return result;
    }

    // 排序判断是否相等
    private boolean isEqual(List<Integer> list1, List<Integer> list2) {
        list1.sort(Comparator.comparingInt(o -> o));
        list2.sort(Comparator.comparingInt(o -> o));
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        int[] nums = {5, 4, 3, 2, 1};
        int rightAnswer = 1;
        LeetCode_768 leetCode_768 = new LeetCode_768();
        Assert.assertEquals("err1", leetCode_768.maxChunksToSorted(nums), rightAnswer);
    }

    @Test
    public void test2() {
        int[] nums = {2, 1, 3, 4, 4};
        int rightAnswer = 4;
        LeetCode_768 leetCode_768 = new LeetCode_768();
        Assert.assertEquals("err2", leetCode_768.maxChunksToSorted(nums), rightAnswer);
    }

    @Test
    public void test3() {
        int[] nums = {};
        int rightAnswer = 0;
        LeetCode_768 leetCode_768 = new LeetCode_768();
        Assert.assertEquals("err2", leetCode_768.maxChunksToSorted(nums), rightAnswer);
    }


}
