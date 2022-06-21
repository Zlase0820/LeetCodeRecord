package leetCode;

/**
 * @author: zlase
 * @createDate: 2022/6/21
 * @description:
 */
public class LeetCode_1108 {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.","[.]");
    }
}
