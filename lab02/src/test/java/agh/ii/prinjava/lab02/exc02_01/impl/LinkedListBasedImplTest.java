package agh.ii.prinjava.lab02.exc02_01.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListBasedImplTest {

    @Test
    void testPushAndNumOfElems() {
        LinkedListBasedImpl stack = new LinkedListBasedImpl();
        assertEquals(0, stack.numOfElems());
        stack.push(10);
        assertEquals(1, stack.numOfElems());
        stack.push(20);
        assertEquals(2, stack.numOfElems());
    }

    @Test
    void testPopNormalCase() {
        LinkedListBasedImpl stack = new LinkedListBasedImpl();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(0, stack.numOfElems());
    }

    @Test
    void testPopEmptyStackThrows() {
        LinkedListBasedImpl stack = new LinkedListBasedImpl();
        assertThrows(IndexOutOfBoundsException.class, stack::pop);
    }

    @Test
    void testPeekNormalCase() {
        LinkedListBasedImpl stack = new LinkedListBasedImpl();
        stack.push(5);
        stack.push(7);
        assertEquals(7, stack.peek());
        stack.pop();
        assertEquals(5, stack.peek());
    }

    @Test
    void testPeekEmptyStackThrows() {
        LinkedListBasedImpl stack = new LinkedListBasedImpl();
        assertThrows(IndexOutOfBoundsException.class, stack::peek);
    }

    @Test
    void testPopSingleElement() {
        LinkedListBasedImpl stack = new LinkedListBasedImpl();
        stack.push(42);
        assertEquals(42, stack.pop());
        assertEquals(0, stack.numOfElems());
    }
}

