
import java.util.ArrayList;

public class IntegerBinaryTree {
    private int count = 0;
    private IntegerBinaryTreeNode root;

    public IntegerBinaryTree() {
    }

    public IntegerBinaryTree(ArrayList<Integer> elements) {
        int size = elements.size();
        for(int i = 0 ; i< size; ++ i){
            insert(elements.get(i));
        }
    }


    public int size() {
        return count;
    }

    public void insert(int newValue) {
        if(root==null){
            root = new IntegerBinaryTreeNode(newValue);
        }
        else{
            IntegerBinaryTreeNode currentNode = root;
            while (currentNode != null)
            {
                if(currentNode.getValue()> newValue){
                    if(currentNode.getLeftChildNode() == null){
                        currentNode.setLeftChildNode(new IntegerBinaryTreeNode(newValue));
                    }
                    else {
                        currentNode = currentNode.getLeftChildNode();
                    }
                }
                else if(currentNode.getValue()<newValue){
                    if(currentNode.getRightChildNode() == null){
                        currentNode.setRightChildNode(new IntegerBinaryTreeNode(newValue));
                    }
                    else{
                        currentNode = currentNode.getRightChildNode();
                    }
                }
                else{
                    return;
                }
            }
        }
        ++count;
    }

    public IntegerBinaryTreeNode getRoot() {
        return root;
    }

    public IntegerBinaryTreeNode findValue(int value) {
        IntegerBinaryTreeNode currentNode = getRoot();

        while (currentNode != null){
            if(currentNode.getValue() == value){
                return  currentNode;
            }

            if(currentNode.getValue() > value){
                currentNode = currentNode.getLeftChildNode();
            }
            else {
                currentNode = currentNode.getRightChildNode();
            }
        }

        return  currentNode;
    }
}