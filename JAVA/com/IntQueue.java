package com;

import java.util.NoSuchElementException;

/**
 * with adapter design pattern, we adapt list
 */
public class IntQueue {
    private IntList list = new IntList();

    public int size(){
        return list.size();
    }
    public IntQueue add(int v){
        list.pushBack(v);
        return this;
    }
    public int take(){
        assureNotEmptyQueue();
        return list.removeFront();
    }
    public int head(){
        assureNotEmptyQueue();
        return list.get(0);
    }
    // runtime exception no need catch
    private void assureNotEmptyQueue() {
        if (size() == 0)
            throw new NoSuchElementException("Queue is empty");
    }

    public int tail(){
        assureNotEmptyQueue();
        return list.get(size()-1);
    }

    @Override
    public String toString() {
        return list.toString();
    }
    public static void main(String[] args){
        IntQueue q = new IntQueue();
        q.add(1).add(2).add(3);
        System.out.println(q.head());
        System.out.println(q.tail());
        System.out.println(q.add(4));
        System.out.println(q.take());
        System.out.println(q);
    }
}
