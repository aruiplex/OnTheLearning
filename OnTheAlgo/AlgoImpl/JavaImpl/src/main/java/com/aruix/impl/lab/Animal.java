package com.aruix.impl.lab;

public interface Animal {
    default void hello(Animal a) {
        System.out.println("hello animal");
    }

    default void sniff(Animal a) {
        System.out.println("sniff animal");
    }

    default void cool(Animal a) {
        System.out.println("cool animal");
    }
}
