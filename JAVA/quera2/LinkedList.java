package quera2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LinkedList {
    private int count;
    private Node firstNode;

    public LinkedList(){
        count =0;
        firstNode = null;
    }
    public LinkedList(int[] numbers){
        for(int num : numbers)
            add(num);
    }
    public static LinkedList of(int... numbers){
        return new LinkedList(numbers);
    }
    public  boolean isEmpty(){
        return count==0;
    }
    public  void add(int data){
        Node newNode = new Node(data);
        if(isEmpty())
            firstNode = newNode;
        else {
            Node current = firstNode;
            while (current.getNext()!=null)
                current = current.getNext();
            current.setNext(newNode);
        }
        count++;
    }
    public boolean delete(int data) {
        if (isEmpty())
            throw new IllegalArgumentException();
        else {
            boolean deleted = false;
            if (firstNode.getData() == data) {
                Node temp = firstNode;
                firstNode = firstNode.getNext();
                temp.setNext(null);
                deleted = true;
            } else {
                Node current = firstNode;
                while (current != null)
                    if (current.getNext() != null && current.getNext().getData() == data) {
                        Node temp = current.getNext();
                        current.setNext(temp.getNext());
                        temp.setNext(null);
                        deleted = true;
                        break;
                    } else
                        current = current.getNext();
            }
            if (deleted)
                count--;
            return deleted;
        }
    }

    public int get(int index) {
        if(index < 0 || index >= count){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Node current = firstNode;
            for(int i=0; i<index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }
    }

    public String toString() {
        if(isEmpty()) {
            return null;
        } else {
            StringBuilder buffer = new StringBuilder();
            Node current = firstNode;
            while(current != null) {
                buffer.append(current.toString());
                current = current.getNext();
            }
            return buffer.toString();
        }
    }
    public void reverse(){
        Node[] nodes = new Node[count];
        Node current = firstNode;
        for (int i = 0; i < count && current.getNext()!=null; i++) {
            nodes[i] = current;
            current = current.getNext();
        }
        reverse(nodes);
        current = firstNode;
        int i=0;
        while (current.getNext()!=null){
            current = nodes[i];
            i++;
            current = current.getNext();
        }
    }
    public static void reverse(Node[] nodes) {
        List<Node> list = Arrays.asList(nodes);
        Collections.reverse(list);
    }
    public void sort (){
        Node tmp1 = firstNode;
        Node tmp2 = firstNode.getNext();
        Node tmp3;
        while (tmp1.getNext()!=null){
            while (tmp2.getNext()!=null){
                if(tmp2.getData()>tmp1.getData()){
                    tmp3 = tmp2;
                    tmp2 = tmp1;
                    tmp1 =tmp2;
                }
            }
            tmp1 = tmp1.getNext();
        }
    }
    public void insertAtFirst(int val){
        Node newNode = new Node(val);
        count++;
        Node[] nodes = new Node[count];
        Node item = firstNode;
        for (int i = 1; i < count && item.getNext()!=null; i++) {
            nodes[i] = item;
            item = item.getNext();
        }
        nodes[0] = newNode;
        Node current = firstNode;
        for (Node tmp: nodes) {
            current = tmp;
            current = current.getNext();
        }
    }
    public Node getLastNode(){
        Node current = firstNode;
        while (current.getNext()!=null)
            current = current.getNext();
        return current;
    }
    public Node[] getNodes(){
        Node[] nodes = new Node[count];
        Node item = firstNode;
        for (int i = 1; i < count && item.getNext()!=null; i++) {
            nodes[i] = item;
            item = item.getNext();
        }
        return nodes;
    }
    public int[] toArray(){
        Node current = firstNode;
        int[] dates = new int[count];
        for (int i=0; current.getNext()!=null;i++){
            dates[i] = current.getData();
            current = current.getNext();
        }
        return dates;
    }
    public void removeOlds(){
        Node current = firstNode;
        while (current.getNext()!=null){
            if(current.timestamp-System.currentTimeMillis()>60000)
                delete(current.getData());
            current = current.getNext();
        }
    }
    public void perform(Operation operation){
        Node current = firstNode;
        while (current.getNext()!=null){
            operation.perform(current);
            current = current.getNext();
        }
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }
}
