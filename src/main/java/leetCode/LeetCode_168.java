package leetCode;

import java.util.Stack;

/**
 * @author: zlase
 * @createDate: 2022/6/15
 * @description:
 */
public class LeetCode_168 {

    // 相当于26进制，唯一麻烦就是要搞0
    // 每次计算时候需要-1
    public String convertToTitle(int columnNumber) {
        columnNumber--;
        Stack<Integer> stack = new Stack<>();
        while (columnNumber >= 26) {
            stack.add(columnNumber % 26);
            columnNumber = columnNumber / 26;
            columnNumber--;
        }
        StringBuilder result = new StringBuilder();
        result.append((char) ('A' + columnNumber));
        while (!stack.isEmpty()) {
            result.append((char) ('A' + stack.pop()));
        }
        return result.toString();
    }

}
