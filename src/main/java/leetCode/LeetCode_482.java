package leetCode;

public class LeetCode_482 {

    public static void main(String[] args) {
        String string = "5F3Z-2e-9-w";
        int k = 1;
        LeetCode_482 leetCode_482 = new LeetCode_482();
        String result = leetCode_482.licenseKeyFormatting(string, k);
        System.out.println(result);
    }

    /**
     * s需要先去除 "-" 然后将所有的小写全部转换为大写
     * 转换完成后，从后往前数，每次数过k个数字，加一个"-"  直到数到头
     *
     * @param s 字符串
     * @param k 每个间隔有多少个字符
     * @return 分隔好的字符
     */
    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder();
        int add = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (add < k) {
                sb.insert(0, s.charAt(i));
                add++;
            } else {
                sb.insert(0, "-");
                i++;
                add = 0;
            }
        }
        return sb.toString();
    }
}
