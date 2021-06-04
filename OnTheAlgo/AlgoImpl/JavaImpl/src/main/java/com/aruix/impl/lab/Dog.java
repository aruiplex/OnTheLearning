package com.aruix.impl.lab;

import java.util.Iterator;

public class Dog implements Animal, Iterator<Dog>, Iterable<Dog> {
    @Override
    public void sniff(Animal a) {
        System.out.println("sniff dog");
    }

    public void cool(Dog d) {
        // String a = "";
        System.out.println("cool dog");
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Dog next() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<Dog> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}
