package leetCode;

public class LeetCode_434 {
    public static void main(String[] args) {
        String string = ", , , ,     a, eaefa";
        LeetCode_434 leetCode_434 = new LeetCode_434();
        int num = leetCode_434.countSegments(string);
        System.out.println(num);
    }

    /**
     * 通过区分有多少个空格，即可拆分
     *
     * @param s 字符串
     * @return 有多少个单词
     */
    public int countSegments(String s) {
        String[] split = s.split(" ");
        int count = 0;
        for (String temp : split) {
            if (!temp.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
