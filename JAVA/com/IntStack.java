package com;

import java.util.NoSuchElementException;

/**
 * with adapter design pattern, we adapt list
 */
public class IntStack {
    IntList list = new IntList();
    public int size(){
        return list.size();
    }
    public IntStack push(int v){
        list.pushBack(v);
        return this;
    }
    public int pop(){
        assureNotEmptyQueue();
        return list.removeBack();
    }
    public int top(){
        assureNotEmptyQueue();
        return list.get(size()-1);
    }
    private void assureNotEmptyQueue() {
        if (size() == 0)
            throw new NoSuchElementException("Queue is empty");
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        IntStack s = new IntStack();
        s.push(1).push(2).push(3);
        System.out.println(s.toString());
        s.pop();
        System.out.println(s.toString());
    }
}
