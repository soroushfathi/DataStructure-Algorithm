package com;

import java.util.NoSuchElementException;

public class IntDequeue {
    private IntList list = new IntList();
    public int size(){
        return list.size();
    }
    public IntDequeue add(int v){
        list.pushFront(v);
        return this;
    }
    public int pop(){
        assureNotEmptyQueue();
        return list.removeFront();
    }
    public IntDequeue push(int v){
        list.pushBack(v);
        return this;
    }
    public int take(){
        assureNotEmptyQueue();
        return list.removeBack();
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
        IntDequeue dequeue = new IntDequeue();
        dequeue.add(1).add(2).add(3).add(4);
        System.out.println(dequeue);
        dequeue.pop();
        System.out.println(dequeue);
        dequeue.push(0).push(-1).push(-2).push(-3);
        System.out.println(dequeue);
        dequeue.take();
        System.out.println(dequeue);

    }
}
