package quera2;

public class Program {
    public static void main(String[] args) {
        int[] numbers = {8,72,5,13,22,7,18,46,37,69};
        LinkedList linkedList = new LinkedList(numbers);
//        LinkedList linkedList = LinkedList.of(8,72,5,13,22,7,18,46,37,69);
        PrintOperation printOperation = new PrintOperation();
        Node current = linkedList.getFirstNode();
        while (current.getNext().getNext()!=null){
            printOperation.perform(current);
            current = current.getNext();
        }
    }
}
