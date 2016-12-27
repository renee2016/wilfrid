public class IntegerBinaryTreeNode {
    private IntegerBinaryTreeNode leftChildNode;
    private IntegerBinaryTreeNode rightChildNode;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;

    public IntegerBinaryTreeNode(int value) {
        this.value = value;
    }

    public IntegerBinaryTreeNode getLeftChildNode() {
        return leftChildNode;
    }

    public void setLeftChildNode(IntegerBinaryTreeNode leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public void setRightChildNode(IntegerBinaryTreeNode rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    public IntegerBinaryTreeNode getRightChildNode() {
        return rightChildNode;
    }
}
