
import java.util.ArrayList;

public class IntegerBinaryTree {
    private int count = 0;
    private IntegerBinaryTreeNode root;

    public IntegerBinaryTree() {
    }

    public IntegerBinaryTree(ArrayList<Integer> elements) {
        int size = elements.size();
        for (int i = 0; i < size; ++i) {
            insert(elements.get(i));
        }
    }

    public IntegerBinaryTreeNode getRoot() {
        return root;
    }

    public int size() {
        return count;
    }

    public IntegerBinaryTreeNode insert(int newValue) {
        if (root == null) {
            root = new IntegerBinaryTreeNode(newValue);
            ++count;
            return root;
        }
        IntegerBinaryTreeNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.getValue() > newValue) {
                if (currentNode.getLeftChildNode() == null) {
                    IntegerBinaryTreeNode newNode = new IntegerBinaryTreeNode(newValue);
                    currentNode.setLeftChildNode(newNode);
                    ++count;
                    return newNode;
                }
                currentNode = currentNode.getLeftChildNode();
            } else if (currentNode.getValue() < newValue) {
                if (currentNode.getRightChildNode() == null) {
                    IntegerBinaryTreeNode newNode = new IntegerBinaryTreeNode(newValue);
                    currentNode.setRightChildNode(newNode);
                    ++count;
                    return newNode;
                }
                currentNode = currentNode.getRightChildNode();
            } else {
                return currentNode;
            }

        }
        return currentNode;
    }

    public IntegerBinaryTreeNode findValue(int value) {
        IntegerBinaryTreeNode currentNode = getRoot();

        while (currentNode != null) {
            if (currentNode.getValue() == value) {
                return currentNode;
            }

            if (currentNode.getValue() > value) {
                currentNode = currentNode.getLeftChildNode();
            } else {
                currentNode = currentNode.getRightChildNode();
            }
        }

        return currentNode;
    }
}