import org.junit.Assert;
        import org.junit.Test;

public class IntegerBinaryTreeNodeTest {

    @Test
    public void should_be_able_to_set_a_left_child_node() throws Exception {
        IntegerBinaryTreeNode integerBinaryTreeNode = new IntegerBinaryTreeNode(10);

        integerBinaryTreeNode.setLeftChildNode(new IntegerBinaryTreeNode(5));

        IntegerBinaryTreeNode leftChildNode = integerBinaryTreeNode.getLeftChildNode();
        Assert.assertNotNull(leftChildNode);
        Assert.assertEquals(leftChildNode.getValue(), 5);

    }

    @Test
    public void should_be_able_to_set_right_child_node() throws Exception {

        IntegerBinaryTreeNode integerBinaryTreeNode = new IntegerBinaryTreeNode(10);

        integerBinaryTreeNode.setRightChildNode(new IntegerBinaryTreeNode(5));

        IntegerBinaryTreeNode rightChildNode = integerBinaryTreeNode.getRightChildNode();
        Assert.assertNotNull(rightChildNode);
        Assert.assertEquals(rightChildNode.getValue(), 5);
    }
}
