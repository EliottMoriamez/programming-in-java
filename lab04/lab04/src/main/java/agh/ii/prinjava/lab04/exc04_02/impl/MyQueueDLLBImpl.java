package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;
import java.util.NoSuchElementException;

/**
 * Implementation of MyQueue based on a double chained list
 * @param <E> type of elements
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private final DLinkList<E> elems = new DLinkList<>();

    @Override
    public void enqueue(E x) {
        if (x == null) throw new IllegalArgumentException("Element cannot be Null");
        elems.addLast(x);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return elems.removeFirst();
    }

    @Override
    public int numOfElems() {
        return elems.size();
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return elems.peekFirst();
    }
}
