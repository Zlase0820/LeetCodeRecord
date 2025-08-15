package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zlase
 * @createDate: 2022/8/16
 * @description:
 */
public class LeetCode_1656 {
    int ptr = 0;
    String[] strings;

    public LeetCode_1656(int n) {
        this.strings = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        strings[idKey - 1] = value;
        List<String> list = new ArrayList<>();
        if (idKey - 1 == ptr) {
            while (ptr < strings.length && strings[ptr] != null) {
                list.add(strings[ptr]);
                ptr++;
            }
        }
        return list;
    }
}
