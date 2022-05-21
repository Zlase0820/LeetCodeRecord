package leetCode;

import java.util.*;

public class LeetCode_1055 {

    // 这个题没搞定，先放下吧，回头再看看
    // 得到可能的最小的字符串组合的数量，如果无法组合，就返回-1
    public static void main(String[] args) {
        LeetCode_1055 leetCode = new LeetCode_1055();
        String source = "aabc";
        String target = "abcaabcb";
        int num = leetCode.shortestWay(source, target);
        System.out.print(num);
    }

    // 先把Source的值出现的位置，对应的存在一个List里边
    public int shortestWay(String source, String target) {
        Map<Character, List<Integer>> sourceLocationMap = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (sourceLocationMap.containsKey(c)) {
                sourceLocationMap.get(c).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                sourceLocationMap.put(c, list);
            }
        }

        int num = 0;
        List<Integer> beforeList = new ArrayList<>();
        for (int j = 0; j < target.length(); j++) {
            char c = target.charAt(j);
            List<Integer> list = sourceLocationMap.get(c);
            if (list == null) {
                return -1;
            }


        }


        return 1;


    }

}
