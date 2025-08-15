package leetCode;

public class LeetCode_520 {

    public static void main(String[] args) {
        LeetCode_520 leetCode_520 = new LeetCode_520();
        String string = "mL";
        boolean result = leetCode_520.detectCapitalUse(string);
        System.out.println(result);
    }

    /**
     * 从第二个字母开始看，如果第二个字母是大写，那么剩下所有都应该是大写，如果是小写则余下的都应该是小写   mL 这种不通过
     * 统计所有大写字母的数量
     * 如果数量为1且只有开头为大写，true
     * 如果全部为大写，true
     *
     * @param word 字符串
     * @return 返还值
     */
    public boolean detectCapitalUse(String word) {
        int num = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                num++;
            }
        }
        // 只有一个大写且是开头的，可以; 全部小写，可以; 全部是大写，可以
        return (num == 1 && Character.isUpperCase(word.charAt(0))) || num == 0 || num == word.length();
    }
}
