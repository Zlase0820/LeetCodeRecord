package leetCode;

/**
 * @author: zlase
 * @createDate: 2022/8/2
 * @description:
 */
public class LeetCode_622 {
    private int maxLength;
    private Unit root;

    public static class Unit {
        int num;
        Unit next;

        public Unit(int num) {
            this.num = num;
        }
    }

    public LeetCode_622(int k) {
        this.maxLength = k;
        this.root = null;
    }

    public boolean enQueue(int value) {
        // 判断是否已经满了
        if (isFull()) {
            return false;
        }
        // 如果是空的，则放置在队头
        if (isEmpty()) {
            root = new Unit(value);
            return true;
        }
        // 正常增加到队列尾部
        Unit temp = root;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Unit(value);
        return true;
    }

    public boolean deQueue() {
        // 如果是空的，返回删除失败
        if (isEmpty()) {
            return false;
        }
        root = root.next;
        return true;
    }

    public int Front() {
        return root != null ? root.num : -1;
    }

    public int Rear() {
        Unit temp = root;
        if (temp == null) {
            return -1;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.num;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isFull() {
        int length = 0;
        Unit temp = root;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length >= maxLength;
    }
}
