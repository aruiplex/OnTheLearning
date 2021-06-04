package lecture11_and_lab11.Triple;

public class Triple<T extends Comparable<T>, S extends Comparable<S>, U extends Comparable<U>>
        implements Comparable<Triple<T, S, U>> {

    private T first;
    private S second;
    private U third;

    public Triple(T firstElement, S secondElement, U thirdElement) {
        first = firstElement;
        second = secondElement;
        third =  thirdElement;
    }

    public T getFirst() { return first; }
    public S getSecond() { return second; }
    public U getThird() { return third; }


    /*
     ***************************
     * DO NOT MODIFY CODE ABOVE
     ***************************
     */


    // EXERCISE 14.1  COMPARETO

    @Override
    public int compareTo(Triple<T, S, U> other) {
        int compareFirst = this.getFirst().compareTo(other.getFirst());
		if (compareFirst != 0) return compareFirst;
		int compareSecond = this.getSecond().compareTo(other.getSecond());
		if (compareSecond != 0) return compareSecond;
		return this.getThird().compareTo(other.getThird());
    }

}