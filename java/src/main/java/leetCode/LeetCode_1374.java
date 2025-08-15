package leetCode;

/**
 * @author: zlase
 * @createDate: 2022/8/1
 * @description:
 */
public class LeetCode_1374 {
    // 这题没有任何意义
    // 如果n是奇数，就放置n个a
    // 如果n是偶数，就放置一个a后边是n-1个b即可
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if ((n & 1) == 0) {
            // 偶数
            sb.append('a');
            n--;
        }
        for (int i = 0; i < n; i++) {
            sb.append('b');
        }
        return sb.toString();
    }
}
