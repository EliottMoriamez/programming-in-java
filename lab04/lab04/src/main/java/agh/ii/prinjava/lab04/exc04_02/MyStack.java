package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyStackDLLBImpl;

/**
 * Interface for a stack
 *
 * @param <E> type of elements in stack
 */
public interface MyStack<E> {
    /**
     * Returns and removes element on top of stack
     *
     * @return removed element
     * @throws java.util.NoSuchElementException if stack is empty
     */
    E pop();

    /**
     * adds an element on top of stack
     *
     * @param x element to add
     * @throws IllegalArgumentException if element is null
     */
    void push(E x);

    /**
     * Checks if stack is empty
     *
     * @return true if empty, else false
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns number of elements in stack
     *
     * @return number of elements
     */
    int numOfElems();

    /**
     * Returns element on top of stack without removing it
     *
     * @return element on top
     * @throws java.util.NoSuchElementException if stack is empty
     */
    E peek();

    /**
     * Method to build a stack based on a double linked list
     */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}
