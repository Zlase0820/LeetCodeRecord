package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_13 {

    // 罗马数字问题
    // 明显的从右向左读取，如果比左侧的数字小则为正，比右侧的数字小则为负
    public static void main(String[] args){
        String romanNum = "MCMXCIV";
        LeetCode_13 leetCode = new LeetCode_13();
        int romanInt = leetCode.romanToInt(romanNum);
        System.out.println(romanInt);
    }

    public int romanToInt(String s) {
        Map<String,Integer> checkMap = new HashMap<String,Integer>();
        checkMap.put("I",1);
        checkMap.put("V",5);
        checkMap.put("X",10);
        checkMap.put("L",50);
        checkMap.put("C",100);
        checkMap.put("D",500);
        checkMap.put("M",1000);

        int maxNum = 1;
        int returnInt = 0;
        for(int i = s.length()-1;i>=0;i--){
            String tempNum = String.valueOf(s.charAt(i));
            int addNum = checkMap.get(tempNum);
            if(addNum >= maxNum){
                returnInt += addNum;
                maxNum=addNum;
            }else{
                returnInt -= addNum;
            }
        }
        return returnInt;
    }

}
