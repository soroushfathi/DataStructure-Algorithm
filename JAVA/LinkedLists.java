public class LinkedLists {
    private Nodes head;

    public LinkedLists(Nodes head) {
        this.head = head;
    }

    public void add(Nodes cin){
        Nodes curr = head;
        while (curr.getNext()!=null){
            curr = curr.getNext();
        }
        curr.setNext(cin);
    }

    public void add(int value){
        Nodes curr = head;
        while (curr.getNext()!=null){
            curr = curr.getNext();
        }
        curr.setNext(new Nodes(value));
    }

    @Override
    public String toString() {
        StringBuilder strs = new StringBuilder(" ");
        Nodes curr = head;
        while (head.getNext() != null){
            strs.append(String.format("%d ", curr.getValue()));
            curr = curr.getNext();
        }
        return strs.toString();
    }
}
