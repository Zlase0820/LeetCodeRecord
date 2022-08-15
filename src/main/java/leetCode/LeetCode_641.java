package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zlase
 * @createDate: 2022/8/15
 * @description:
 */
public class LeetCode_641 {
    List<Integer> list;
    int maxLength;

    // 初始化时设定一个List数组即可
    public LeetCode_641(int k) {
        this.list = new ArrayList<>();
        this.maxLength = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        list.add(0, value);
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        list.add(list.size(), value);
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        list.remove(0);
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        list.remove(list.size() - 1);
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return list.get(0);
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        return list.size() >= maxLength;
    }
}
