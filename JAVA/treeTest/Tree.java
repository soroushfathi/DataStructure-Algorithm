package treeTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Tree<T> implements Iterable<T> {

    /**
     * static -> creat instance
     * @param <T>
     */
    static class TreeNode<T>{

        private T value;
        private TreeNode<T> parent = null;
        private List<TreeNode<T>> children = new ArrayList<>();

        public TreeNode(T value, TreeNode<T> parent) {
            this.value = value;
            this.parent = parent;
        }

        public TreeNode(T value) {
            this.value = value;
        }

        public void addChildren(T value){
            getChildren().add(new TreeNode<>(value));
            TreeNode<T> last_child = getChildren().get(getChildren().size() - 1);
            last_child.parent = this;
        }
        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
        public TreeNode<T> getParent() {
            return parent;
        }
        public List<TreeNode<T>> getChildren() {
            return children;
        }
    }
    private TreeNode<T> root;

    public Tree(T rootValue) {
        this.root = new TreeNode<T>(rootValue);
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
//        Iterable.super.forEach(action);
    }

    public static void main(String[] args) {
        Tree<String> strTree = new Tree<>("Soroush");
        strTree.getRoot().addChildren("Fathi");
    }

}
