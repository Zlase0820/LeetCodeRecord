package beans;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int num) {
        this.val = num;
    }

    public ListNode(int num, ListNode listNode) {
        this.val = num;
        this.next = listNode;
    }

    public ListNode() {
    }
}
