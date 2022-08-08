package leetCode;

import java.util.List;
import java.util.Stack;

/**
 * @author: zlase
 * @createDate: 2022/8/8
 * @description:
 */
public class LeetCode_636 {
    /**
     * 解决方案：
     * 设定一个长度为n的数组作为返还数组
     * 设定一个Stack做为被暂停的线程，如果有线程0在执行了2个单位后被暂停，则将0压入stack中，继续执行1
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[n];
        int thread = -1;
        int start = -1;
        for (String log : logs) {
            String[] splitString = log.split(":");
            if (thread == -1 && start == -1) {
                thread = Integer.parseInt(splitString[0]);
                start = Integer.parseInt(splitString[2]);
                continue;
            }
            if (splitString[1].equals("start")) {
                stack.add(thread);
                nums[thread] += Integer.parseInt(splitString[2]) - start;
                thread = Integer.parseInt(splitString[0]);
                start = Integer.parseInt(splitString[2]);
            } else {
                nums[thread] += Integer.parseInt(splitString[2]) - start + 1;
                if (stack.isEmpty()) {
                    thread = -1;
                    start = -1;
                } else {
                    thread = stack.pop();
                    start = Integer.parseInt(splitString[2]) + 1;
                }
            }
        }
        return nums;
    }
}
