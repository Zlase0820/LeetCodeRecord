package leetCode;

import java.util.Iterator;

public class LeetCode_284 implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer next;

    // 传递一个迭代器
    public LeetCode_284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (this.iterator.hasNext()) {
            next = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ret = next;
        if (iterator.hasNext()) {
            next = iterator.next();
        } else {
            next = null;
        }
        return ret;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
