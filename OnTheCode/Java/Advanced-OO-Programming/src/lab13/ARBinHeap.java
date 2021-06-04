package lab13;

/**
 *  Resizing-array-based Binary Heap
 */
public class ARBinHeap<T extends Comparable<T>> implements MinPQ<T> {

    private T[] heap;     // store items at indices 1 to n
    private int size;     // number of items on binary heap

    /*
     ********************
     Helper methods start
     ********************
     */
    @SuppressWarnings("unchecked")
    private void checkAndResize() {
        if (this.size + 1 < this.heap.length) return;
        T[] newHeap = (T[]) new Comparable[this.heap.length * 2];
        System.arraycopy(heap, 1, newHeap, 1, this.size);
        this.heap = newHeap;
    }

    private int getParentIndex(int index) {
        return index / 2;
    }

    private int getFirstChildIndex(int index) {
        return index * 2;
    }
	 

    /*
     ******************
     Helper methods end
     ******************
     */


    // LAB EXERCISE 13.1 CONSTRUCTORS

    /**
     * Initializes an empty binary heap with the given initial capacity.
     * @param  initCapacity the initial capacity of this binary heap
     */
    @SuppressWarnings("unchecked")
    public ARBinHeap(int initCapacity) {
        this.heap = (T[]) new Comparable[initCapacity];
		this.size = 0;
    }


    /**
     * Initializes an empty binary heap.
     */
    public ARBinHeap() {
        this(1);
    }

    // LAB EXERCISE 13.2 GETMIN

    /**
     * Returns a smallest item on this binary heap.
     * This binary heap is not empty.
     * @return a smallest item on this binary heap
     */
    @Override
    public T getMin() {
        return this.heap[1];
    }


    // LAB EXERCISE 13.3 ADD

    /**
     * Adds a new item to this binary heap.
     * @param item the item to add to this binary heap
     */
    @Override
    public void add(T item) {
        // Check and resize if necessary
        this.checkAndResize();
        // Increase this.size
		this.size++;
		// Add item to the end
        int index = this.size;
        this.heap[index] = item;
        // Swim
        while ((index > 1) && (this.heap[this.getParentIndex(index)].compareTo(item) > 0)) {
            this.heap[index] = this.heap[this.getParentIndex(index)];
            this.heap[this.getParentIndex(index)] = item;
            index = this.getParentIndex(index);
        }
    }

    public static void main(String[] args) {
        ARBinHeap<Integer> heap = new ARBinHeap<>();
        int size = 20;
        Integer min = 0;
        for (int i = 0; i < size; i++) {
            heap.add((int) (Math.random() * 5));
        }
        for (int i = 0; i < size; i++) {
            min = heap.delMin();
        }
    }


    // LAB EXERCISE 13.4 DELMIN

    /**
     * Removes and returns a smallest item on this binary heap.
     * This binary heap is not empty.
     * @return a smallest item on this binary heap
     */
    @Override
    public T delMin() {		
		T min = this.getMin();
		// Replace the first item with the last item
        this.heap[1] = this.heap[size];
        // Remove the last item and decrease size
        this.heap[size] = null;
        this.size--;
        // Sink
        int index = 1;
        while ((this.getFirstChildIndex(index) < this.heap.length - 1) &&
                (this.heap[this.getFirstChildIndex(index)] != null)) {
            int firstChildIndex = this.getFirstChildIndex(index);
            // Get the smaller child
            T firstChild = this.heap[firstChildIndex];
            T smallerChild;
            int smallerChildIndex;
            if (this.heap[firstChildIndex + 1] == null) { // Does not have second child
                smallerChild = firstChild;
                smallerChildIndex = firstChildIndex;
            } else { // Has second child
                T secondChild = this.heap[firstChildIndex + 1];
                if (firstChild.compareTo(secondChild) > 0) { // Second child smaller
                    smallerChild = secondChild;
                    smallerChildIndex = firstChildIndex + 1;
                } else { // First child smaller or equal to second child
                    smallerChild = firstChild;
                    smallerChildIndex = firstChildIndex;
                }
            }
            // If smaller child larger than or equal to its parent, break
            if (smallerChild.compareTo(this.heap[index]) >= 0) break;
            // Exchange
            T swap = this.heap[index];
            this.heap[index] = smallerChild;
            this.heap[smallerChildIndex] = swap;
            index = smallerChildIndex;
        }

        return min;
    }


    // DO NOT MODIFY CODE BELOW
    // for testing and visualization

    /**
     * Returns true if this binary heap is empty.
     * @return true if this binary heap is empty;
     *         false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns the number of items on this binary heap.
     * @return the number of items on this binary heap
     */
    @Override
    public int size() {
        return size;
    }

    public T[] toArray() {
        return heap;
    }


}
