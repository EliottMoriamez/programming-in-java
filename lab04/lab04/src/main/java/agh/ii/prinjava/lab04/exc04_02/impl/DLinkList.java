package agh.ii.prinjava.lab04.exc04_02.impl;

/**
 * Liste doublement chaînée générique pour l'implémentation de pile et file.
 * Double linked list to implement Stack and Queue
 * @param <E> Type of elements
 */
public class DLinkList<E> {
    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;
        Node(T elem) { this.elem = elem; }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    /** Adds an element on top */
    void addFirst(E elem) {
        Node<E> n = new Node<>(elem);
        n.next = head;
        if (head != null) head.prev = n;
        head = n;
        if (tail == null) tail = n;
        size++;
    }

    /** Adds an element at the end */
    void addLast(E elem) {
        Node<E> n = new Node<>(elem);
        n.prev = tail;
        if (tail != null) tail.next = n;
        tail = n;
        if (head == null) head = n;
        size++;
    }

    /** Removes and returns the top element */
    E removeFirst() {
        if (head == null) throw new java.util.NoSuchElementException();
        E elem = head.elem;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return elem;
    }

    /** Returns the top element without removing it */
    E peekFirst() {
        if (head == null) throw new java.util.NoSuchElementException();
        return head.elem;
    }

    /** Removes and returns the last element */
    E removeLast() {
        if (tail == null) throw new java.util.NoSuchElementException();
        E elem = tail.elem;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return elem;
    }

    /** Returns the last element without removing it */
    E peekLast() {
        if (tail == null) throw new java.util.NoSuchElementException();
        return tail.elem;
    }

    int size() { return size; }
}
