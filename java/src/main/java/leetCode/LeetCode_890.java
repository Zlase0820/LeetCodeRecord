package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author: zlase
 * @createDate: 2022/6/12
 * @description:
 */
public class LeetCode_890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (isPattern(word, pattern)) {
                list.add(word);
            }
        }
        return new ArrayList<>(list);
    }

    private boolean isPattern(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (map.containsKey(word.charAt(i))) {
                if (!map.get(word.charAt(i)).equals(pattern.charAt(i))) {
                    return false;
                }
            } else if (map.containsValue(pattern.charAt(i))) {
                return false;
            } else {
                map.put(word.charAt(i), pattern.charAt(i));
            }
        }
        return true;
    }


    @Test
    public void test1() {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String[] results = {"mee", "aqq"};
        List<String> resultsList = Arrays.asList(results);
        resultsList.sort(Comparator.reverseOrder());
        String pattern = "abb";
        LeetCode_890 leetCode_890 = new LeetCode_890();
        List<String> returnResult = leetCode_890.findAndReplacePattern(words, pattern);
        returnResult.sort(Comparator.reverseOrder());
        Assert.assertEquals("error", returnResult, resultsList);
    }
}
