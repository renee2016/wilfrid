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
        IntegerBinaryTree binaryTree = createATreeWith3Nodes();

        assertNotNull(binaryTree);
    }

    private IntegerBinaryTree createATreeWith3Nodes() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(3);
        return new IntegerBinaryTree(arrayList);
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
        IntegerBinaryTree integerBinaryTree = createATreeWith3Nodes();

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
        Assert.assertEquals(integerBinaryTree.size(),2);
    }

    @Test
    public void should__be_able_to_insert_a_new_node_to_an_non_empty_tree() throws Exception {
        IntegerBinaryTree integerBinaryTree =createATreeWith3Nodes();
        Assert.assertEquals(integerBinaryTree.size(), 3);

        integerBinaryTree.insert(5);

        Assert.assertNotNull(integerBinaryTree.findValue(5));
        Assert.assertEquals(integerBinaryTree.size(), 4);
    }

    @Test
    public void should_be_able_to_insert_multiple_new_nodes_to_an_non_empty_tree() throws Exception {

        IntegerBinaryTree integerBinaryTree =createATreeWith3Nodes();
        Assert.assertEquals(integerBinaryTree.size(), 3);

        integerBinaryTree.insert(5);

        Assert.assertNotNull(integerBinaryTree.findValue(5));
        Assert.assertEquals(integerBinaryTree.size(), 4);

        integerBinaryTree.insert(15);

        Assert.assertNotNull(integerBinaryTree.findValue(15));
        Assert.assertEquals(integerBinaryTree.size(), 5);
    }
}
