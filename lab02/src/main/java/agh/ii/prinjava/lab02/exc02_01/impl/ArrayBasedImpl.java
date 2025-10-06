package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

public class ArrayBasedImpl implements StackOfInts {

    public static final int PAGE_SIZE = 10;

    private int[] array = new int[PAGE_SIZE];
    private int numOfPages = 1;

    /**
     * @return the last inserted element
     * @throws IndexOutOfBoundsException when the stack is empty
     */
    @Override
    public int pop() {
        if (numOfElems < 1) {
            throw  new IndexOutOfBoundsException("Stack is empty");
        }
        if (numOfElems < (numOfPages - 2) * PAGE_SIZE) {
            numOfPages -= 1;
            int[] newArray = new int[numOfPages * PAGE_SIZE];
            System.arraycopy(array, 0, newArray, 0, numOfElems);
            array = newArray;
        }
        numOfElems -= 1;
        return array[numOfElems];
    }

    /**
     * Add an element to the top of the stack
     * @param x the element to be added
     */
    @Override
    public void push(int x) {
        if (numOfElems + 1 > numOfPages * PAGE_SIZE) {
            numOfPages += 1;
            int[] newArray = new int[numOfPages * PAGE_SIZE];
            System.arraycopy(array, 0, newArray, 0, numOfElems);
            array = newArray;
        }
        array[numOfElems] = x;
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
            throw  new IndexOutOfBoundsException("Stack is empty");
        }
        return array[numOfElems - 1];
    }

    private int numOfElems = 0;
}