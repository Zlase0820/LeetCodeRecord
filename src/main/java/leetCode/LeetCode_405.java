package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_405 {
    public static void main(String[] args) {
        int num = -1;
        LeetCode_405 leetCode_405 = new LeetCode_405();
        String result = leetCode_405.toHex(num);
        System.out.println(result);
    }

    /**
     * 二进制转成16进制，不需要考虑负数
     * 每次除以16取余数即可，除法可以通过位运算提高效率 -> 失败，负数不属于这个规则，还是得按照二进制转十六进制计算
     * 知识点：>>左移是有符号移动，负数会补-1，正数会补0；>>>是无符号移动，无论正负左侧都补0
     *
     * @param num 原数字
     * @return 转换成16进制的结果
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        Map<Integer, String> changeMap = createHexChangeMap();
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.insert(0, changeMap.get(num & 0xf));
            num = num >>> 4;
        }
        return sb.toString();
    }

    // 创建十六进制 对应表
    private Map<Integer, String> createHexChangeMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(7, "7");
        map.put(8, "8");
        map.put(9, "9");
        map.put(10, "a");
        map.put(11, "b");
        map.put(12, "c");
        map.put(13, "d");
        map.put(14, "e");
        map.put(15, "f");
        return map;
    }


}
