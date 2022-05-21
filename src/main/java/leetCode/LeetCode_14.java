package leetCode;

public class LeetCode_14 {

    // 公共最长前缀
    // 多少个String，则使用多少个指针，如果相同就继续往后走，循环的次数为最短的String长度
    // 这种横向的比对时间复杂度为 n*m 还勉强可以
    public static void main(String[] args){
        String[] strs =  {};
        LeetCode_14 leetCode = new LeetCode_14();
        String result = leetCode.longestCommonPrefix(strs);
        System.out.println(result);
    }


    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==0){
            return "";
        }

        // 如果只有一个，则直接返还
        if(strs.length==1) {
            return strs[0];
        }

        // 如果有多个串
        int lengthOfStrs = strs.length;
        int minLength = 0x7fffffff;
        String returnString = "";
        for(int i=0;i<lengthOfStrs;i++){
            if(strs[i].length() < minLength)
                minLength = strs[i].length();
        }

        // 以第一个串为基础，向后遍历
        int subNum = 0;
        char startWithChar;
        for(int num = 0 ; num<minLength; num++){
            startWithChar = strs[0].charAt(num);
            for(int i=1;i<strs.length;i++){
                if(strs[i].charAt(num) != startWithChar) {
                    return strs[0].substring(0,subNum);
                }
            }
            subNum++;
        }

        return strs[0].substring(0,minLength);
    }

}
