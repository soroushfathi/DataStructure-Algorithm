public class Nodes {
    private int value;
    private Nodes next;

    public Nodes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Nodes getNext() {
        return next;
    }
    public void setNext(Nodes next) {
        this.next = next;
    }
}
