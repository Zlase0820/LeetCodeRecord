package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_interview1711 {

    public int findClosest(String[] words, String word1, String word2) {
        List<Integer> word1List = new ArrayList<>();
        List<Integer> word2List = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                word1List.add(i);
                continue;
            }
            if (words[i].equals(word2)) {
                word2List.add(i);
            }
        }

        for (Integer value : word1List) {
            for (Integer integer : word2List) {
                minLength = Math.min(Math.abs(value - integer), minLength);
            }
        }

        return minLength;
    }

    @Test
    public void test1() {
        String[] words = {"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        String word1 = "a";
        String word2 = "student";
        LeetCode_interview1711 leetCode = new LeetCode_interview1711();
        Assert.assertEquals("message", leetCode.findClosest(words, word1, word2), 1);
    }
}
