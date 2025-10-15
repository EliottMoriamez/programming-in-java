package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyQueueDLLBImpl;

/**
 * Interface for queue
 *
 * @param <E> type of elements
 */
public interface MyQueue<E> {
    /**
     * Adds the elements at the end of queue
     *
     * @param x element to add
     * @throws IllegalArgumentException if element is null
     */
    void enqueue(E x);

    /**
     * Removes and returns the element on top of queue
     *
     * @return removed element
     * @throws java.util.NoSuchElementException if queue is empty
     */
    E dequeue();

    /**
     * check if queue is empty
     *
     * @return true if empty, else false
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns number of elements in the queue
     *
     * @return number of elements
     */
    int numOfElems();

    /**
     * Returns the element on top of the queue without removing it
     *
     * @return element on top
     * @throws java.util.NoSuchElementException of queue is empty
     */
    E peek();

    /**
     * Method to create a queue based on a double linked list
     */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
