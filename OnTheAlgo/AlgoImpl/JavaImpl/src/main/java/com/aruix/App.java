package com.aruix;

import java.util.HashMap;

import com.aruix.impl.lab.week4.Mylist;
import com.aruix.impl.lab.week4.Mylist.MyNode;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Mylist l = new Mylist();
        MyNode n2 = l.new MyNode(2, null);
        MyNode n1 = l.new MyNode(1, n2);
    }
}
