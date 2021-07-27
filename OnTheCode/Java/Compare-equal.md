# Compare and Equal Object





## Compare



interface: `Comparable<T>` to compare properties.

```java
public class Dog implements Comparable<Dog> {
    int weight;
    
    @Override
    public int compareTo(Dog other){
        return this.weight - other.weight
	}
    
    public static Comparable max (Comparable[] items) {
        int maxIndex = 0;
        int cmp;
        
        for (int i; i < items.length; i++){
            cmp = items[i].compareTo (items[maxIndex]);
            if (cmp > 0){
                maxIndex = i;
            }
        }
    }
    return items[maxIndex];
}

```



The method *compareTo* is return int.

1. negative if this small than others.
2. 0 if the same;
3. positive if this larger than others





## Equal

