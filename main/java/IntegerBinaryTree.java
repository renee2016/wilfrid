
import java.util.ArrayList;

public class IntegerBinaryTree {
    private ArrayList elements = new ArrayList();
    private int count = 0;
    private IntegerBinaryTreeNode root;

    public IntegerBinaryTree() {
    }

    public IntegerBinaryTree(ArrayList elements) {
        this.elements = elements;
    }


    public int size() {
        return count;
    }

    public void insert(int element) {
        if(root==null){
            root = new IntegerBinaryTreeNode(element);
        }
        ++count;
    }

    public IntegerBinaryTreeNode getRoot() {
        return root;
    }
}