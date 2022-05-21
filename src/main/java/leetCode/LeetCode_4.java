package leetCode;

public class LeetCode_4 {

    // 假设int值都是升序排列
    public static void main(String[] args) {
        int[] num1 = {1, 2, 5, 7};
        int[] num2 = {3};
        LeetCode_4 leetCode_4 = new LeetCode_4();
        double num = leetCode_4.findMedianSortedArrays1(num1, num2);
        System.out.print(num);
    }

    // 双指针遍历  时间复杂度为 m+n
    // 需要看二者的和为奇数还是偶数，如果是奇数，那就是最中间的值，如果是偶数，就是中间两个的平均值
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        double returnNum = 0;
        // 如果是奇数直接走中间的值
        if ((num1Length + num2Length) % 2 == 1) {
            int breakNum = 0;
            int p1 = 0;
            int p2 = 0;
            while (breakNum < (num1Length + num2Length) / 2) {
                if(nums1[p1] <= nums2[p2]){
                    if (p1 < num1Length - 1) {
                        returnNum = nums1[p1];
                        p1++;
                    } else {
                        returnNum = nums2[p2];
                        p2++;
                    }
                } else {
                    if (p2 < num2Length - 1) {
                        returnNum = nums2[p2];
                        p2++;
                    } else {
                        returnNum = nums1[p1];
                        p1++;
                    }
                }
                breakNum = p1 + p2;
            }
        }


        return returnNum;
    }


}
