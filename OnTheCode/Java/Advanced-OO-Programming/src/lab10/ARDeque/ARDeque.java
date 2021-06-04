package lab10.ARDeque;

import java.util.Iterator;

public class ARDeque<T> implements Deque<T>, Iterable<T> {
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
    @Override
    public int size() {
        return size;
    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public void printDeque() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public T delFirst() {
        return null;
    }

    @Override
    public T delLast() {
        return null;
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
     ***** HELPER METHODS START *****
     */

    // add your own helper methods here
	
	
	
	
	// INCLUDE in your submission
	// if you use them in your method

    /*
     ***** HELPER METHODS END *****
     */
	 
	 
	// add your own ARDeque codes from previous labs
	
	
	
	
	
	// EXERCISE 10.3  ITERATOR

    /**
     * Make an iterator
     */
    @Override
    public Iterator<T> iterator() {
		return new ARDequeIterator(this);
    }

    private class ARDequeIterator implements Iterator<T> {
        ARDeque<T> arDeque;
        int index;

        private ARDequeIterator(ARDeque<T> arDeque) {
            this.arDeque = arDeque;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < arDeque.size();
        }

        @Override
        public T next() {
            return arDeque.get(index++);
        }
    }
}