package lab12.HAMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 *  Hash-based Map
 */
public class HAMap<K, V> implements Iterable<K> {

    /**
     * Represents a key-value pair.
     */
    private class Entry {
        K key;
        V value;

        Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 1.5;

    private ArrayList<ArrayList<Entry>> buckets;
    private HashSet<K> keySet;
    private int numBuckets;
    private int numEntries;
    private final double loadFactor;

    /**
     * @return a set of the keys contained in this map.
     */
    public HashSet<K> keySet() {
        return keySet;
    }

    /**
     * @return the number of entries in this map.
     */
    public int size() {
        return numEntries;
    }

    /**
     * @return the number of buckets in this map.
     */
    public int getNumBuckets() {
        return numBuckets;
    }

    /*
     ***************************
     * DO NOT MODIFY CODE ABOVE
     ***************************
     */


    /*
     ***** HELPER METHODS START *****
     */

    
	// INCLUDE your helper methods in EACH of your submissions that use them

    /**
     * Calculates the supposed bucket index of the given key
     * @param key of the value
     * @return calculated index
     */
	private int calculateIndex(K key) {
	    return Math.floorMod(key.hashCode(), this.numBuckets);
    }

    /**
     * Checks whether resize is necessary by comparing N/M and load factor
     * @return true if resized
     *         false if not resized
     */
	private boolean checkResize() {
	    // Check load factor
	    double loadFactor = (double) this.numEntries / this.numBuckets;
	    // If N/M > load factor, double size
        if (loadFactor >= this.loadFactor) {
            // Double numBuckets
            this.numBuckets *= 2;
            // Initialize new map
            ArrayList<ArrayList<Entry>> newBuckets = new ArrayList<>();
            for (int i = 0; i < this.numBuckets; i++) {
                newBuckets.add(new ArrayList<Entry>());
            }
            // Move every entry from the old map to the new map
            for (ArrayList<Entry> bucket : this.buckets) {
                if (!bucket.isEmpty()) {
                    for (Entry entry: bucket) {
                        int index = calculateIndex(entry.key);
                        newBuckets.get(index).add(entry);
                    }
                }
            }
            // Replace buckets with newBuckets
            this.buckets = newBuckets;
            // Resized, return true
            return true;
        }
        // Not resized, return false
        return false;
    }
	

    /*
     ***** HELPER METHODS END *****
     */


    // LAB EXERCISE 12.2 CONSTRUCTORS

    public HAMap(int initialCapacity, double loadFactor) {
        this.buckets = new ArrayList<>();
        for (int i = 0; i < initialCapacity; i++) {
            this.buckets.add(new ArrayList<Entry>());
        }
        this.keySet = new HashSet<>();
        this.numBuckets = initialCapacity;
        this.numEntries = 0;
        this.loadFactor = loadFactor;
    }

    public HAMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HAMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public static void main(String[] args) {
//        HAMap<String, Integer> map = new HAMap<>(4);
//        char keyChar = '0';
//        for (int i = 0; i < 60; i++) {
//            double loadFactor = (double) map.numEntries / map.numBuckets;
//            map.put(keyChar + "", 1);
//            keyChar++;
//        }

        HAMap<String, Integer> map = new HAMap<>(8, 0.75);
        System.out.println(map.remove("", 0));
        System.out.println(map.size());
        System.out.println(map.get("a"));
        System.out.println(map.containsKey(""));
        System.out.println("setsize=" + map.keySet().size());
        map.put("a", 0);
        System.out.println(map.get("a"));

        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
        for (int i = 1; i <= 4; i++) {
            map.put("x" + i, i);
        }
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
        map.put("x" + 5, 5);
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
        map.put("x" + 6, 6);
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
        map.put("x" + 7, 7);
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());

        System.out.println(map.get("a"));
        map.put("a", 0);
        System.out.println(map.get("a"));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
        map.put("a", 1);
        System.out.println(map.get("a"));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
        map.put(new String("a"), 0);
        System.out.println(map.get("a"));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
        map.put(new String("a"), 0);
        System.out.println(map.get("a"));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());

        for (String key : map) {
            System.out.print("(" + key + "," + map.get(key) + ") ");
        }
        System.out.println();

        map.put("b", 0);
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
        map.put("c", 0);
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
        map.put("a", 0);
        map.put("b", 0);
        map.put("c", 0);
        map.put("b", 0);
        map.put("a", 0);
        map.put("c", 0);
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());

        System.out.println(map.remove("bc", 0));
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());

        System.out.println(map.remove("b", 0));
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
    }


    // LAB EXERCISE 12.3 CLEAR

    /**
     * Removes all of the entries from this map.
     */
    public void clear() {
        for (int i = 0; i < this.buckets.size(); i++) {
            this.buckets.get(i).clear();
        }
		this.keySet.clear();
		this.numEntries = 0;
    }


    // LAB EXERCISE 12.4 CONTAINS KEY and ITERATOR

    /**
     * @param key to be checked
     * @return true iff this map contains an entry with the specified key
     */
    public boolean containsKey(K key) {
        return this.keySet.contains(key);
    }

    /**
     * @return an Iterator that iterates over the stored keys
     */
    @Override
    public Iterator<K> iterator() {
		return this.keySet.iterator();
    }


    // EXERCISE 12.1 GET

    /**
     * @param key of the value to be returned
     * @return the value to which the specified key is mapped
     *         null if this map contains no entries of the key
     */
    public V get(K key) {
        int index = this.calculateIndex(key);
        ArrayList<Entry> bucket = this.buckets.get(index);
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
		return null;
    }


    // EXERCISE 12.2 PUT

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained an entry with that key, the old value is replaced.
     * The key is not null.
     * @param key of the entry to be added
     * @param value of the entry to be added
     */
    public void put(K key, V value) {
        // Check replace
        ArrayList<Entry> bucket = this.buckets.get(this.calculateIndex(key));
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        // Check resize and update bucket if necessary
        if (this.checkResize()) bucket = this.buckets.get(this.calculateIndex(key));
		// Add entry
        Entry entry = new Entry(key, value);
        bucket.add(entry);
        this.keySet.add(key);
        this.numEntries++;
    }
	
    // EXERCISE 12.3 REMOVE

    /**
     * Removes the entry for the specified key only if it is
     * currently mapped to the specified value.
     * @param key of the entry to be removed
     * @param value of the entry to be removed
     * @return the value if entry found,
     *         null otherwise
     */
    public V remove(K key, V value) {
        // Validate key and value
        boolean found = false;
        int index = 0;
        ArrayList<Entry> bucket = this.buckets.get(this.calculateIndex(key));
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                if (bucket.get(i).value.equals(value)) {
                    found = true;
                    index = i;
                    break;
                }
            }
        }
        if (!found) {
            return null;
        }
		// Remove entry
        bucket.remove(index);
        // Remove key
        this.keySet.remove(key);
        // Decrease numEntries by 1
        this.numEntries--;
		return value;
    }
}
