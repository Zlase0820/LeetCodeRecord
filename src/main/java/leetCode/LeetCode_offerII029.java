package leetCode;

import beans.ListNode;
import org.junit.Test;


/**
 * @author: zlase
 * @createDate: 2022/6/18
 * @description:
 */
public class LeetCode_offerII029 {


    public ListNode insert(ListNode head, int insertVal) {

        // 如果传入为null
        if (head == null) {
            ListNode listNode = new ListNode(insertVal);
            listNode.next = listNode;
            return listNode;
        }

        // 如果传入为1个head，则直接加入即可
        if (head.next == head) {
            ListNode listNode = new ListNode(insertVal);
            head.next = listNode;
            listNode.next = head;
            return head;
        }

        // 遍历一圈找到最小的头结点
        ListNode minNode = head;
        ListNode nodeTemp = head.next;
        while (nodeTemp != head) {
            if (nodeTemp.val < minNode.val) {
                minNode = nodeTemp;
            }
            nodeTemp = nodeTemp.next;
        }


        // 防止出现 1 1 1 插入2导致死循环的情况，遍历一圈就停下
        ListNode node1 = minNode;
        ListNode node2 = minNode.next;
        while ((insertVal < node1.val || insertVal > node2.val) && node2 != minNode) {
            node2 = node2.next;
            node1 = node1.next;
        }
        ListNode listNode = new ListNode(insertVal);
        node1.next = listNode;
        listNode.next = node2;
        return head;
    }

    @Test
    public void test1() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        int insertNum = 0;

        LeetCode_offerII029 leetCode = new LeetCode_offerII029();
        leetCode.insert(node1, insertNum);
    }


}
