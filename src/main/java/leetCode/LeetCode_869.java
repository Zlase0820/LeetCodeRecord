package leetCode;


import java.util.*;

public class LeetCode_869 {
    public static void main(String[] args) {
        LeetCode_869 leetCode_869 = new LeetCode_869();
        boolean num = leetCode_869.reorderedPowerOf2(10);
        System.out.println(num);
    }

    /**
     * 需要将n转变成list，之后使用DFS组合成各种可能性，每种可能性做一次判断，如果有true，则直接返还
     *
     * @param n 数量值
     * @return 是否能构成2的幂
     */
    public boolean reorderedPowerOf2(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n = n / 10;
        }

        // 对每一次组合的可能性进行遍历
        return dfs(list, "");
    }

    // 用原始的值，进行剪枝
    private boolean dfs(List<Integer> origin, String string) {
        // 终止判断
        if (origin.isEmpty()) {
            if (string.startsWith("0")) {
                return false;
            }
            return is2power(Integer.parseInt(string));
        }

        String result = new String(string);
        List<Integer> originTemp = new ArrayList<>(origin);
        for (int i = 0; i < origin.size(); i++) {
            result = result + origin.get(i);
            originTemp.remove(i);
            if (dfs(originTemp, result)) {
                return true;
            } else {
                originTemp.add(i, origin.get(i));
                result = result.substring(0, result.length() - 1);
            }
        }
        return false;
    }

    // 判断是一个数字是不是2的倍数
    private boolean is2power(int num) {
        while (num != 1) {
            if ((num & 1) == 1) {
                return false;
            }
            num = num >> 1;
        }
        return true;
    }
}
