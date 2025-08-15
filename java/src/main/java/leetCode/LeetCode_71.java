package leetCode;

import java.util.Stack;

public class LeetCode_71 {

    public static void main(String[] args) {
        LeetCode_71 leetCode = new LeetCode_71();
        String path = "/a//b////c/d//././/..";
        String simplePath = leetCode.simplifyPath(path);
        System.out.println(simplePath);
    }

    /**
     * 简化路径的要求：
     * 1.多个//连续要变成一个/
     * 2.结尾有/都要删除掉
     * 3.单个的.表示就在此路径可以直接删掉
     * 4.连续的两个.表示返回上一层目录
     * <p>
     * 用一个stack保存所有的路径即可，从头开始遍历，遇到字母就可以保存，遇到..就弹出，遇到.就忽略
     * 最后弹出stack中所有内容重新拼接一个字符串即可
     *
     * @param path 原始路径
     * @return 简化后的路径
     */
    public String simplifyPath(String path) {
        String[] splitName = path.split("/");
        Stack<String> stack = new Stack<>();

        // 用stack压缩所有内容
        for (int i = 0; i < splitName.length; i++) {
            if (splitName[i].equals("") || splitName[i].equals(".")) {
                continue;
            }
            if (splitName[i].equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
                continue;
            }
            stack.add(splitName[i]);
        }

        // 空的直接输出
        if (stack.empty()) {
            return "/";
        }

        // 输出stack中的所有结果
        StringBuilder returnString = new StringBuilder();
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            returnString.insert(0, "/" + stack.pop());
        }
        return returnString.toString();
    }
}
