package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15 {

    public static void main(String[] args) {
        LeetCode_15 leetCode = new LeetCode_15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> listNum = leetCode.threeSum(nums);
        System.out.println(listNum);
    }


    // 原题目是 a+b+c=0，如果变成a+b=-c，这样就可以将时间复杂度降低为 n^2
    // 如果有部分不可能的答案，在运行期间被跳过，则可以进一步的节省时间
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return ls;
    }

}
