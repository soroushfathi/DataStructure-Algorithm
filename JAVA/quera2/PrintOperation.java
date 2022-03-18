package quera2;

public class PrintOperation implements Operation{
    @Override
    public void perform(Node node) {
        System.out.println(node.getData() + " " + node.timestamp);
    }
}
