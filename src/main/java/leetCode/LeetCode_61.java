package leetCode;

import beans.ListNode;

/**
 * @author: zlase
 * @createDate: 2022/8/8
 * @description:
 */
public class LeetCode_61 {
    // 本质方案是优先找到下一个头结点，循环算数即可
    public ListNode rotateRight(ListNode head, int k) {
        // 处理边界
        if (head == null) {
            return null;
        }
        int length = 1;
        ListNode end = head;  // end就成为了末尾节点
        while (end.next != null) {
            end = end.next;
            length++;
        }
        if (length == 1) {
            return head;
        }

        k = length - k % length; // 除去外侧循环的圈数
        if (k == length) { // 如果是头就单独返还
            return head;
        }

        // 调换头尾
        ListNode last = head;
        ListNode root = head.next;
        for (int i = 1; i < k; i++) {
            root = root.next;
            last = last.next;
        }
        last.next = null;
        end.next = head;
        return root;
    }
}
