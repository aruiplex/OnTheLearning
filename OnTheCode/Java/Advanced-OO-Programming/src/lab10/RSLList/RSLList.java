package lab10.RSLList;// LAB EXERCISE 10.2  RSLLIST ROTATE RIGHT

/** Rotating Singly-Linked List */

// Complete the class declaration so that
// RSLList becomes a subclass of SLList

public class RSLList<T> extends SLList<T> {

    public RSLList() {
        super();
    }

    /**
     * Rotates list to the right.
     * Do nothing if the list is empty.
     */
    public void rotateRight() {
		if (this.size() == 0) return;
		this.addFirst(this.getLast());
		this.delLast();
    }

}