package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zlase
 * @createDate: 2022/8/25
 * @description:
 */
public class LeetCode_658 {

    // 仿真即可
    // 优先找到arr中距离x最近的点作为原点，之后使用双指针，分别向着原点的左右两侧扩展，直到两侧的长度达到k，如果有边界则扩展另外一侧
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int origin = findOrigin(arr, x);
        int left = origin;
        int right = origin;
        while (right - left + 1 < k) {
            if (left <= 0) {
                right++;
            } else if (right >= arr.length - 1) {
                left--;
            } else if (x - arr[left - 1] <= arr[right + 1] - x) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    // 找到原点
    private int findOrigin(int[] arr, int x) {
        if (arr[0] >= x) {
            return 0;
        }
        if (arr[arr.length - 1] < x) {
            return arr.length - 1;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < x && arr[i + 1] >= x) {
                return x - arr[i] <= arr[i + 1] - x ? i : i + 1;
            }
        }
        return arr.length - 1;
    }

    @Test
    public void test1() {
        LeetCode_658 leetCode_658 = new LeetCode_658();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> list = leetCode_658.findClosestElements(arr, k, x);
    }

    @Test
    public void test2() {
        LeetCode_658 leetCode_658 = new LeetCode_658();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = -1;
        List<Integer> list = leetCode_658.findClosestElements(arr, k, x);
    }

    @Test
    public void test3() {
        LeetCode_658 leetCode_658 = new LeetCode_658();
        int[] arr = {0, 0, 0, 1, 3, 5, 6, 7, 8, 8};
        int k = 2;
        int x = 2;
        List<Integer> list = leetCode_658.findClosestElements(arr, k, x);
    }
}
