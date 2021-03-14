package com.aruix.impl.lab;

import java.util.ArrayList;
import java.util.List;

/**
 * Lab Exercise 2.1 Max Stretch We define the stretch of a value in a list to be
 * the number of elements between that two leftmost and rightmost values in that
 * list, inclusive. For example, the stretch of 2 in [5, 2, 2, 5, 2] is 4 (from
 * 2, 2, 5, 2).
 * 
 * A single value in a list has a stretch of 1. Write a method that returns the
 * maximum stretch found in the input list.
 * 
 * Test case 1: maxStretch([8, 5, 1, 2, 3, 4, 5, 10]) = 6 (from 5, 1, 2, 3, 4,
 * 5) Test case 2: maxStretch([2, 7, 1, 2, 3, 7]) = 5 (from 7, 1, 2, 3, 7)
 */

/** 只想出来了 n^2 的解决方案 */
public class MaxStretch {
    public static class Node {
        int value;
        List<Integer> indexs;

        Node(int value, int index) {
            this.value = value;
            this.indexs.add(index);
        }

        add(){

        }
    }

    public int haha(int[] arr) {
        List<Node> l = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i], i);
        }
        return 0;
    }

}
