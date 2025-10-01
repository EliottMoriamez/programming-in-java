import java.util.NoSuchElementException;
package agh.ii.prinjava.lab02.exc02_01_modified.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01_modified.exc02_01.StackOfInts;
/**
 * LinkedListBasedImpl - a simple linked-list based implementation of StackOfInts.
 *
 * This implementation uses a private static nested Node class as the building block.
 * push and pop operate at the head of the linked list for O(1) performance.
 */
public class LinkedListBasedImpl implements StackOfInts {
    /**
     * Head of the singly linked list (top of the stack).
     */
    private Node head;

    /**
     * Node - a simple node for singly linked list.
     */
    private static class Node {
        int value;
        Node next;
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Constructs an empty LinkedListBasedImpl.
     */
    public LinkedListBasedImpl() {
        this.head = null;
    }

    /**
     * Pushes an integer onto the stack.
     *
     * @param value the value to push
     */
    @Override
    public void push(int value) {
        head = new Node(value, head);
    }

    /**
     * Pops and returns the top integer from the stack.
     *
     * @return the integer value popped from the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public int pop() {
        if (head == null) {
            throw new NoSuchElementException("Stack is empty");
        }
        int val = head.value;
        head = head.next;
        return val;
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
