package leetCode;

public class LeetCode_583 {
    public static void main(String[] args) {
        LeetCode_583 leetCode_583 = new LeetCode_583();
        String string1 = "sea";
        String string2 = "eat";
        int num = leetCode_583.minDistance(string1, string2);
        System.out.println(num);
    }


    /**
     * 相当于找到两个字符串的最大相交的部分，多余的部分就是删除的步数
     *
     * @param word1 第一个单词
     * @param word2 第二个单词
     * @return 需要删除的单词数量
     */
    public int minDistance(String word1, String word2) {
        int maxIntersection = 0;
        int left = 0;
        int right = 0;
        while (left < word1.length()) {


        }
        return word1.length() - maxIntersection + word2.length() - maxIntersection;
    }


}
