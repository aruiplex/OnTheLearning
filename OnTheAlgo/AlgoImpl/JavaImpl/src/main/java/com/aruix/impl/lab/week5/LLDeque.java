package com.aruix.impl.lab.week5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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

    // LAB EXERCISE 5.1 EMPTY CONSTRUCTOR

    /**
     * Creates an empty deque.
     */
    public LLDeque() {
        this.size = 0;
        Node item = new Node(null, null, null);
        item.next = item;
        item.prev = item;
        this.sentinel.next = item;
    }

    // LAB EXERCISE 5.2 ADD TO FRONT

    /**
     * Adds an item of type T to the front of the deque.
     * 
     * @param item is a type T object added to the deque.
     */
    public void addFirst(T item) {
        Node newNode = new Node(null, item, this.sentinel.next);
        this.sentinel.next.prev = newNode;

        this.sentinel.next = newNode;

    }

    // LAB EXERCISE 5.3 PRINT ITEMS

    /**
     * Prints the items in the deque from first to last, separated by a space, ended
     * with a new line.
     */
    public void printDeque() {

    }

    // LAB EXERCISE 5.4 ITERATIVE GET ITEM

    /**
     * Gets the item at the given index. If no such item exists, returns null. Does
     * not mutate the deque.
     * 
     * @param index is an index where 0 is the front.
     * @return the ith item of the deque, null if it does not exist.
     */
    public T iterGet(int index) {

        return null;
    }

    // EXERCISE 5.1 ADD TO BACK

    /**
     * Adds an item of type T to the back of the deque.
     * 
     * @param item is a type T object added to the deque.
     */
    public void addLast(T item) {

    }

    // EXERCISE 5.2 DELETE FRONT

    /**
     * Deletes and returns the item at the front of the deque. If no such item
     * exists, returns null.
     * 
     * @return the first item of the deque, null if it does not exist.
     */
    public T delFirst() {

        return null;
    }

    // EXERCISE 5.3 DELETE BACK

    /**
     * Deletes and returns the item at the back of the deque. If no such item
     * exists, returns null.
     * 
     * @return the last item of the deque, null if it does not exist.
     */
    public T delLast() {

        return null;
    }

    // EXERCISE 5.4 RECURSIVE GET ITEM

    /**
     * Gets the item at the given index. If no such item exists, returns null. Does
     * not mutate the deque.
     * 
     * @param index is an index where 0 is the front.
     * @return the ith item of the deque, null if it does not exist.
     */
    public T recGet(int index) {

        return null;
    }
}
