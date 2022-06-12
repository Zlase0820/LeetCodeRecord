package leetCode;

/**
 * @authoer: zlase
 * @createDate:2022/6/12
 * @description:
 */
public class LeetCode_926 {

    /**
     * 使用拆分法，找到一个点作为分割点，分割点左侧全都是0(包括自身)，分割点右侧全都是1
     * 那么分割点左侧1的数量和分割点右侧0的数量即为需要变化的数量，最终取所有值中变化最小的即可
     */
    public int minFlipsMonoIncr(String s) {
        // 边界情况
        if (s.length() < 2) {
            return 0;
        }

        int[] nums = new int[s.length()];

        // 分割点右侧的1的数量
        int right = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                right++;
            }
        }
        int minNum = s.length() - right; // 假设全是1的情况下，需要改变的数量

        // 防止超范围，找第一个点
        if (s.charAt(0) == '1') {
            nums[0] = 1 + ((s.length() -1) - (right - 1));
            right--;
            left++;
        } else {
            nums[0] = s.length() - 1 - right;
        }

        // 查找后边的分割点
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                nums[i] = left + 1 + s.length() - i - right;
                right--;
                left++;
            } else {
                nums[i] = left + s.length() - 1 - i - right;
            }
        }

        for (int num : nums) {
            if (num < minNum) {
                minNum = num;
            }
        }

        return minNum;
    }
}
