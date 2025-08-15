package leetCode;

import java.util.Stack;

/**
 * @author: zlase
 * @createDate: 2022/8/11
 * @description:
 */
public class LeetCode_1417 {
    // 正常仿真就好，无难度
    public String reformat(String s) {
        Stack<Character> numList = new Stack<>();
        Stack<Character> cNumList = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            if (tempChar <= '9' && tempChar >= '0') {
                numList.add(tempChar);
            } else {
                cNumList.add(tempChar);
            }
        }
        if (Math.abs(numList.size() - cNumList.size()) > 1) {
            return "";
        }

        if (numList.size() == cNumList.size()) {
            return mergeStack(numList, cNumList);
        } else if (numList.size() > cNumList.size()) {
            return numList.pop() + mergeStack(cNumList, numList);
        } else {
            return cNumList.pop() + mergeStack(numList, cNumList);
        }
    }

    private String mergeStack(Stack<Character> firstStack, Stack<Character> secondStack) {
        StringBuilder sb = new StringBuilder();
        while (!firstStack.isEmpty()) {
            sb.append(firstStack.pop());
            sb.append(secondStack.pop());
        }
        return sb.toString();
    }
}
