package quera2;

import java.time.LocalDateTime;

public class Node {
    private int data;
    final long timestamp;
    private Node next;
    public Node(){
        this(0);
    }
    public Node(int data){
        setData(data);
        setNext(null);
        timestamp = System.currentTimeMillis();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
