package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class LeetCode_500 {
    public static void main(String[] args) {
        String[] strings = {"adsdf","sfd"};
        LeetCode_500 leetCode_500 = new LeetCode_500();
        String[] results = leetCode_500.findWords(strings);
        System.out.println(results);
    }

    /**
     * 使用三个set即可
     *
     * @param words 数组
     * @return 是否包含
     */
    public String[] findWords(String[] words) {
        Set<Character> set1 = words("qwertyuiop");
        Set<Character> set2 = words("asdfghjkl");
        Set<Character> set3 = words("zxcvbnm");

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String temp = word.toLowerCase(Locale.ROOT);
            if (set1.contains(temp.charAt(0))) {
                if (isContainAll(set1, temp)) {
                    result.add(word);
                }
                continue;
            }
            if (set2.contains(temp.charAt(0))) {
                if (isContainAll(set2, temp)) {
                    result.add(word);
                }
                continue;
            }
            if (set3.contains(temp.charAt(0))) {
                if (isContainAll(set3, temp)) {
                    result.add(word);
                }
            }
        }

        String[] strings = result.toArray(new String[0]);
        for (int i = 0; i < strings.length; i++) {
            strings[i] = result.get(i);
        }

        return strings;
    }

    // 判断字符串是否包含在
    private boolean isContainAll(Set<Character> sets, String string) {
        for (int i = 0; i < string.length(); i++) {
            if (!sets.contains(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private Set<Character> words(String string) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            set.add(string.charAt(i));
        }
        return set;
    }
}
