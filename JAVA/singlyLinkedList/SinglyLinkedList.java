package singlyLinkedList;

import intLinkedLists.IntLinkedList;

public class SinglyLinkedList<E> {
    private static class Node<E>{
        private E element;
        private Node<E> next;
        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> n){
            next = n;
        }
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public E get(int index){
        if(isEmpty() || index<0)
            return null;
        Node<E> current = head;
        for (int j = 0; j < index + 1; j++)
            current = current.getNext();
        if (current==null)
            return null;
        return current.getElement();
    }
    public void addFirst(E e){
        head = new Node<>(e, head);
        if(size==0)
            tail = head;
        size++;
    }
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }
    public E removeFirst(){
        if (isEmpty())
            return null;
        E answer = head.getElement();
        size--;
        if(size==0)
            tail = null;
        return answer;
    }


}
