package lab8.ARDeque;

public class ARDeque<T> {
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
     ******************* HELPER METHODS START ******************* Include your helper method(s) in
     * EACH Submission ***** that uses it ***********************
     */

    /* Resizes the underlying array to the target capacity. */
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        /*
         * |----------------||----------------| 0 firstlast length
         */
        if (capacity > items.length) {
            T[] newItems = (T[]) new Object[capacity];
            System.arraycopy(items, nextLast, newItems, 1, items.length - nextLast);
            System.arraycopy(items, 0, newItems, 1 + (items.length - nextLast), nextFirst + 1);
            nextFirst = 0;
            nextLast = items.length + 1;
            items = newItems;
        }
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
        items = (T[]) new Object[4];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    // LAB EXERCISE 8.2 ADD TO BACK

    /**
     * Adds an item of type T to the back of the deque.
     * 
     * @param item is a type T object to be added.
     */
    public void addLast(T item) {
        if (size == items.length)
            this.resize(size * 2);
        items[nextLast] = item;
        nextLast++;
        size++;
        if (nextLast >= items.length)
            nextLast = 0;
    }

    // LAB EXERCISE 8.3 PRINT ITEMS

    /**
     * Prints the items in the deque from first to last, separated by a space, ended
     * with a new line.
     */
    public void printDeque() {
        if (size == 0) {
            System.out.println();
            return;
        }
        String output = "";
        int start = nextFirst + 1;
        if (start >= items.length)
            start = 0;
        int index = start;
        output += items[index] + " ";
        index++;
        while (index != nextLast) {
            if (index >= items.length)
                index = 0;
            output += items[index] + " ";
            index++;
        }
        output = output.substring(0, output.length() - 1);
        System.out.println(output);
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
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index " + index + " is not valid");
        int realIndex = nextFirst + 1;
        boolean discontinuous = false;
        if (nextLast <= realIndex)
            discontinuous = true;
        // if (size == items.length && realIndex == 0) discontinuous = false;
        realIndex += index;
        if (discontinuous) {
            if (realIndex >= items.length) {
                realIndex -= items.length;
                if (realIndex >= nextLast)
                    throw new IndexOutOfBoundsException("Index " + index + " is not valid");
            }
        } else {
            if (realIndex >= nextLast)
                throw new IndexOutOfBoundsException("Index " + index + " is not valid");
        }
        return items[realIndex];
    }

    // EXERCISE 8.1 ADD TO FRONT

    /**
     * Adds an item of type T to the front of the deque.
     * 
     * @param item is a type T object to be added.
     */
    public void addFirst(T item) {
        if (size == items.length)
            this.resize(size * 2);
        items[nextFirst] = item;
        nextFirst--;
        size++;
        if (nextFirst < 0)
            nextFirst = items.length - 1;
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
    @SuppressWarnings("unchecked")
    public ARDeque(ARDeque<T> other) {
        ARDeque<T> copied = new ARDeque<T>();
        int index = 0;
        while (index < other.size) {
            // copied.addLast((T) new Object(other.get(index)));
            index++;
        }

    }

}
