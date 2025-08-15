package leetCode;

import java.util.Stack;

public class LeetCode_84 {

    public static void main(String[] args) {
        LeetCode_84 leetCode = new LeetCode_84();
        int[] highs = {0, 1, 0, 1};
        int maxVolumn = leetCode.largestRectangleArea(highs);
        System.out.println(maxVolumn);
    }

    /**
     * 非常经典的题目
     * 1.如何找到最大的面积？
     * 从头到尾遍历，以每一个值的高度为该范围的最大高度，左右两侧找高度小于等于它的柱子，找到以它为最高的最大面积
     * 2.找左右两侧最大范围，很容易时间复杂度变成n^2，所以需要用最短的时间找到
     * 使用单调栈的方法，找到每一个节点，最左侧和左右侧的最小值，然后计算该节点的最大体积
     * 参考文档：https://mp.csdn.net/console/editor/html/108433134
     *
     * @param heights 柱状体的高度
     * @return 最大的存水体积
     */
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;

        // 获得当前每个节点，其左侧的最近的比其小的位置
        // 使用正向的 单调递增栈
        int[] leftMin = getLeftMinLocartion(heights);

        // 获得当前每个节点，其右侧的最近的比其小的位置
        // 使用反向的 单调递减栈
        int[] rightMin = getRightMinLocartion(heights);

        // 计算体积的时候，要算，左侧延伸的长度 + 1（自身长度） + 右侧延伸的长度
        // 如果是-1，则可以延伸到最左或者最右
        // 如果不是-1，则只能延伸一部分
        int maxVolumn = 0;
        for (int i = 0; i < length; i++) {
            int leftSize = 0;
            int rightSize = 0;
            if (leftMin[i] == -1) {
                leftSize = i;  // 其实是i-0的简化
            } else {
                leftSize = i - leftMin[i] - 1;
            }

            if (rightMin[i] == -1) {
                rightSize = length - 1 - i;
            } else {
                rightSize = rightMin[i] - i - 1;
            }
            int size = leftSize + 1 + rightSize;
            int volumn = heights[i] * size;
            if (volumn > maxVolumn) {
                maxVolumn = volumn;
            }
        }
        return maxVolumn;
    }

    // 找到每一个节点右侧比其更小位置，反向，单调减栈
    private int[] getRightMinLocartion(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] rightMin = new int[heights.length];
        int location = heights.length - 1; //反向，从右往左走
        while (location >= 0) {
            if (stack.isEmpty()) {
                stack.push(location);
                rightMin[location] = -1;
                location--;
                continue;
            }
            if (heights[location] < heights[stack.peek()]) {
                stack.pop();
            } else if ((heights[location] == heights[stack.peek()])) {
                rightMin[location] = rightMin[stack.peek()];
                stack.push(location);
                location--;
            } else {
                rightMin[location] = stack.peek();
                stack.push(location);
                location--;
            }
        }
        return rightMin;
    }

    // 找到每个点左侧的比其更小的位置，正向，单调递减栈(栈顶到栈底递减，栈顶更大)
    private int[] getLeftMinLocartion(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] leftMin = new int[heights.length];
        int location = 0;
        while (location < heights.length) {
            if (stack.isEmpty()) {
                // 如果栈是空的，说明，该节点左侧没有比其更小的节点，因此
                leftMin[location] = -1;
                stack.push(location);
                location++;
                continue;
            }
            if (heights[stack.peek()] > heights[location]) {
                stack.pop();
            } else if (heights[stack.peek()] == heights[location]) {
                leftMin[location] = leftMin[stack.peek()];
                stack.push(location);
                location++;
            } else {
                leftMin[location] = stack.peek();
                stack.push(location);
                location++;
            }
        }
        return leftMin;
    }

}

