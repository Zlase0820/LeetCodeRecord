package leetCode;

import java.util.*;

public class LeetCode_316 {

    public static void main(String[] args) {
        LeetCode_316 leetCode316 = new LeetCode_316();
        String s = "cbacdcbc";
        String returnString = leetCode316.removeDuplicateLetters(s);
        System.out.println(returnString);
    }

    /**
     * 字典序是根据字符串最前边的顺序来确认最终大小的，即 azzzzzzz > baaaaa
     * 设定一个栈，如果栈是空的，则加入下一个字符
     * 如果栈不是空，下一个字符string[i]比栈顶小，栈顶的字符要在(i,n)的范围内查找是否还有栈顶存在
     * 如果存在，说明可以使用后边的值，弹栈
     * 如果不存在，说明这个字符必须要使用，把当前字符压入存为栈顶
     *
     * @param s 字符串
     * @return 去重之后保证字典顺序的串
     */
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        // 直接用数组，空间复杂度更低
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}

















