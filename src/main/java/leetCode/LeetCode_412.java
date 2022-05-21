package leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_412 {

    public static void main(String[] args) {
        LeetCode_412 leetCode_412 = new LeetCode_412();
        int num = 15;
        List<String> list = leetCode_412.fizzBuzz(num);
        System.out.println(list);
    }

    /**
     * 很简单的题，依次进行遍历，时间O(n)
     *
     * @param n 数字
     * @return 返回值
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String temp = "";
            boolean isDivide = false;
            if (i % 3 == 0) {
                temp += "Fizz";
                isDivide = true;
            }
            if (i % 5 == 0) {
                temp += "Buzz";
                isDivide = true;
            }
            if (!isDivide) {
                temp += i;
            }
            list.add(temp);
        }
        return list;
    }
}
















