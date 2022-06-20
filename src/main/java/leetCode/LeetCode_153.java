package leetCode;

/**
 * @author: zlase
 * @createDate: 2022/6/20
 * @description:
 */
public class LeetCode_153 {
    /**
     * 用二分法完成程序设计，保证时间复杂度为 logN
     * 1.每次取中间的值，如果出现其左侧比其大则该值为最小值，若右侧比其小则右值为最小值
     * 2.若没有1中的情况
     * a.若选中的值比left和right大，说明在左侧上升区间，取右侧
     * b.若选中的值比left和right小，说明在不纯粹的上升区间，取左侧
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (right - left > 1) {
            // 边界判断
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // 选中值比两边大
            if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
                left = mid;
                mid = (left + right) / 2;
            } else {
                right = mid;
                mid = (left + right) / 2;
            }
        }
        return Math.min(nums[left], nums[right]);
    }

}
