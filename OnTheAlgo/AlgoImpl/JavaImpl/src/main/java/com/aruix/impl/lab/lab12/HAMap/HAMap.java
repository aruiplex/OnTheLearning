import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Hash-based Map
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
    private int reduce(K key, int capacity) {
        return Math.floorMod(key.hashCode(), capacity);
    }

    private void resize(int capacity) {
        ArrayList<ArrayList<Entry>> newBucket = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            newBucket.add(new ArrayList<>());
        }
//    rehash
        for (K key : this) {
            int newIndex = reduce(key, capacity);
            newBucket.get(newIndex).add(new Entry(key, get(key)));
        }
        buckets = newBucket;
        this.numBuckets = capacity;
    }




    /*
     ***** HELPER METHODS END *****
     */


    // LAB EXERCISE 12.2 CONSTRUCTORS

    public HAMap(int initialCapacity, double loadFactor) {
        numBuckets = initialCapacity;
        numEntries = 0;
//		为什么numEntries=loadFactor会报错
        this.loadFactor = loadFactor;
        keySet = new HashSet<>();
        buckets = new ArrayList<>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

    }

    public HAMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    //为什么这里写了，loadFactor就不报错了？
    public HAMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }


    // LAB EXERCISE 12.3 CLEAR

    /**
     * Removes all of the entries from this map.
     */
    public void clear() {
        numEntries = 0;
        keySet = new HashSet<>();
        buckets = new ArrayList<>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }
    }


    // LAB EXERCISE 12.4 CONTAINS KEY and ITERATOR

    /**
     * @param key to be checked
     * @return true iff this map contains an entry with the specified key
     */
    public boolean containsKey(K key) {
        return keySet.contains(key);
    }

    /**
     * @return an Iterator that iterates over the stored keys
     */
    @Override
    public Iterator<K> iterator() {
        return keySet.iterator();
    }
    // EXERCISE 12.1 GET

    /**
     * @param key of the value to be returned
     * @return the value to which the specified key is mapped
     * null if this map contains no entries of the key
     */
    public V get(K key) {
        int index=this.reduce(key,numBuckets);
        for (Entry e: buckets.get(index)) {
             if (key.equals(e.key)){
                 return e.value;
             }
        }
        return null;
    }


    // EXERCISE 12.2 PUT

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained an entry with that key, the old value is replaced.
     * The key is not null.
     *
     * @param key   of the entry to be added
     * @param value of the entry to be added
     */
    public void put(K key, V value) {
        int index=this.reduce(key,numBuckets);
        if (keySet.contains(key)){
//            buckets.get(index).remove(new Entry(key,value));
            for (Entry e:buckets.get(index) ) {
                e.value=value;
            }
//            buckets.get(index).add(new Entry(key,value));
        }else {
            keySet.add(key);
            buckets.get(index).add(new Entry(key,value));
            if ((float)numEntries/(float) numBuckets>=loadFactor){
                resize(2*numBuckets);
            }
            numEntries++;
        }
    }


    // EXERCISE 12.3 REMOVE

    /**
     * Removes the entry for the specified key only if it is
     * currently mapped to the specified value.
     *
     * @param key   of the entry to be removed
     * @param value of the entry to be removed
     * @return the value if entry found,
     * null otherwise
     */
    public V remove(K key, V value) {
        int index=this.reduce(key,numBuckets);
        if (keySet.contains(key)){
//            buckets.get(index).remove(new Entry(key,value));
            for (int i = 0; i < buckets.get(index).size(); i++) {
                if (buckets.get(index).get(i).value.equals(value)){
                    buckets.get(index).remove(i);
                    keySet.remove(key);
                    numEntries--;
                    return value;
                }
            }

            }

        return null;
    }

    public static void main(String[] args) {
        HAMap<Integer, String> map = new HAMap<>(32);
        System.out.println(map.size());
        System.out.println(map.get(0));
        System.out.println("setsize=" + map.keySet().size());
        map.put(0, "a");
        System.out.println(map.get(0));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());

        map.put(0, "b");
        System.out.println(map.get(0));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());

        for (int i = 1; i <= 46; i++) {
            map.put(i, "x" + i);
        }
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
        map.put(47, "x" + 47);
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
        map.put(48, "x" + 48);
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
        map.put(49, "x" + 49);
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());

        System.out.println(map.remove(10, "x"));
        System.out.println(map.get(10));
        System.out.println(map.containsKey(10));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());

        System.out.println(map.remove(10, new String("x10")));
        System.out.println(map.get(10));
        System.out.println(map.containsKey(10));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());

        map.put(10, "abc");
        System.out.println(map.get(10));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());

        map.put(10, new String("abc"));
        System.out.println(map.get(10));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());

        map.clear();
        System.out.println(map.get(0));
        System.out.println(map.get(49));
        System.out.println(map.containsKey(0));
        System.out.println("size=" + map.size());
        System.out.println("nbuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
    }

}
