package leetCode;

import java.util.Stack;

/**
 * @author: zlase
 * @createDate: 2022/8/31
 * @description:
 */
public class LeetCode_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushNum = 0;
        int popNum = 0;
        Stack<Integer> stack = new Stack<>();

        while (pushNum < pushed.length && popNum < popped.length) {
            if (stack.isEmpty()) {
                stack.push(pushed[pushNum]);
                pushNum++;
                continue;
            }
            if (stack.peek() == popped[popNum]) {
                stack.pop();
                popNum++;
            } else {
                stack.push(pushed[pushNum]);
                pushNum++;
            }
        }

        // 特殊情况，剩下的需要全弹栈
        if (!stack.isEmpty() && pushNum == pushed.length) {
            while (popNum < popped.length) {
                if (stack.peek() == popped[popNum]) {
                    stack.pop();
                    popNum++;
                } else {
                    break;
                }
            }
        }

        return stack.isEmpty() && pushNum == pushed.length && popNum == popped.length;
    }
}
