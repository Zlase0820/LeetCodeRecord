package leetCode;

public class LeetCode_335 {
    public static void main(String[] args) {


    }

    /**
     * 这是一个推理的题目
     * 如果相交，必须要保证：
     * 向上走的>=向下走的
     * 向右走的>=向左走的
     * 只有这种情况才能保证在y轴上相交
     *
     * @param distance
     * @return
     */
    public boolean isSelfCrossing(int[] distance) {
        if (distance[0] >= distance[2] && distance[1] <= distance[3]) {
            return true;
        }
        return false;
    }
}
