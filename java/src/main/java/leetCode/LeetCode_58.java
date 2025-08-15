package leetCode;

public class LeetCode_58 {
    public static void main(String[] args) {
        LeetCode_58 leetCode_58 = new LeetCode_58();
        String string = "hello world! ";
        int result = leetCode_58.lengthOfLastWord(string);
        System.out.println(result);
    }

    public int lengthOfLastWord(String s) {
        String[] strings = s.trim().split(" ");
        return strings[strings.length - 1].length();
    }
}
