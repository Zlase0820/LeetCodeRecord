package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zlase
 * @createDate: 2022/6/23
 * @description:
 */
public class LeetCode_30 {
    // 用map做计数就好，确实不值得hard难度
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int length = words[0].length() * words.length;
        for (int i = 0; i + length <= s.length(); i++) {
            if (getStartLocation(s.substring(i, i + length), new HashMap<>(map), words[0].length())) {
                resultList.add(i);
            }
        }
        return resultList;
    }


    private boolean getStartLocation(String string, Map<String, Integer> map, int wordLength) {
        for (int i = 0; i < string.length(); i += wordLength) {
            String key = string.substring(i, i + wordLength);
            if (map.containsKey(key)) {
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
