package intLinkedLists;

import quera2.Node;

import java.util.NoSuchElementException;

public class IntLinkedList {
    private static class Node{
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
        public int getValue() {
            return value;
        }
        public Node getNext() {
            return next;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    public int size() {
        return size;
    }

    public Integer last(){
        if (isEmpty())
            return null;
        return tail.getValue();
    }
    public void addFirst(int value){
        head = new Node(value, head);
        if (isEmpty()){
            tail = head;
        }
        size++;
    }
    public void addLast(int value){
        Node newest = new Node(value,null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }
    public Integer get(int i){
        if(isEmpty() || i<0)
            return null;
        Node current = head;
        for (int j = 0; j < i; j++)
            current = current.getNext();
        if (current==null)
            return null;
        return current.value;
    }
    public Integer removeFirst(){
        if (isEmpty())
            return null;
        Node answer = head;
        head = answer.getNext();
        size--;
        if (size==0)
            tail = null;
        return answer.getValue();
    }
    public Boolean isEmpty(){
        return size() == 0;
    }
    public void remove(int index){
        if(isEmpty() || index<0 || index>=size())
            throw new NoSuchElementException("index is out of range: " + index);
        if(size()==1){
            head = null;
            tail = null;
        }
        Node current = head;
        if (index==0){
            head = current.getNext();
            current.setNext(null);
        } else if(index<size()-1){
            for (int i = 0; i < index; i++)
                current = current.getNext();
            current.setNext(current.getNext().getNext());
            current.getNext().setNext(null);
        } else if(index==size()-1){
            for (int i = 0; i < index - 1; i++)
                current = current.getNext();
            tail = current;
            current.setNext(null);
        }
    }

    public boolean delete(int data) {
        if (isEmpty())
            throw new NoSuchElementException();
        else {
            boolean deleted = false;
            if (head.getValue() == data) { 
                Node temp = head;
                head = head.getNext();
                temp.setNext(null);
                deleted = true;
            } else {
                Node current = head;
                while (current != null)
                    if (current.getNext() != null && current.getNext().getValue() == data) {
                        Node temp = current.getNext();
                        current.setNext(temp.getNext());
                        temp.setNext(null);
                        deleted = true;
                        break;
                    } else
                        current = current.getNext();
            }
            if (deleted)
                size--;
            return deleted;
        }

    }
    public static void main(String[] args) {
        IntLinkedList intList = new IntLinkedList();
        intList.addFirst(1);
        intList.addFirst(2);
        intList.addFirst(3);
        intList.addLast(4);
        System.out.print(intList.get(0));
        System.out.print(intList.get(1));
        System.out.print(intList.get(2));
        System.out.println(intList.get(3));
        intList.remove(3);
        System.out.print(intList.get(2));
    }
}