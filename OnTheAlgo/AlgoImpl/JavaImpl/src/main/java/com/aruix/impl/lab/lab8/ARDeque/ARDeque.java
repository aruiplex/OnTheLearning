package com.aruix.impl.lab.lab8.ARDeque;

public class ARDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int capacity = this.items.length;

    /**
     * @return the size of the array used in the deque.
     */
    public int itemsLength() {
        return items.length;
    }

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

    /*
     ******************* HELPER METHODS START ******************* Include your helper method(s) in
     * EACH Submission ***** that uses it ***********************
     */

    /* Resizes the underlying array to the target capacity. */
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Object[] newArray = new Object[capacity];

    }

    /*
     ******************** HELPER METHODS END ********************
     */

    // LAB EXERCISE 8.1 EMPTY CONSTRUCTOR

    /**
     * Creates an empty deque.
     */
    @SuppressWarnings("unchecked")
    public ARDeque() {
        this.size = 4;
        this.items = (T[]) new Object[4];
        this.nextFirst = 0;
        this.nextLast = 1;
    }

    // LAB EXERCISE 8.2 ADD TO BACK

    /**
     * Adds an item of type T to the back of the deque.
     * 
     * @param item is a type T object to be added.
     */
    public void addLast(T item) {
        items[nextLast] = item;
        nextLast++;
        if (nextLast >= capacity) {
            nextLast = 0;
        }

        size++;

    }

    // LAB EXERCISE 8.3 PRINT ITEMS

    /**
     * Prints the items in the deque from first to last, separated by a space, ended
     * with a new line.
     */
    public void printDeque() {

    }

    // LAB EXERCISE 8.4 GET ITEM

    /**
     * Gets the item at the given index. Does not mutate the deque.
     * 
     * @param index is an index where 0 is the front.
     * @return the index-th item of the deque.
     * @throws IndexOutOfBoundsException if no item exists at the given index.
     */
    public T get(int index) {

        return null;
    }

    // EXERCISE 8.1 ADD TO FRONT

    /**
     * Adds an item of type T to the front of the deque.
     * 
     * @param item is a type T object to be added.
     */
    public void addFirst(T item) {

    }

    // EXERCISE 8.2 DELETE FRONT

    /**
     * Deletes and returns the item at the front of the deque. If no such item
     * exists, returns null.
     * 
     * @return the first item of the deque, null if it does not exist.
     */
    public T delFirst() {

        return null;
    }

    // EXERCISE 8.3 DELETE BACK

    /**
     * Deletes and returns the item at the back of the deque. If no such item
     * exists, returns null.
     * 
     * @return the last item of the deque, null if it does not exist.
     */
    public T delLast() {

        return null;
    }

    // EXERCISE 8.4 COPY CONSTRUCTOR

    /**
     * Creates a (deep) copy of another Deque object.
     * 
     * @param other is another ARDeque<T> object.
     */
    public ARDeque(ARDeque<T> other) {

    }

}
