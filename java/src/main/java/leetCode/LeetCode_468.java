package leetCode;


import org.junit.Assert;
import org.junit.Test;

public class LeetCode_468 {


    public String validIPAddress(String queryIP) {
        if (queryIP.equals("")) {
            return "Neither";
        }
        if (isIpv4(queryIP)) {
            return "IPv4";
        }
        if (isIpv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    // 判断是否为IPv4
    private boolean isIpv4(String queryIP) {
        if (queryIP.charAt(queryIP.length() - 1) == '.') {
            return false;
        }
        String[] strings = queryIP.split("\\.");
        if (strings.length != 4) {
            return false;
        }
        for (String string : strings) {
            if (string.length() == 0 || string.length() > 3 || (string.charAt(0) == '0' && string.length() != 1)) {
                return false;
            }
            try {
                int num = Integer.parseInt(string);
                if (num > 255 || num < 0) {
                    return false;
                }
            } catch (Exception exception) {
                return false;
            }
        }
        return true;
    }

    private boolean isIpv6(String queryIP) {
        if (queryIP.charAt(queryIP.length() - 1) == ':') {
            return false;
        }
        String[] strings = queryIP.split(":");
        if (strings.length != 8) {
            return false;
        }
        for (String string : strings) {
            // 长度在1-4之间
            if (string.length() == 0 || string.length() > 4) {
                return false;
            }

            // 可以被转换成十六进制
            try {
                Integer.parseInt(string, 16);
            } catch (Exception exception) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test1() {
        LeetCode_468 leetCode_468 = new LeetCode_468();
        String queryIP = "172.16.254.1";
        Assert.assertEquals("error", leetCode_468.validIPAddress(queryIP), "IPv4");
    }

    @Test
    public void test2() {
        LeetCode_468 leetCode_468 = new LeetCode_468();
        String queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        Assert.assertEquals("error", leetCode_468.validIPAddress(queryIP), "IPv6");
    }

    @Test
    public void test3() {
        LeetCode_468 leetCode_468 = new LeetCode_468();
        String queryIP = "256.256.256.256";
        Assert.assertEquals("error", leetCode_468.validIPAddress(queryIP), "Neither");
    }

    @Test
    public void test4() {
        LeetCode_468 leetCode_468 = new LeetCode_468();
        String queryIP = "192.168.1.0";
        Assert.assertEquals("error", leetCode_468.validIPAddress(queryIP), "IPv4");
    }

    @Test
    public void test5() {
        LeetCode_468 leetCode_468 = new LeetCode_468();
        String queryIP = "192.168.1.1";
        Assert.assertEquals("error", leetCode_468.validIPAddress(queryIP), "IPv4");
    }

    @Test
    public void test6() {
        LeetCode_468 leetCode_468 = new LeetCode_468();
        String queryIP = "192.168.01.1";
        Assert.assertEquals("error", leetCode_468.validIPAddress(queryIP), "Neither");
    }

    @Test
    public void test7() {
        LeetCode_468 leetCode_468 = new LeetCode_468();
        String queryIP = "192.168.1.00";
        Assert.assertEquals("error", leetCode_468.validIPAddress(queryIP), "Neither");
    }

    @Test
    public void test8() {
        LeetCode_468 leetCode_468 = new LeetCode_468();
        String queryIP = "192.168@1.1";
        Assert.assertEquals("error", leetCode_468.validIPAddress(queryIP), "Neither");
    }

    @Test
    public void test9() {
        LeetCode_468 leetCode_468 = new LeetCode_468();
        String queryIP = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
        Assert.assertEquals("error", leetCode_468.validIPAddress(queryIP), "IPv6");
    }

    @Test
    public void test10() {
        LeetCode_468 leetCode_468 = new LeetCode_468();
        String queryIP = "2001:db8:85a3:0:0:8A2E:0370:7334";
        Assert.assertEquals("error", leetCode_468.validIPAddress(queryIP), "IPv6");
    }

    @Test
    public void test11() {
        LeetCode_468 leetCode_468 = new LeetCode_468();
        String queryIP = "2001:0db8:85a3::8A2E:037j:7334";
        Assert.assertEquals("error", leetCode_468.validIPAddress(queryIP), "Neither");
    }

    @Test
    public void test12() {
        LeetCode_468 leetCode_468 = new LeetCode_468();
        String queryIP = "02001:0db8:85a3:0000:0000:8a2e:0370:7334";
        Assert.assertEquals("error", leetCode_468.validIPAddress(queryIP), "Neither");
    }

    @Test
    public void test13() {
        LeetCode_468 leetCode_468 = new LeetCode_468();
        String queryIP = ":2001:0db8:85a3:0:0:8A2E:0370:7334";
        Assert.assertEquals("error", leetCode_468.validIPAddress(queryIP), "Neither");
    }

    @Test
    public void test14() {
        LeetCode_468 leetCode_468 = new LeetCode_468();
        String queryIP = "12..33.4";
        Assert.assertEquals("error", leetCode_468.validIPAddress(queryIP), "Neither");
    }
}
