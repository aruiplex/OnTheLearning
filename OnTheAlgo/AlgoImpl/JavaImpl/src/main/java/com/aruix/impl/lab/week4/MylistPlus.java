package com.aruix.impl.lab.week4;

import java.util.LinkedList;
import java.util.List;

public class MylistPlus {
    public int size;
    public int modCount;
    List l = new LinkedList<>();

    public class MyNode {
        public int value;
        public MyNode next;

        public MyNode(int value, MyNode next) {
            this.next = next;
            this.value = value;
            size++;
        }

        public void ofEntries(Integer... args) {

        }
    }

}
