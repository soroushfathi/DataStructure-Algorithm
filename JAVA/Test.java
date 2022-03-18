import java.util.ArrayList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        LinkedLists intList = new LinkedLists(new Nodes(0));
        intList.add(2);
        intList.add(new Nodes(3));
        intList.add(4);
        intList.add(5);
        intList.add(new Nodes(6));
        System.out.println(intList.toString());
    }
}
