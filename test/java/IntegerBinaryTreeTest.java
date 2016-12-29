import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IntegerBinaryTreeTest {

    @Test
    public void should_be_able_to_create_am_empty_tree() throws Exception {

        IntegerBinaryTree binaryTree = new IntegerBinaryTree();
        assertNotNull(binaryTree);

    }

    @Test
    public void should_be_able_to_create_binary_tree_with_elements() throws Exception {
        IntegerBinaryTree binaryTree = createATreeWith3Nodes(1, 4, 3);

        assertNotNull(binaryTree);
    }


    @Test
    public void should_be_able_to_insert_an_element() throws Exception {
        IntegerBinaryTree binaryTree = new IntegerBinaryTree();
        assertEquals(binaryTree.size(), 0);

        binaryTree.insert(3);
        assertEquals(binaryTree.size(), 1);

    }

    @Test
    public void should_have_a_root_node_if_the_tree_is_not_empty() throws Exception {
        IntegerBinaryTree integerBinaryTree = createATreeWith3Nodes(1, 4, 3);

        assertNotNull(integerBinaryTree);
        assertNotNull(integerBinaryTree.getRoot());

    }

    @Test
    public void should__be_able_to_insert_a_new_node_to_an_empty_tree() throws Exception {
        IntegerBinaryTree integerBinaryTree = new IntegerBinaryTree();

        integerBinaryTree.insert(5);

        Assert.assertNotNull(integerBinaryTree.findValue(5));
        assertEquals(integerBinaryTree.size(), 1);
    }

    @Test
    public void should_be_able_to_insert_multiple_new_nodes_to_an_empty_tree() throws Exception {

        IntegerBinaryTree integerBinaryTree = new IntegerBinaryTree();

        integerBinaryTree.insert(5);

        Assert.assertNotNull(integerBinaryTree.findValue(5));

        integerBinaryTree.insert(15);

        Assert.assertNotNull(integerBinaryTree.findValue(15));
        Assert.assertEquals(integerBinaryTree.size(), 2);
    }

    @Test
    public void should__be_able_to_insert_a_new_node_to_an_non_empty_tree() throws Exception {
        IntegerBinaryTree integerBinaryTree = createATreeWith3Nodes(1, 4, 3);
        Assert.assertEquals(integerBinaryTree.size(), 3);

        integerBinaryTree.insert(5);

        Assert.assertNotNull(integerBinaryTree.findValue(5));
        Assert.assertEquals(integerBinaryTree.size(), 4);
    }

    @Test
    public void should_be_able_to_insert_multiple_new_nodes_to_an_non_empty_tree() throws Exception {

        IntegerBinaryTree integerBinaryTree = createATreeWith3Nodes(1, 4, 3);
        Assert.assertEquals(integerBinaryTree.size(), 3);

        integerBinaryTree.insert(5);

        Assert.assertNotNull(integerBinaryTree.findValue(5));
        Assert.assertEquals(integerBinaryTree.size(), 4);

        integerBinaryTree.insert(15);

        Assert.assertNotNull(integerBinaryTree.findValue(15));
        Assert.assertEquals(integerBinaryTree.size(), 5);
    }

    @Test
    public void should_still_be_a_binary_tree_after_new_nodes_are_inserted() throws Exception {
        IntegerBinaryTree integerBinaryTree = createATreeWith3Nodes(1, 4, 3);
        Assert.assertEquals(integerBinaryTree.size(), 3);

        integerBinaryTree.insert(5);
        integerBinaryTree.insert(15);
        integerBinaryTree.insert(0);

        Assert.assertTrue(isBinaryTree(integerBinaryTree));
    }

    @Test
    public void should_be_able_to_delete_a_node() throws Exception, IntegerBinaryTreeNodeNotFoundError {
        IntegerBinaryTree integerBinaryTree = createATreeWith3Nodes(1, 4, 3);
        Assert.assertEquals(integerBinaryTree.size(), 3);


        integerBinaryTree.delete(1);

        Assert.assertEquals(integerBinaryTree.size(), 2);
    }



    private boolean isBinaryTree(IntegerBinaryTree integerBinaryTree) {
        IntegerBinaryTreeNode currentNode = integerBinaryTree.getRoot();

        return isBinaryTree(currentNode);
    }

    private boolean isBinaryTree(IntegerBinaryTreeNode currentNode) {
        boolean isBinaryTree = true;
        IntegerBinaryTreeNode leftChildNode = currentNode.getLeftChildNode();
        IntegerBinaryTreeNode rightChildNode = currentNode.getRightChildNode();
        if (leftChildNode != null) {
            if (leftChildNode.getValue() > currentNode.getValue()) {
                return false;
            }

            isBinaryTree &= isBinaryTree(leftChildNode);
            if (!isBinaryTree) {
                return false;
            }
        }
        if (rightChildNode != null) {
            if (rightChildNode.getValue() < currentNode.getValue()) {
                return false;
            }
            isBinaryTree &= isBinaryTree(rightChildNode);
            if (!isBinaryTree) {
                return false;
            }
        }

        return true;
    }

    private IntegerBinaryTree createATreeWith3Nodes(int val1, int val2, int val3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(val1);
        arrayList.add(val2);
        arrayList.add(val3);
        return new IntegerBinaryTree(arrayList);
    }
}
