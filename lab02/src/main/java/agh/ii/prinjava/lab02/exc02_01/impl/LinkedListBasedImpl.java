package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

public class LinkedListBasedImpl implements StackOfInts {

    /**
     * @return the last inserted element
     * @throws IndexOutOfBoundsException when the stack is empty
     */
    @Override
    public int pop() {
        if (numOfElems < 1) {
            throw  new IndexOutOfBoundsException("Stack is empty");
        } else if (numOfElems == 1) {
            int a = first.elem;
            first = null;
            numOfElems -= 1;
            return a;
        } else {
            Node current = first;
            for (int i = 0; i < numOfElems - 2; i++) {
                current = current.next;
            }

            int a = current.next.elem;
            current.next = null;
            numOfElems -= 1;
            return a;
        }
    }

    /**
     * Add an element to the top of the stack
     * @param b the element to be added
     */
    @Override
    public void push(int b) {
        if (first == null) {
            first = new Node(b, null);
        } else {
            Node last = getLast();
            last.next = new Node(b, null);
        }

        numOfElems += 1;
    }

    /**
     * Get the length of the stack
     * @return the length
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }

    /**
     * Get the value of the top of the stack, without popping it
     * @return the value of the item
     * @throws IndexOutOfBoundsException when accessing stack is empty
     */
    @Override
    public int peek() {
        if (numOfElems < 1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        Node last = getLast();
        return  last.elem;
    }

    private Node getLast() {
        Node current = first;
        for (int i = 0; i < numOfElems - 1; i++) {
            current = current.next;
        }
        return current;
    }

    private static class Node {
        int elem;
        Node next;

        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }

    private Node first = null;
    private int numOfElems = 0;
}