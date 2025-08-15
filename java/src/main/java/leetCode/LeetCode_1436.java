package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_1436 {

    public static void main(String[] args) {
        LeetCode_1436 leetCode_1436 = new LeetCode_1436();
        List<List<String>> list = leetCode_1436.createList3();
        String end = leetCode_1436.destCity(list);
        System.out.println(end);
    }

    // path = [[]]
    private List<List<String>> createList3() {
        return new ArrayList<>();
    }

    // path = [["A","Z"]]
    private List<List<String>> createList2() {
        List<List<String>> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("Z");
        list.add(list1);
        return list;
    }


    // paths = [["B","C"],["D","B"],["C","A"]]
    private List<List<String>> createList1() {
        List<List<String>> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("B");
        list1.add("C");
        List<String> list2 = new ArrayList<>();
        list2.add("D");
        list2.add("B");
        List<String> list3 = new ArrayList<>();
        list3.add("C");
        list3.add("A");
        list.add(list1);
        list.add(list2);
        list.add(list3);
        return list;
    }

    /**
     * 两次遍历
     * 第一次：用一个Set做记录，如果Set里没有，则添加，如果有则删除。
     * 第二次：遍历path，只遍历每个节点的后一个坐标，如果set中包含，则为终点
     *
     * @param paths 路径
     * @return 终点
     */
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        // 第一步
        for (List<String> list : paths) {
            for (String string : list) {
                if (set.contains(string)) {
                    set.remove(string);
                } else {
                    set.add(string);
                }
            }
        }
        // 第二步
        for (List<String> list : paths) {
            if (set.contains(list.get(1))) {
                return list.get(1);
            }
        }
        return "";
    }
}
