package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;
import java.util.NoSuchElementException;

/**
 * Implementation of MyStack based on a double chained list
 * @param <E> type of elements
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
    private final DLinkList<E> elems = new DLinkList<>();

    @Override
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("pile is empty");
        return elems.removeFirst();
    }

    @Override
    public void push(E x) {
        if (x == null) throw new IllegalArgumentException("Element cannot be Null");
        elems.addFirst(x);
    }

    @Override
    public int numOfElems() {
        return elems.size();
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("pile is empty");
        return elems.peekFirst();
    }
}
