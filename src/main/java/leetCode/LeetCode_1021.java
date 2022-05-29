package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class LeetCode_1021 {


    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == '(') {
                result.append('(');
                stack.add('(');
            } else {
                // 一定是一个右括号
                stack.pop();
                if (!stack.isEmpty()) {
                    result.append(')');
                }
            }
        }
        return result.toString();
    }


    @Test
    public void test1() {
        String string = "(()())(())(()(()))";
        String result = "()()()()(())";
        LeetCode_1021 leetCode_1021 = new LeetCode_1021();
        Assert.assertEquals("error", leetCode_1021.removeOuterParentheses(string), result);
    }

    @Test
    public void test2() {
        String string = "(()())(())";
        String result = "()()()";
        LeetCode_1021 leetCode_1021 = new LeetCode_1021();
        Assert.assertEquals("error", leetCode_1021.removeOuterParentheses(string), result);
    }

    @Test
    public void test3() {
        String string = "()()";
        String result = "";
        LeetCode_1021 leetCode_1021 = new LeetCode_1021();
        Assert.assertEquals("error", leetCode_1021.removeOuterParentheses(string), result);
    }
}
