# Iterate



## Iterator



## Iteratable

Implement the **Iteratable** is the syntax sugar for *forEach*. After implment this interface, there must implement the method:

```java
@Override
public Iterator<T> iterator() {

}
```

## Example

```java

class CustomDataStructure implements Iterable<> {
      
    // code for data structure
    public Iterator<> iterator() {
        return new CustomIterator<>(this);
    }
}
class CustomIterator<> implements Iterator<> {
      
    // constructor
    CustomIterator<>(CustomDataStructure obj) {
        // initialize cursor
    }
      
    // Checks if the next element exists
    public boolean hasNext() {
    }
      
    // moves the cursor/iterator to next element
    public T next() {
    }
      
    // Used to remove an element. Implement only if needed
    public void remove() {
        // Default throws UnsupportedOperationException.
    }
}
```



















