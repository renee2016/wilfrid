
import java.util.ArrayList;

public class IntegerBinarySearchTree {
    private int count = 0;
    private IntegerBinaryTreeNode root;

    public IntegerBinarySearchTree() {
    }

    public IntegerBinarySearchTree(ArrayList<Integer> elements) {
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
                    newNode.setParentNode(currentNode);
                    ++count;
                    return newNode;
                }
                currentNode = currentNode.getLeftChildNode();
            } else if (currentNode.getValue() < newValue) {
                if (currentNode.getRightChildNode() == null) {
                    IntegerBinaryTreeNode newNode = new IntegerBinaryTreeNode(newValue);
                    currentNode.setRightChildNode(newNode);
                    newNode.setParentNode(currentNode);
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

    public static ArrayList<IntegerBinaryTreeNode> inOrderTraverse(IntegerBinaryTreeNode rootNode) {
        ArrayList<IntegerBinaryTreeNode> sortedNodes = new ArrayList<IntegerBinaryTreeNode>();
        return inOrderTraverse(rootNode, sortedNodes);
    }

    public void delete(int value) throws IntegerBinaryTreeNodeNotFoundError {
        IntegerBinaryTreeNode nodeToDelete = findValue(value);

        if (nodeToDelete == null) {
            throw new IntegerBinaryTreeNodeNotFoundError(value);
        }

        deleteNode(nodeToDelete);
    }

    private void deleteNode(IntegerBinaryTreeNode nodeToDelete) {
        if (isLeaf(nodeToDelete)) {
            deleteLeafNode(nodeToDelete);
            return;
        }

        if (has1ChildNodeOnly(nodeToDelete)) {
            deleteNodeWithOnly1ChildNode(nodeToDelete);
            return;
        }

        IntegerBinaryTreeNode minimumChild = findNodeWithMinimumValueInRightSubTree(nodeToDelete);
        nodeToDelete.setValue(minimumChild.getValue());
        deleteNode(minimumChild);
    }

    private void deleteNodeWithOnly1ChildNode(IntegerBinaryTreeNode nodeToDelete) {
        IntegerBinaryTreeNode parentNode = nodeToDelete.getParentNode();
        IntegerBinaryTreeNode childNode = getChildNode(nodeToDelete);

        if (parentNode == null) {
            root = childNode;
            count--;
            return;
        }
        ;
        if (isLeftChildNode(parentNode, nodeToDelete)) {
            parentNode.setLeftChildNode(childNode);
        } else if (isRightChildNode(parentNode, nodeToDelete)) {
            parentNode.setRightChildNode(childNode);
        }

        childNode.setParentNode(parentNode);
        nodeToDelete.setParentNode(null);
        count--;
    }

    private void deleteLeafNode(IntegerBinaryTreeNode nodeToDelete) {
        IntegerBinaryTreeNode parentNode = nodeToDelete.getParentNode();

        if (parentNode == null) {
            root = null;
            count = 0;
            return;
        }

        deleteFromParent(parentNode, nodeToDelete);
        count--;
        return;
    }

    private void deleteFromParent(IntegerBinaryTreeNode parentNode, IntegerBinaryTreeNode nodeToDelete) {
        if (parentNode.getRightChildNode() == nodeToDelete) {
            parentNode.setRightChildNode(null);
            nodeToDelete.setParentNode(null);
        } else if (parentNode.getLeftChildNode() == nodeToDelete) {
            parentNode.setLeftChildNode(null);
            nodeToDelete.setParentNode(null);
        }
    }

    private static ArrayList<IntegerBinaryTreeNode> inOrderTraverse(IntegerBinaryTreeNode rootNode, ArrayList<IntegerBinaryTreeNode> sortedNodes) {
        IntegerBinaryTreeNode currentNode = rootNode;

        if (currentNode == null) {
            return sortedNodes;
        }

        if (isLeaf(currentNode)) {
            sortedNodes.add(currentNode);
            return sortedNodes;
        }

        inOrderTraverse(currentNode.getLeftChildNode(), sortedNodes);
        sortedNodes.add(currentNode);
        inOrderTraverse(currentNode.getRightChildNode(), sortedNodes);

        return sortedNodes;
    }

    private IntegerBinaryTreeNode findNodeWithMinimumValueInRightSubTree(IntegerBinaryTreeNode thisNode) {
        IntegerBinaryTreeNode rightChild = thisNode.getRightChildNode();
        if (rightChild == null)
            return null;

        ArrayList<IntegerBinaryTreeNode> nodesInLeftSubTree = inOrderTraverse(rightChild);
        return nodesInLeftSubTree.get(0);
    }

    private boolean isLeftChildNode(IntegerBinaryTreeNode parentNode, IntegerBinaryTreeNode thisNode) {
        return parentNode.getLeftChildNode() == thisNode;
    }

    private boolean isRightChildNode(IntegerBinaryTreeNode parentNode, IntegerBinaryTreeNode thisNode) {
        return parentNode.getRightChildNode() == thisNode;
    }

    private IntegerBinaryTreeNode getChildNode(IntegerBinaryTreeNode thisNode) {
        IntegerBinaryTreeNode leftChildNode = thisNode.getLeftChildNode();
        IntegerBinaryTreeNode rightChildNode = thisNode.getRightChildNode();

        if (leftChildNode != null) return leftChildNode;
        if (rightChildNode != null) return rightChildNode;

        return null;
    }

    private boolean has1ChildNodeOnly(IntegerBinaryTreeNode thisNode) {
        IntegerBinaryTreeNode leftChildNode = thisNode.getLeftChildNode();
        IntegerBinaryTreeNode rightChildNode = thisNode.getRightChildNode();

        return (leftChildNode == null || rightChildNode == null) && !(leftChildNode == null && rightChildNode == null);
    }

    private static boolean isLeaf(IntegerBinaryTreeNode thisNode) {
        return thisNode.getRightChildNode() == null && thisNode.getLeftChildNode() == null;
    }

}