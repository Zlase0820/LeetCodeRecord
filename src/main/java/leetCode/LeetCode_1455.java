package leetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: zlase
 * @createDate: 2022/8/21
 * @description:
 */
public class LeetCode_1455 {
    // 这个太简单了，竟然还是单个空格
    public int isPrefixOfWord(String sentence, String searchWord) {
        int num = -2;
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            if (string.startsWith(searchWord)) {
                num = i;
                break;
            }
        }
        return num + 1;
    }

    @Test
    public void test1() {
        LeetCode_1455 leetCode_1455 = new LeetCode_1455();
        String sentence = "i love eating burger";
        String searchWord = "burg";
        int answer = 4;
        Assert.assertEquals("err", answer, leetCode_1455.isPrefixOfWord(sentence, searchWord));
    }

    @Test
    public void test2() {
        LeetCode_1455 leetCode_1455 = new LeetCode_1455();
        String sentence = "this problem is an easy problem";
        String searchWord = "pro";
        int answer = 2;
        Assert.assertEquals("err", answer, leetCode_1455.isPrefixOfWord(sentence, searchWord));
    }

    @Test
    public void test3() {
        LeetCode_1455 leetCode_1455 = new LeetCode_1455();
        String sentence = "i am tired";
        String searchWord = "you";
        int answer = -1;
        Assert.assertEquals("err", answer, leetCode_1455.isPrefixOfWord(sentence, searchWord));
    }
}
