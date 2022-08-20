package leetCode;

/**
 * @author: zlase
 * @createDate: 2022/8/20
 * @description:
 */
public class LeetCode_1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int stu = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                stu++;
            }
        }
        return stu;
    }
}
