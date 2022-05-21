package leetCode;

public class LeetCode_492 {
    public static void main(String[] args) {
        int area = 7;
        LeetCode_492 leetCode_492 = new LeetCode_492();
        int[] nums = leetCode_492.constructRectangle(area);
        System.out.println(nums);
    }

    /**
     * 传递一个面积，找到其可能最类似正方形的矩形
     * W x W <= W x L = area 因此，对area进行开方，找到其W值，每次让W进行减少，如果能找到整除，那个L就是最终的L值
     *
     * @param area 面积
     * @return 返还的矩形的长L和宽
     */
    public int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);
        while (area % width != 0) {
            width--;
        }
        return new int[]{area / width, width};
    }
}














