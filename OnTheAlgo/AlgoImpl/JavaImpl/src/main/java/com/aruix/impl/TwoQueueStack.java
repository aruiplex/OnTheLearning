package com.aruix.impl;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {
    private Queue<Integer> mainQueue = new LinkedList<>();
    private Queue<Integer> bufferQueue = new LinkedList<>();

    /** Initialize your data structure here. */
    public TwoQueueStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        bufferQueue.addAll(mainQueue);
        mainQueue.clear();
        mainQueue.add(x);
        mainQueue.addAll(bufferQueue);
        bufferQueue.clear();
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return mainQueue.poll();
    }

    /** Get the top element. */
    public int top() {
        return mainQueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return mainQueue.isEmpty();
    }

    public String hello() {
        return "hello world";
    }
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
