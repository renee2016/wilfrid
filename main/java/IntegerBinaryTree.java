
import java.util.ArrayList;

/**
 * Created by jfwu on 2016-12-23.
 */
public class IntegerBinaryTree {
    private ArrayList elements = new ArrayList();
    private int count = 0;
    private IntegerTreeNode root;

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
            root = new IntegerTreeNode(element);
        }
        ++count;
    }

    public IntegerTreeNode getRoot() {
        return root;
    }
}