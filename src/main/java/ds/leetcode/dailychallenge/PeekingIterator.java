package ds.leetcode.dailychallenge;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private Integer head;
    private Iterator<Integer> tail;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here
        if (iterator != null && iterator.hasNext()) {
            head = iterator.next();
            tail = iterator;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return head;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int res = head;
        if (tail.hasNext())
            head = tail.next();
        else
            head = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }
}