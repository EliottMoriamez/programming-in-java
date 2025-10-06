package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayBasedImplTest {

    // Create an empty stack
    private final StackOfInts stackOfInts = StackOfIntsFtry.create(StackOfIntsFtry.Impln.ARRAY_B);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stackOfInts.isEmpty());
    }

    @Test
    void pushShouldIncreaseSize() {
        assertEquals(0, stackOfInts.numOfElems());
        stackOfInts.push(10);
        assertEquals(1, stackOfInts.numOfElems());
        stackOfInts.push(20);
        assertEquals(2, stackOfInts.numOfElems());
    }

    @Test
    void popShouldRemoveElementsInLifoOrder() {
        stackOfInts.push(1);
        stackOfInts.push(2);
        stackOfInts.push(3);

        assertEquals(3, stackOfInts.pop());
        assertEquals(2, stackOfInts.pop());
        assertEquals(1, stackOfInts.pop());
        assertEquals(0, stackOfInts.numOfElems());
    }

    @Test
    void peekShouldReturnLastPushedElementWithoutRemovingIt() {
        stackOfInts.push(5);
        stackOfInts.push(10);
        assertEquals(10, stackOfInts.peek());
        assertEquals(2, stackOfInts.numOfElems());
    }

    @Test
    void peekAfterPopShouldReflectNewTop() {
        stackOfInts.push(1);
        stackOfInts.push(2);
        stackOfInts.push(3);
        stackOfInts.pop(); // remove 3
        assertEquals(2, stackOfInts.peek());
    }

    @Test
    void pushPopAndPeekSequenceShouldBehaveCorrectly() {
        stackOfInts.push(7);
        stackOfInts.push(8);
        assertEquals(8, stackOfInts.peek());

        stackOfInts.push(9);
        assertEquals(9, stackOfInts.pop());
        assertEquals(8, stackOfInts.peek());

        stackOfInts.pop();
        stackOfInts.pop();
        assertEquals(0, stackOfInts.numOfElems());
    }

    @Test
    void numOfElemsShouldReflectStackSizeCorrectly() {
        assertEquals(0, stackOfInts.numOfElems());
        stackOfInts.push(1);
        stackOfInts.push(2);
        stackOfInts.push(3);
        assertEquals(3, stackOfInts.numOfElems());

        stackOfInts.pop();
        assertEquals(2, stackOfInts.numOfElems());
    }

    @Test
    void pushingAndPoppingManyElementsShouldWorkCorrectly() {
        for (int i = 0; i < 100; i++) {
            stackOfInts.push(i);
        }
        assertEquals(100, stackOfInts.numOfElems());
        for (int i = 99; i >= 0; i--) {
            assertEquals(i, stackOfInts.pop());
        }
        assertEquals(0, stackOfInts.numOfElems());
    }

    @Test
    void popOnEmptyStackShouldThrowException() {
        assertThrows(IndexOutOfBoundsException.class, stackOfInts::pop);
    }

    @Test
    void peekOnEmptyStackShouldThrowException() {
        assertThrows(IndexOutOfBoundsException.class, stackOfInts::peek);
    }
}