package com.aruix.impl.lab.lab11.Dog;

import com.aruix.impl.lab.lab11.Duration.Duration;

public class Dog implements Comparable<Dog> {

    private String name;
    private int weight;

    public Dog(String n, int w) {
        name = n;
        weight = w;
    }

    /**
     * @param other another Dog
     * @return negative number if this is smaller than other 0 if this equals other
     *         positive number if this is larger than other
     */
    @Override
    public int compareTo(Dog other) {
        return this.weight - other.weight;
    }

    public void bark() {
        System.out.println(name + ": bark!");
    }

    /*
     ***************************
     * DO NOT MODIFY CODE ABOVE
     ***************************
     */

    // LAB EXERCISE 11.2 EQUALS

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dog))
            return false;
        if (o == null) {
            return false;
        }
        Duration d = (Duration) o;
        return this.name.equals(d.)
    }
}