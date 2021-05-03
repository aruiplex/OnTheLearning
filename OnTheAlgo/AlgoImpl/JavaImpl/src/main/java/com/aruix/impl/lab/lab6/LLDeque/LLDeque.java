package com.aruix.impl.lab.lab6.LLDeque;

import java.util.LinkedList;

public class LLDeque<T> {

    private class Node {
        Node prev;
        T item;
        Node next;

        Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /**
     * @return the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * @return true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     ***************************
     * DO NOT MODIFY CODE ABOVE
     ***************************
     */

    // EXERCISE 6.1 COPY CONSTRUCTOR

    /**
     * Creates a (deep) copy of another Deque object.
     * 
     * @param other is another LLDeque<T> object.
     */
    public LLDeque(LLDeque<T> other) {
        this();
        Node s = other.sentinel;
        while (s.next != other.sentinel) {
            // this.addLast(s.next.item);
            s = s.next;
        }
    }

    // EXERCISE 6.2 ADD NOT NULL TO FRONT

    /**
     * Adds an non-null item of type T to the front of the deque.
     * 
     * @param item is a type T object.
     * @throws IllegalArgumentException if the item is null.
     */
    public void addFirst(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node next = this.sentinel.next;
        Node node = new Node(this.sentinel, item, next);
        next.prev = node;
        this.sentinel.next = node;
        size++;
    }

    // EXERCISE 6.3 ADD LEGAL ITEM TO FRONT

    /**
     * Adds the first item of type T to the front of the deque, or the second item
     * of type T instead if the first item is illegal.
     * 
     * @param item1 is a type T object.
     * @param item2 is a type T object.
     */
    public void addLegalFirst(T item1, T item2) {
        try {
            this.addFirst(item1);
        } catch (IllegalArgumentException e) {
            this.addFirst(item2);
        }
    }

    /*
     *************************************************************
     * You can copy paste Lab 5 codes below if you want to use it
     *************************************************************
     */

    public LLDeque() {
        this.size = 0;
        Node item = new Node(null, null, null);
        item.next = item;
        item.prev = item;
        this.sentinel.next = item;
    }

}
