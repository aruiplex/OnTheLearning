package lab8.ARDeque;

// Second try

import java.util.Arrays;
import java.util.Objects;

public class ARDeque2<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;


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
    ******************* HELPER METHODS START *******************
	***** Include your helper method(s) in EACH Submission *****
	*********************** that uses it ***********************
    */


	 /* Resizes the underlying array to the target capacity. */
	@SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
	    // grow
        if (items.length < capacity) {
            System.arraycopy(items, nextLast, newItems, 0, items.length - nextLast);
            System.arraycopy(items, 0, newItems, items.length - nextLast, nextLast);
        }
        // shrink
        else if (nextFirst > nextLast) {
            if (nextFirst < items.length - 1)
                System.arraycopy(items, nextFirst + 1, newItems, 0, items.length - nextFirst - 1);
            if (nextLast > 0)
                System.arraycopy(items, 0, newItems, items.length - nextFirst - 1, nextLast);
        } else {
            System.arraycopy(items, nextFirst + 1, newItems, 0, size);
        }
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    /*
    ******************** HELPER METHODS END ********************
    */


    // LAB EXERCISE 8.1 EMPTY CONSTRUCTOR

    /**
     * Creates an empty deque.
     */
	@SuppressWarnings("unchecked")
    public ARDeque2() {
	    items = (T[]) new Object[4];
        size = 0;
        nextFirst = items.length - 1;
        nextLast = 0;
    }


    // LAB EXERCISE 8.2 ADD TO BACK

    /**
     * Adds an item of type T to the back of the deque.
     * @param item is a type T object to be added.
     */
    public void addLast(T item) {
        if (size >= items.length) resize(items.length * 2);
        items[nextLast] = item;
        size++;  // !forgot once
        nextLast++;
        if (nextLast >= items.length) nextLast = 0;
    }

    // LAB EXERCISE 8.3 PRINT ITEMS

    /**
     * Prints the items in the deque from first to last,
     * separated by a space, ended with a new line.
     */
    public void printDeque() {
        if (size <= 0) {
            System.out.println();
            return;
        }
        String toPrint = "";
        int count = 0;
        int index = nextFirst + 1;
        while(count < size) {
            if (index >= items.length) index = 0;
            toPrint += items[index] + " ";
            index++;
            count++;
        }
        System.out.println(toPrint.substring(0, toPrint.length() - 1));
    }


    // LAB EXERCISE 8.4 GET ITEM

    /**
     * Gets the item at the given index.
     * Does not mutate the deque.
     * @param index is an index where 0 is the front.
     * @return the index-th item of the deque.
     * @throws IndexOutOfBoundsException if no item exists at the given index.
     */
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index " + index + " is not valid");
        int realIndex = nextFirst + 1 + index;
        if (realIndex >= items.length) realIndex -= items.length;
        return items[realIndex];
    }


    // EXERCISE 8.1 ADD TO FRONT

    /**
     * Adds an item of type T to the front of the deque.
     * @param item is a type T object to be added.
     */
    public void addFirst(T item) {
        if (size >= items.length) resize(items.length * 2);
        items[nextFirst] = item;
        size++;
        nextFirst--;
        if (nextFirst < 0) nextFirst = items.length - 1;
    }


    // EXERCISE 8.2 DELETE FRONT

    /**
     * Deletes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * @return the first item of the deque, null if it does not exist.
     */
    public T delFirst() {
        if (size <= 0) return null;
        nextFirst = nextFirst + 1 >= items.length ? 0 : nextFirst + 1;
        T toDelete = items[nextFirst];
        items[nextFirst] = null;
        size--;
        if (size <= items.length / 4) resize(items.length / 2);
		return toDelete;
    }


    // EXERCISE 8.3 DELETE BACK

    /**
     * Deletes and returns the item at the back  of the deque.
     * If no such item exists, returns null.
     * @return the last item of the deque, null if it does not exist.
     */
    public T delLast() {
        if (size <= 0) return null;
        nextLast = nextLast - 1 <= 0 ? items.length - 1 : nextLast - 1;
        T toDelete = items[nextLast];
        items[nextLast] = null;
        size--;
        if (size <= items.length / 4) resize(items.length / 2);
        return toDelete;
    }


    // EXERCISE 8.4 COPY CONSTRUCTOR

    /**
     * Creates a (deep) copy of another Deque object.
     * @param other is another ARDeque<T> object.
     */
    @SuppressWarnings("unchecked")
    public ARDeque2(ARDeque2<T> other) {
        this.items = (T[]) new Object[other.items.length];
        System.arraycopy(other.items, 0, this.items, 0, this.items.length);
        this.size = other.size;
        this.nextFirst = other.nextFirst;
        this.nextLast = other.nextLast;
	}
}
