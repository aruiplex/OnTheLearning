package lecture11_and_lab11.ARSet;

import java.util.Iterator;

public class ARSet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    /**
     * Create an empty set.
     */
    @SuppressWarnings("unchecked")
    public ARSet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /**
     * @return the number of items in the set
     */
    public int size() {
        return size;
    }

    /*
     ***************************
     * DO NOT MODIFY CODE ABOVE
     ***************************
     */


    // Copy paste your code from Week 10 here

    /**
     * Make an iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new ARSetIterator(items, size);
    }

    private class ARSetIterator implements Iterator<T> {
        T[] items;
        int size;
        int index;
        public ARSetIterator(T[] items, int size) {
            this.items = items;
            this.size = size;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return items[index++];
        }
    }


    // EXERCISE 10.1  CONTAINS

    /**
     * Checks whether an item is inside the set.
     * @param item to be checked
     * @return true iff the set contains the item
     */
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(items[i])) return true;
        }
        return false;
    }


    // EXERCISE 10.2  ADD

    /**
     * Adds an item into the set if it is not already inside.
     * @param item to be added inside the set.
     * @throws IllegalArgumentException if item is null.
     */
    public void add(T item) {
        if (item == null) throw new IllegalArgumentException();
        if (this.contains(item)) return;
        this.items[size] = item;
        size++;
    }


    // EXERCISE 11.2  EQUALS

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object that) {
		if (this == that) return true;
		if (that == null) return false;
		if (!(that instanceof ARSet)) return false;
		ARSet<T> thatSet = (ARSet<T>) that;
		if (this.size() != thatSet.size()) return false;
		for (T item: this) {
		    if (!thatSet.contains(item)) return false;
        }
		return true;
    }
}