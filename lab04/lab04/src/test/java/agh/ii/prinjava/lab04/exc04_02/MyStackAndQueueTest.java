package agh.ii.prinjava.lab04.exc04_02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyStackAndQueueTest {

    @Test
    void stack_push_pop_peek() {
        MyStack<Integer> stack = MyStack.create();
        assertTrue(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.numOfElems());
        assertEquals(2, stack.peek());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void stack_exceptions() {
        MyStack<Integer> stack = MyStack.create();
        assertThrows(java.util.NoSuchElementException.class, stack::pop);
        assertThrows(java.util.NoSuchElementException.class, stack::peek);
        assertThrows(IllegalArgumentException.class, () -> stack.push(null));
    }

    @Test
    void queue_enqueue_dequeue_peek() {
        MyQueue<String> queue = MyQueue.create();
        assertTrue(queue.isEmpty());
        queue.enqueue("a");
        queue.enqueue("b");
        assertEquals(2, queue.numOfElems());
        assertEquals("a", queue.peek());
        assertEquals("a", queue.dequeue());
        assertEquals("b", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void queue_exceptions() {
        MyQueue<String> queue = MyQueue.create();
        assertThrows(java.util.NoSuchElementException.class, queue::dequeue);
        assertThrows(java.util.NoSuchElementException.class, queue::peek);
        assertThrows(IllegalArgumentException.class, () -> queue.enqueue(null));
    }
}
